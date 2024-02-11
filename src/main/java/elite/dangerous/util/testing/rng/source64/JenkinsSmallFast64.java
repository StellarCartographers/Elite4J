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

public class JenkinsSmallFast64 extends LongProvider
{
    private long a;
    private long b;
    private long c;
    private long d;

    public JenkinsSmallFast64(Long seed)
    {
        setSeedInternal(seed);
    }

    private void setSeedInternal(long seed)
    {
        a = 0xf1ea5eedL;
        b = c = d = seed;
        for (int i = 0; i < 20; i++)
        {
            next();
        }
    }

    @Override
    public final long next()
    {
        final long e = a - Long.rotateLeft(b, 7);
        a = b ^ Long.rotateLeft(c, 13);
        b = c + Long.rotateLeft(d, 37);
        c = d + e;
        d = e + a;
        return d;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{a, b, c, d}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] parts = splitStateInternal(s, 4 * 8);
        final long[] tmp = NumberFactory.makeLongArray(parts[0]);
        a = tmp[0];
        b = tmp[1];
        c = tmp[2];
        d = tmp[3];
        super.setStateInternal(parts[1]);
    }
}
