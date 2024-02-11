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

public class JenkinsSmallFast32 extends IntProvider
{
    private int a;
    private int b;
    private int c;
    private int d;

    public JenkinsSmallFast32(Integer seed)
    {
        setSeedInternal(seed);
    }

    private void setSeedInternal(int seed)
    {
        a = 0xf1ea5eed;
        b = c = d = seed;
        for (int i = 0; i < 20; i++)
        {
            next();
        }
    }

    @Override
    public final int next()
    {
        final int e = a - Integer.rotateLeft(b, 27);
        a = b ^ Integer.rotateLeft(c, 17);
        b = c + d;
        c = d + e;
        d = e + a;
        return d;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new int[]{a, b, c, d}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] parts = splitStateInternal(s, 4 * 4);
        final int[] tmp = NumberFactory.makeIntArray(parts[0]);
        a = tmp[0];
        b = tmp[1];
        c = tmp[2];
        d = tmp[3];
        super.setStateInternal(parts[1]);
    }
}
