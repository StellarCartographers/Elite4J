/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import elite.dangerous.util.testing.provider.BaseProvider;
import elite.dangerous.util.testing.rng.NumberFactory;

public abstract class LongProvider extends BaseProvider implements RandomLongSource
{
    private static final long EMPTY_BOOL_SOURCE = 1;
    private static final long EMPTY_INT_SOURCE  = -1;
    private long              booleanSource     = EMPTY_BOOL_SOURCE;
    private long              intSource         = EMPTY_INT_SOURCE;

    public LongProvider()
    {
        super();
    }

    protected LongProvider(LongProvider source)
    {
        booleanSource = source.booleanSource;
        intSource = source.intSource;
    }

    protected void resetCachedState()
    {
        booleanSource = EMPTY_BOOL_SOURCE;
        intSource = EMPTY_INT_SOURCE;
    }

    @Override
    protected byte[] getStateInternal()
    {
        final long[] state = {booleanSource, intSource};
        return composeStateInternal(NumberFactory.makeByteArray(state), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, 2 * Long.BYTES);
        final long[] state = NumberFactory.makeLongArray(c[0]);
        booleanSource = state[0];
        intSource = state[1];
        super.setStateInternal(c[1]);
    }

    @Override
    public long nextLong()
    {
        return next();
    }

    @Override
    public int nextInt()
    {
        long bits = intSource;
        if (bits < 0)
        {
            // Refill
            bits = next();
            // Store high 32 bits, return low 32 bits
            intSource = bits >>> 32;
            return (int) bits;
        }
        // Reset and return previous low bits
        intSource = -1;
        return (int) bits;
    }

    @Override
    public boolean nextBoolean()
    {
        long bits = booleanSource;
        if (bits == 1)
        {
            // Refill
            bits = next();
            // Store a refill flag in the sign bit and the unused 63 bits, return lowest bit
            booleanSource = Long.MIN_VALUE | (bits >>> 1);
            return (bits & 0x1) == 1;
        }
        // Shift down eventually triggering refill, return current lowest bit
        booleanSource = bits >>> 1;
        return (bits & 0x1) == 1;
    }
}
