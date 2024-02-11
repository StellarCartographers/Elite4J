/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

import elite.dangerous.util.testing.rng.NumberFactory;

abstract class AbstractPcgMcg6432 extends IntProvider
{
    private long state;

    AbstractPcgMcg6432(Long seed)
    {
        // A seed of zero will result in a non-functional MCG; it must be odd for a maximal
        // period MCG. The multiplication factor always sets the 2 least-significant bits to 1
        // if they are already 1 so these are explicitly set. Bit k (zero-based) will have
        // period 2^(k-1) starting from bit 2 with a period of 1. Bit 63 has period 2^62.
        state = seed | 3;
    }

    private static long bump(long input)
    {
        return input * 6364136223846793005L;
    }

    @Override
    public int next()
    {
        final long x = state;
        state = bump(state);
        return transform(x);
    }

    protected abstract int transform(long x);

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(state), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] d = splitStateInternal(s, 8);
        // As per the constructor, ensure the lower 2 bits of state are set.
        state = NumberFactory.makeLong(d[0]) | 3;
        super.setStateInternal(d[1]);
    }
}
