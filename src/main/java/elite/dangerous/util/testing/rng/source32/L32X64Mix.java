/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

import java.util.stream.Stream;

import elite.dangerous.util.testing.provider.*;
import elite.dangerous.util.testing.rng.*;

public final class L32X64Mix extends IntProvider implements LongJumpableUniformRandomProvider, SplittableUniformRandomProvider
{
    // Implementation note:
    // This does not extend AbstractXoRoShiRo64 as the XBG function is re-implemented
    // inline to allow parallel pipelining. Inheritance would provide only the XBG state.
    private static final int M         = LXMSupport.M32;
    private static final int SEED_SIZE = 4;
    private int              la;
    private int              ls;
    private int              x0;
    private int              x1;

    public L32X64Mix(int[] seed)
    {
        setState(extendSeed(seed, SEED_SIZE));
    }

    public L32X64Mix(int seed0, int seed1, int seed2, int seed3)
    {
        // Additive parameter must be odd
        la = seed0 | 1;
        ls = seed1;
        x0 = seed2;
        x1 = seed3;
    }

    private L32X64Mix(L32X64Mix source)
    {
        super(source);
        la = source.la;
        ls = source.ls;
        x0 = source.x0;
        x1 = source.x1;
    }

    private void setState(int[] state)
    {
        // Additive parameter must be odd
        la = state[0] | 1;
        ls = state[1];
        x0 = state[2];
        x1 = state[3];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new int[]{la, ls, x0, x1}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * Integer.BYTES);
        setState(NumberFactory.makeIntArray(c[0]));
        super.setStateInternal(c[1]);
    }

    @Override
    public int next()
    {
        // LXM generate.
        // Old state is used for the output allowing parallel pipelining
        // on processors that support multiple concurrent instructions.
        final int s0 = x0;
        final int s = ls;
        // Mix
        final int z = LXMSupport.lea32(s + s0);
        // LCG update
        ls = M * s + la;
        // XBG update
        int s1 = x1;
        s1 ^= s0;
        x0 = Integer.rotateLeft(s0, 26) ^ s1 ^ (s1 << 9); // a, b
        x1 = Integer.rotateLeft(s1, 13); // c
        return z;
    }

    @Override
    public UniformRandomProvider jump()
    {
        final UniformRandomProvider copy = new L32X64Mix(this);
        // Advance the LCG 1 step
        ls = M * ls + la;
        resetCachedState();
        return copy;
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        final JumpableUniformRandomProvider copy = new L32X64Mix(this);
        // Advance the LCG 2^16 steps
        ls = LXMSupport.M32P * ls + LXMSupport.C32P * la;
        resetCachedState();
        return copy;
    }

    @Override
    public SplittableUniformRandomProvider split(UniformRandomProvider source)
    {
        // The upper half of the long seed is discarded so use nextInt
        return create(source.nextInt(), source);
    }

    @Override
    public Stream<SplittableUniformRandomProvider> splits(long streamSize, SplittableUniformRandomProvider source)
    {
        return RandomStreams.generateWithSeed(streamSize, source, L32X64Mix::create);
    }

    private static SplittableUniformRandomProvider create(long seed, UniformRandomProvider source)
    {
        // LCG state. The addition uses the input seed.
        // The LCG addition parameter is set to odd so left-shift the seed.
        final int s0 = (int) seed << 1;
        final int s1 = source.nextInt();
        // XBG state must not be all zero
        int x0 = source.nextInt();
        int x1 = source.nextInt();
        if ((x0 | x1) == 0)
        {
            // SplitMix style seed ensures at least one non-zero value
            x0 = LXMSupport.lea32(s1);
            x1 = LXMSupport.lea32(s1 + LXMSupport.GOLDEN_RATIO_32);
        }
        return new L32X64Mix(s0, s1, x0, x1);
    }
}
