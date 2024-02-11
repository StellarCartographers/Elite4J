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

public class DotyHumphreySmallFastCounting64 extends LongProvider
{
    private static final int SEED_SIZE = 3;
    private long             a;
    private long             b;
    private long             c;
    private long             counter;

    public DotyHumphreySmallFastCounting64(long[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            final long[] state = new long[SEED_SIZE];
            fillState(state, seed);
            setSeedInternal(state);
        } else
        {
            setSeedInternal(seed);
        }
    }

    private void setSeedInternal(long[] seed)
    {
        a = seed[0];
        b = seed[1];
        c = seed[2];
        counter = 1L;
        for (int i = 0; i < 18; i++)
        {
            next();
        }
    }

    @Override
    public final long next()
    {
        final long tmp = a + b + counter++;
        a = b ^ (b >>> 11);
        b = c + (c << 3);
        c = Long.rotateLeft(c, 24) + tmp;
        return tmp;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{a, b, c, counter}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] parts = splitStateInternal(s, 4 * 8);
        final long[] tmp = NumberFactory.makeLongArray(parts[0]);
        a = tmp[0];
        b = tmp[1];
        c = tmp[2];
        counter = tmp[3];
        super.setStateInternal(parts[1]);
    }
}
