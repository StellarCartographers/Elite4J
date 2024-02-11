/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import elite.dangerous.util.testing.rng.NumberFactory;

public class SplitMix64 extends LongProvider
{
    private long state;

    public SplitMix64(long seed)
    {
        state = seed;
    }

    public SplitMix64(Long seed)
    {
        // Support for Long to allow instantiation through the
        // rng.simple.RandomSource factory methods.
        setSeedInternal(seed);
    }

    private void setSeedInternal(Long seed)
    {
        state = seed.longValue();
    }

    @Override
    public long next()
    {
        long z = state += 0x9e3779b97f4a7c15L;
        z = (z ^ (z >>> 30)) * 0xbf58476d1ce4e5b9L;
        z = (z ^ (z >>> 27)) * 0x94d049bb133111ebL;
        return z ^ (z >>> 31);
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(state), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, 8);
        state = NumberFactory.makeLong(c[0]);
        super.setStateInternal(c[1]);
    }
}
