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

public class MultiplyWithCarry256 extends IntProvider
{
    private static final int  Q_SIZE    = 256;
    private static final int  SEED_SIZE = Q_SIZE + 1;
    private static final long A         = 809430660;
    private final int[]       state     = new int[Q_SIZE];
    private int               index;
    private int               carry;

    public MultiplyWithCarry256(int[] seed)
    {
        setSeedInternal(seed);
    }

    @Override
    protected byte[] getStateInternal()
    {
        final int[] s = Arrays.copyOf(state, SEED_SIZE + 1);
        s[SEED_SIZE - 1] = carry;
        s[SEED_SIZE] = index;
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (SEED_SIZE + 1) * 4);
        final int[] tmp = NumberFactory.makeIntArray(c[0]);
        System.arraycopy(tmp, 0, state, 0, Q_SIZE);
        carry = tmp[SEED_SIZE - 1];
        index = tmp[SEED_SIZE];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(int[] seed)
    {
        // Reset the whole state of this RNG (i.e. "state" and "index").
        // Filling procedure is not part of the reference code.
        final int[] tmp = new int[SEED_SIZE];
        fillState(tmp, seed);
        // First element of the "seed" is the initial "carry".
        final int c = tmp[0];
        // Marsaglia's recommendation: 0 <= carry < A.
        carry = (int) (Math.abs(c) % A);
        // Initial state.
        System.arraycopy(tmp, 1, state, 0, Q_SIZE);
        // Initial index.
        index = Q_SIZE;
    }

    @Override
    public int next()
    {
        // Produce an index in the range 0-255
        index &= 0xff;
        final long t = A * (state[index] & 0xffffffffL) + carry;
        carry = (int) (t >> 32);
        return state[index++] = (int) t;
    }
}
