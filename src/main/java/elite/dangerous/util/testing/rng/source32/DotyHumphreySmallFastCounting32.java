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

public class DotyHumphreySmallFastCounting32 extends IntProvider
{
    private static final int SEED_SIZE = 3;
    private int              a;
    private int              b;
    private int              c;
    private int              counter;

    public DotyHumphreySmallFastCounting32(int[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            final int[] state = new int[SEED_SIZE];
            fillState(state, seed);
            setSeedInternal(state);
        } else
        {
            setSeedInternal(seed);
        }
    }

    private void setSeedInternal(int[] seed)
    {
        a = seed[0];
        b = seed[1];
        c = seed[2];
        counter = 1;
        for (int i = 0; i < 15; i++)
        {
            next();
        }
    }

    @Override
    public final int next()
    {
        final int tmp = a + b + counter++;
        a = b ^ (b >>> 9);
        b = c + (c << 3);
        c = Integer.rotateLeft(c, 21) + tmp;
        return tmp;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new int[]{a, b, c, counter}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] parts = splitStateInternal(s, 4 * 4);
        final int[] tmp = NumberFactory.makeIntArray(parts[0]);
        a = tmp[0];
        b = tmp[1];
        c = tmp[2];
        counter = tmp[3];
        super.setStateInternal(parts[1]);
    }
}
