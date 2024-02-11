/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import java.util.stream.Stream;

import elite.dangerous.util.testing.provider.*;
import elite.dangerous.util.testing.rng.*;

public class L64X1024Mix extends AbstractL64 implements SplittableUniformRandomProvider
{
    private static final int  SEED_SIZE      = 18;
    private static final int  XBG_STATE_SIZE = 16;
    private static final int  LCG_STATE_SIZE = SEED_SIZE - XBG_STATE_SIZE;
    private static final long M              = LXMSupport.M64;
    private final long[]      x              = new long[XBG_STATE_SIZE];
    private int               index;

    public L64X1024Mix(long[] seed)
    {
        super(seed = extendSeed(seed, SEED_SIZE));
        System.arraycopy(seed, SEED_SIZE - XBG_STATE_SIZE, x, 0, XBG_STATE_SIZE);
        // Initialising to 15 ensures that (index + 1) % 16 == 0 and the
        // first state picked from the XBG generator is state[0].
        index = XBG_STATE_SIZE - 1;
    }

    protected L64X1024Mix(L64X1024Mix source)
    {
        super(source);
        System.arraycopy(source.x, 0, x, 0, XBG_STATE_SIZE);
        index = source.index;
    }

    @Override
    protected byte[] getStateInternal()
    {
        final long[] s = new long[XBG_STATE_SIZE + 1];
        System.arraycopy(x, 0, s, 0, XBG_STATE_SIZE);
        s[XBG_STATE_SIZE] = index;
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (XBG_STATE_SIZE + 1) * Long.BYTES);
        final long[] tmp = NumberFactory.makeLongArray(c[0]);
        System.arraycopy(tmp, 0, x, 0, XBG_STATE_SIZE);
        index = (int) tmp[XBG_STATE_SIZE];
        super.setStateInternal(c[1]);
    }

    @Override
    public long next()
    {
        // LXM generate.
        // Old state is used for the output allowing parallel pipelining
        // on processors that support multiple concurrent instructions.
        final int q = index;
        index = (q + 1) & 15;
        final long s0 = x[index];
        long s15 = x[q];
        final long s = ls;
        // Mix
        final long z = LXMSupport.lea64(s + s0);
        // LCG update
        ls = M * s + la;
        // XBG update
        s15 ^= s0;
        x[q] = Long.rotateLeft(s0, 25) ^ s15 ^ (s15 << 27);
        x[index] = Long.rotateLeft(s15, 36);
        return z;
    }

    @Override
    public UniformRandomProvider jump()
    {
        return super.jump();
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        return super.longJump();
    }

    @Override
    AbstractL64 copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new L64X1024Mix(this);
    }

    @Override
    public SplittableUniformRandomProvider split(UniformRandomProvider source)
    {
        return create(source.nextLong(), source);
    }

    @Override
    public Stream<SplittableUniformRandomProvider> splits(long streamSize, SplittableUniformRandomProvider source)
    {
        return RandomStreams.generateWithSeed(streamSize, source, L64X1024Mix::create);
    }

    private static SplittableUniformRandomProvider create(long seed, UniformRandomProvider source)
    {
        final long[] s = new long[SEED_SIZE];
        // LCG state. The addition uses the input seed.
        // The LCG addition parameter is set to odd so left-shift the seed.
        s[0] = seed << 1;
        s[1] = source.nextLong();
        // XBG state must not be all zero
        long x = 0;
        for (int i = LCG_STATE_SIZE; i < s.length; i++)
        {
            s[i] = source.nextLong();
            x |= s[i];
        }
        if (x == 0)
        {
            // SplitMix style seed ensures at least one non-zero value
            x = s[LCG_STATE_SIZE - 1];
            for (int i = LCG_STATE_SIZE; i < s.length; i++)
            {
                s[i] = LXMSupport.lea64(x);
                x += LXMSupport.GOLDEN_RATIO_64;
            }
        }
        return new L64X1024Mix(s);
    }
}
