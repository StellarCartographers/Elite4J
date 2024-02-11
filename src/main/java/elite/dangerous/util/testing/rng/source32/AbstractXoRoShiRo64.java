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

abstract class AbstractXoRoShiRo64 extends IntProvider
{
    private static final int SEED_SIZE = 2;
    // State is maintained using variables rather than an array for performance
    protected int            state0;
    protected int            state1;

    AbstractXoRoShiRo64(int[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            final int[] state = new int[SEED_SIZE];
            fillState(state, seed);
            setState(state);
        } else
        {
            setState(seed);
        }
    }

    AbstractXoRoShiRo64(int seed0, int seed1)
    {
        state0 = seed0;
        state1 = seed1;
    }

    private void setState(int[] state)
    {
        state0 = state[0];
        state1 = state[1];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new int[]{state0, state1}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * 4);
        setState(NumberFactory.makeIntArray(c[0]));
        super.setStateInternal(c[1]);
    }

    @Override
    public int next()
    {
        final int result = nextOutput();
        final int s0 = state0;
        int s1 = state1;
        s1 ^= s0;
        state0 = Integer.rotateLeft(s0, 26) ^ s1 ^ (s1 << 9); // a, b
        state1 = Integer.rotateLeft(s1, 13); // c
        return result;
    }

    protected abstract int nextOutput();
}
