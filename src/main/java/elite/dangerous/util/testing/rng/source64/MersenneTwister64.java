/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import java.util.Arrays;

import elite.dangerous.util.testing.rng.NumberFactory;

public class MersenneTwister64 extends LongProvider
{
    private static final int    NN    = 312;
    private static final int    MM    = 156;
    private static final long[] MAG01 = {0x0L, 0xb5026f5aa96619e9L};
    private static final long   UM    = 0xffffffff80000000L;
    private static final long   LM    = 0x7fffffffL;
    private final long[]        mt    = new long[NN];
    private int                 mti;

    public MersenneTwister64(long[] seed)
    {
        setSeedInternal(seed);
    }

    @Override
    protected byte[] getStateInternal()
    {
        final long[] s = Arrays.copyOf(mt, NN + 1);
        s[NN] = mti;
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (NN + 1) * 8);
        final long[] tmp = NumberFactory.makeLongArray(c[0]);
        System.arraycopy(tmp, 0, mt, 0, NN);
        mti = (int) tmp[NN];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(long[] inputSeed)
    {
        // Accept empty seed.
        final long[] seed = (inputSeed.length == 0) ? new long[1] : inputSeed;
        initState(19650218L);
        int i = 1;
        int j = 0;
        for (int k = Math.max(NN, seed.length); k != 0; k--)
        {
            final long mm1 = mt[i - 1];
            mt[i] = (mt[i] ^ ((mm1 ^ (mm1 >>> 62)) * 0x369dea0f31a53f85L)) + seed[j] + j; // non linear
            i++;
            j++;
            if (i >= NN)
            {
                mt[0] = mt[NN - 1];
                i = 1;
            }
            if (j >= seed.length)
            {
                j = 0;
            }
        }
        for (int k = NN - 1; k != 0; k--)
        {
            final long mm1 = mt[i - 1];
            mt[i] = (mt[i] ^ ((mm1 ^ (mm1 >>> 62)) * 0x27bb2ee687b0b0fdL)) - i; // non linear
            i++;
            if (i >= NN)
            {
                mt[0] = mt[NN - 1];
                i = 1;
            }
        }
        mt[0] = 0x8000000000000000L; // MSB is 1; assuring non-zero initial array
    }

    private void initState(long seed)
    {
        mt[0] = seed;
        for (mti = 1; mti < NN; mti++)
        {
            final long mm1 = mt[mti - 1];
            mt[mti] = 0x5851f42d4c957f2dL * (mm1 ^ (mm1 >>> 62)) + mti;
        }
    }

    @Override
    public long next()
    {
        long x;
        if (mti >= NN)
        { // generate NN words at one time
            for (int i = 0; i < NN - MM; i++)
            {
                x = (mt[i] & UM) | (mt[i + 1] & LM);
                mt[i] = mt[i + MM] ^ (x >>> 1) ^ MAG01[(int) (x & 0x1L)];
            }
            for (int i = NN - MM; i < NN - 1; i++)
            {
                x = (mt[i] & UM) | (mt[i + 1] & LM);
                mt[i] = mt[i + (MM - NN)] ^ (x >>> 1) ^ MAG01[(int) (x & 0x1L)];
            }
            x = (mt[NN - 1] & UM) | (mt[0] & LM);
            mt[NN - 1] = mt[MM - 1] ^ (x >>> 1) ^ MAG01[(int) (x & 0x1L)];
            mti = 0;
        }
        x = mt[mti++];
        x ^= (x >>> 29) & 0x5555555555555555L;
        x ^= (x << 17) & 0x71d67fffeda60000L;
        x ^= (x << 37) & 0xfff7eee000000000L;
        x ^= x >>> 43;
        return x;
    }
}
