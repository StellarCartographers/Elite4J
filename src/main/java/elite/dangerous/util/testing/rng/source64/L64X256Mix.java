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

public class L64X256Mix extends AbstractL64 implements SplittableUniformRandomProvider
{
    private static final int  SEED_SIZE      = 6;
    private static final int  XBG_STATE_SIZE = 4;
    private static final long M              = LXMSupport.M64;
    private long              x0;
    private long              x1;
    private long              x2;
    private long              x3;

    public L64X256Mix(long[] seed)
    {
        super(seed = extendSeed(seed, SEED_SIZE));
        x0 = seed[2];
        x1 = seed[3];
        x2 = seed[4];
        x3 = seed[5];
    }

    public L64X256Mix(long seed0, long seed1, long seed2, long seed3, long seed4, long seed5)
    {
        super(seed0, seed1);
        x0 = seed2;
        x1 = seed3;
        x2 = seed4;
        x3 = seed5;
    }

    protected L64X256Mix(L64X256Mix source)
    {
        super(source);
        x0 = source.x0;
        x1 = source.x1;
        x2 = source.x2;
        x3 = source.x3;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{x0, x1, x2, x3}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, XBG_STATE_SIZE * Long.BYTES);
        final long[] tmp = NumberFactory.makeLongArray(c[0]);
        x0 = tmp[0];
        x1 = tmp[1];
        x2 = tmp[2];
        x3 = tmp[3];
        super.setStateInternal(c[1]);
    }

    @Override
    public long next()
    {
        // LXM generate.
        // Old state is used for the output allowing parallel pipelining
        // on processors that support multiple concurrent instructions.
        long s0 = x0;
        final long s = ls;
        // Mix
        final long z = LXMSupport.lea64(s + s0);
        // LCG update
        ls = M * s + la;
        // XBG update
        long s1 = x1;
        long s2 = x2;
        long s3 = x3;
        final long t = s1 << 17;
        s2 ^= s0;
        s3 ^= s1;
        s1 ^= s2;
        s0 ^= s3;
        s2 ^= t;
        s3 = Long.rotateLeft(s3, 45);
        x0 = s0;
        x1 = s1;
        x2 = s2;
        x3 = s3;
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
        return new L64X256Mix(this);
    }

    @Override
    public SplittableUniformRandomProvider split(UniformRandomProvider source)
    {
        return create(source.nextLong(), source);
    }

    @Override
    public Stream<SplittableUniformRandomProvider> splits(long streamSize, SplittableUniformRandomProvider source)
    {
        return RandomStreams.generateWithSeed(streamSize, source, L64X256Mix::create);
    }

    private static SplittableUniformRandomProvider create(long seed, UniformRandomProvider source)
    {
        // LCG state. The addition uses the input seed.
        // The LCG addition parameter is set to odd so left-shift the seed.
        final long s0 = seed << 1;
        final long s1 = source.nextLong();
        // XBG state must not be all zero
        long x0 = source.nextLong();
        long x1 = source.nextLong();
        long x2 = source.nextLong();
        long x3 = source.nextLong();
        if ((x0 | x1 | x2 | x3) == 0)
        {
            // SplitMix style seed ensures at least one non-zero value
            long z = s1;
            x0 = LXMSupport.lea64(z);
            x1 = LXMSupport.lea64(z += LXMSupport.GOLDEN_RATIO_64);
            x2 = LXMSupport.lea64(z += LXMSupport.GOLDEN_RATIO_64);
            x3 = LXMSupport.lea64(z + LXMSupport.GOLDEN_RATIO_64);
        }
        return new L64X256Mix(s0, s1, x0, x1, x2, x3);
    }
}
