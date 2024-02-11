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
import elite.dangerous.util.testing.rng.RandomStreams;

public class L64X128Mix extends AbstractL64X128 implements SplittableUniformRandomProvider
{
    public L64X128Mix(long[] seed)
    {
        super(seed);
    }

    public L64X128Mix(long seed0, long seed1, long seed2, long seed3)
    {
        super(seed0, seed1, seed2, seed3);
    }

    protected L64X128Mix(L64X128Mix source)
    {
        super(source);
    }

    @Override
    public long next()
    {
        // LXM generate.
        // Old state is used for the output allowing parallel pipelining
        // on processors that support multiple concurrent instructions.
        final long s0 = x0;
        final long s = ls;
        // Mix
        final long z = LXMSupport.lea64(s + s0);
        // LCG update
        ls = M * s + la;
        // XBG update
        long s1 = x1;
        s1 ^= s0;
        x0 = Long.rotateLeft(s0, 24) ^ s1 ^ (s1 << 16); // a, b
        x1 = Long.rotateLeft(s1, 37); // c
        return z;
    }

    @Override
    protected L64X128Mix copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new L64X128Mix(this);
    }

    @Override
    public SplittableUniformRandomProvider split(UniformRandomProvider source)
    {
        return create(source.nextLong(), source);
    }

    @Override
    public Stream<SplittableUniformRandomProvider> splits(long streamSize, SplittableUniformRandomProvider source)
    {
        return RandomStreams.generateWithSeed(streamSize, source, L64X128Mix::create);
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
        if ((x0 | x1) == 0)
        {
            // SplitMix style seed ensures at least one non-zero value
            x0 = LXMSupport.lea64(s1);
            x1 = LXMSupport.lea64(s1 + LXMSupport.GOLDEN_RATIO_64);
        }
        return new L64X128Mix(s0, s1, x0, x1);
    }
}
