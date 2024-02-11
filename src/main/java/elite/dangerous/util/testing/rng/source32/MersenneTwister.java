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

public class MersenneTwister extends IntProvider
{
    private static final long  INT_MASK_LONG   = 0xffffffffL;
    private static final long  UPPER_MASK_LONG = 0x80000000L;
    private static final long  LOWER_MASK_LONG = 0x7fffffffL;
    private static final int   UPPER_MASK      = 0x80000000;
    private static final int   LOWER_MASK      = 0x7fffffff;
    private static final int   N               = 624;
    private static final int   M               = 397;
    private static final int[] MAG01           = {0x0, 0x9908b0df};
    private final int[]        mt              = new int[N];
    private int                mti;

    public MersenneTwister(int[] seed)
    {
        setSeedInternal(seed);
    }

    @Override
    protected byte[] getStateInternal()
    {
        final int[] s = Arrays.copyOf(mt, N + 1);
        s[N] = mti;
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (N + 1) * 4);
        final int[] tmp = NumberFactory.makeIntArray(c[0]);
        System.arraycopy(tmp, 0, mt, 0, N);
        mti = tmp[N];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(int[] seed)
    {
        fillStateMersenneTwister(mt, seed);
        // Initial index.
        mti = N;
    }

    private static void fillStateMersenneTwister(int[] state, int[] inputSeed)
    {
        // Accept empty seed.
        final int[] seed = (inputSeed.length == 0) ? new int[1] : inputSeed;
        initializeState(state);
        final int nextIndex = mixSeedAndState(state, seed);
        mixState(state, nextIndex);
        state[0] = (int) UPPER_MASK_LONG; // MSB is 1, ensuring non-zero initial array.
    }

    private static void initializeState(int[] state)
    {
        long mt = 19650218 & INT_MASK_LONG;
        state[0] = (int) mt;
        for (int i = 1; i < state.length; i++)
        {
            mt = (1812433253L * (mt ^ (mt >> 30)) + i) & INT_MASK_LONG;
            state[i] = (int) mt;
        }
    }

    private static int mixSeedAndState(int[] state, final int[] seed)
    {
        final int stateSize = state.length;
        int i = 1;
        int j = 0;
        for (int k = Math.max(stateSize, seed.length); k > 0; k--)
        {
            final long a = (state[i] & LOWER_MASK_LONG) | ((state[i] < 0) ? UPPER_MASK_LONG : 0);
            final long b = (state[i - 1] & LOWER_MASK_LONG) | ((state[i - 1] < 0) ? UPPER_MASK_LONG : 0);
            final long c = (a ^ ((b ^ (b >> 30)) * 1664525L)) + seed[j] + j; // Non linear.
            state[i] = (int) (c & INT_MASK_LONG);
            i++;
            j++;
            if (i >= stateSize)
            {
                state[0] = state[stateSize - 1];
                i = 1;
            }
            if (j >= seed.length)
            {
                j = 0;
            }
        }
        return i;
    }

    private static void mixState(int[] state, int startIndex)
    {
        final int stateSize = state.length;
        int i = startIndex;
        for (int k = stateSize - 1; k > 0; k--)
        {
            final long a = (state[i] & LOWER_MASK_LONG) | ((state[i] < 0) ? UPPER_MASK_LONG : 0);
            final long b = (state[i - 1] & LOWER_MASK_LONG) | ((state[i - 1] < 0) ? UPPER_MASK_LONG : 0);
            final long c = (a ^ ((b ^ (b >> 30)) * 1566083941L)) - i; // Non linear.
            state[i] = (int) (c & INT_MASK_LONG);
            i++;
            if (i >= stateSize)
            {
                state[0] = state[stateSize - 1];
                i = 1;
            }
        }
    }

    @Override
    public int next()
    {
        int y;
        if (mti >= N)
        { // Generate N words at one time.
            int mtNext = mt[0];
            for (int k = 0; k < N - M; ++k)
            {
                final int mtCurr = mtNext;
                mtNext = mt[k + 1];
                y = (mtCurr & UPPER_MASK) | (mtNext & LOWER_MASK);
                mt[k] = mt[k + M] ^ (y >>> 1) ^ MAG01[y & 1];
            }
            for (int k = N - M; k < N - 1; ++k)
            {
                final int mtCurr = mtNext;
                mtNext = mt[k + 1];
                y = (mtCurr & UPPER_MASK) | (mtNext & LOWER_MASK);
                mt[k] = mt[k + (M - N)] ^ (y >>> 1) ^ MAG01[y & 1];
            }
            y = (mtNext & UPPER_MASK) | (mt[0] & LOWER_MASK);
            mt[N - 1] = mt[M - 1] ^ (y >>> 1) ^ MAG01[y & 1];
            mti = 0;
        }
        y = mt[mti++];
        // Tempering.
        y ^= y >>> 11;
        y ^= (y << 7) & 0x9d2c5680;
        y ^= (y << 15) & 0xefc60000;
        y ^= y >>> 18;
        return y;
    }
}
