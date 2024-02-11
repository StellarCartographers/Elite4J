/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

import java.util.Arrays;

import elite.dangerous.util.testing.rng.NumberFactory;

public class MiddleSquareWeylSequence extends IntProvider
{
    private static final int    SEED_SIZE    = 3;
    private static final long[] DEFAULT_SEED = {0x012de1babb3c4104L, 0xc8161b4202294965L, 0xb5ad4eceda1ce2a9L};
    private long                x;
    private long                w;
    private long                s;

    public MiddleSquareWeylSequence(long[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            // Complete the seed with a default to avoid
            // low complexity Weyl increments.
            final long[] tmp = Arrays.copyOf(seed, SEED_SIZE);
            System.arraycopy(DEFAULT_SEED, seed.length, tmp, seed.length, SEED_SIZE - seed.length);
            setSeedInternal(tmp);
        } else
        {
            setSeedInternal(seed);
        }
    }

    private void setSeedInternal(long[] seed)
    {
        x = seed[0];
        w = seed[1];
        // Ensure the increment is odd to provide a maximal period Weyl sequence.
        this.s = seed[2] | 1L;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{x, w, s}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] state)
    {
        final byte[][] c = splitStateInternal(state, SEED_SIZE * 8);
        setSeedInternal(NumberFactory.makeLongArray(c[0]));
        super.setStateInternal(c[1]);
    }

    @Override
    public int next()
    {
        x *= x;
        x += w += s;
        x = (x >>> 32) | (x << 32);
        return (int) x;
    }

    @Override
    public long nextLong()
    {
        // Avoid round trip from long to int to long by performing two iterations inline
        x *= x;
        x += w += s;
        final long i1 = x & 0xffffffff00000000L;
        x = (x >>> 32) | (x << 32);
        x *= x;
        x += w += s;
        final long i2 = x >>> 32;
        x = i2 | x << 32;
        return i1 | i2;
    }
}
