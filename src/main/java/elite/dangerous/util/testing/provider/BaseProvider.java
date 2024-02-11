/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.provider;

import java.util.Arrays;

import elite.dangerous.util.testing.rng.*;

public abstract class BaseProvider implements RestorableUniformRandomProvider
{
    private static final long GOLDEN_RATIO_64 = 0x9e3779b97f4a7c15L;
    private static final int  GOLDEN_RATIO_32 = 0x9e3779b9;

    @Override
    public RandomProviderState saveState()
    {
        return new RandomProviderDefaultState(getStateInternal());
    }

    @Override
    public void restoreState(RandomProviderState state)
    {
        if (state instanceof RandomProviderDefaultState)
        {
            setStateInternal(((RandomProviderDefaultState) state).getState());
        } else
        {
            throw new IllegalArgumentException("Foreign instance");
        }
    }

    @Override
    public String toString()
    {
        return getClass().getName();
    }

    protected byte[] composeStateInternal(byte[] state, byte[] parentState)
    {
        final int len = parentState.length + state.length;
        final byte[] c = new byte[len];
        System.arraycopy(state, 0, c, 0, state.length);
        System.arraycopy(parentState, 0, c, state.length, parentState.length);
        return c;
    }

    protected byte[][] splitStateInternal(byte[] state, int localStateLength)
    {
        checkStateSize(state, localStateLength);
        final byte[] local = new byte[localStateLength];
        System.arraycopy(state, 0, local, 0, localStateLength);
        final int parentLength = state.length - localStateLength;
        final byte[] parent = new byte[parentLength];
        System.arraycopy(state, localStateLength, parent, 0, parentLength);
        return new byte[][]{local, parent};
    }

    protected byte[] getStateInternal()
    {
        // This class has no state (and is the top-level class that
        // declares this method).
        return new byte[0];
    }

    protected void setStateInternal(byte[] state)
    {
        if (state.length != 0)
        {
            // This class has no state.
            throw new IllegalStateException("State not fully recovered by subclasses");
        }
    }

    protected void fillState(int[] state, int[] seed)
    {
        final int stateSize = state.length;
        final int seedSize = seed.length;
        System.arraycopy(seed, 0, state, 0, Math.min(seedSize, stateSize));
        if (seedSize < stateSize)
        {
            for (int i = seedSize; i < stateSize; i++)
            {
                state[i] = (int) (scrambleWell(state[i - seed.length], i) & 0xffffffffL);
            }
        }
    }

    protected void fillState(long[] state, long[] seed)
    {
        final int stateSize = state.length;
        final int seedSize = seed.length;
        System.arraycopy(seed, 0, state, 0, Math.min(seedSize, stateSize));
        if (seedSize < stateSize)
        {
            for (int i = seedSize; i < stateSize; i++)
            {
                state[i] = scrambleWell(state[i - seed.length], i);
            }
        }
    }

    @Deprecated
    protected void checkStateSize(byte[] state, int expected)
    {
        if (state.length < expected)
        {
            throw new IllegalStateException("State size must be larger than " + expected + " but was " + state.length);
        }
    }

    protected void checkIndex(int min, int max, int index)
    {
        if (index < min || index > max)
        {
            throw new IndexOutOfBoundsException(index + " is out of interval [" + min + ", " + max + "]");
        }
    }

    private static long scramble(long n, long mult, int shift, int add)
    {
        // Code inspired from "AbstractWell" class.
        return mult * (n ^ (n >> shift)) + add;
    }

    private static long scrambleWell(long n, int add)
    {
        // Code inspired from "AbstractWell" class.
        return scramble(n, 1812433253L, 30, add);
    }

    protected static long[] extendSeed(long[] seed, int length)
    {
        if (seed.length < length)
        {
            final long[] s = Arrays.copyOf(seed, length);
            // Fill the rest as if using a SplitMix64 RNG
            long x = s[0];
            for (int i = seed.length; i < length; i++)
            {
                s[i] = stafford13(x += GOLDEN_RATIO_64);
            }
            return s;
        }
        return seed;
    }

    protected static int[] extendSeed(int[] seed, int length)
    {
        if (seed.length < length)
        {
            final int[] s = Arrays.copyOf(seed, length);
            // Fill the rest as if using a SplitMix64-style RNG for 32-bit output
            int x = s[0];
            for (int i = seed.length; i < length; i++)
            {
                s[i] = murmur3(x += GOLDEN_RATIO_32);
            }
            return s;
        }
        return seed;
    }

    private static long stafford13(long x)
    {
        x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
        x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
        return x ^ (x >>> 31);
    }

    private static int murmur3(int x)
    {
        x = (x ^ (x >>> 16)) * 0x85ebca6b;
        x = (x ^ (x >>> 13)) * 0xc2b2ae35;
        return x ^ (x >>> 16);
    }
}
