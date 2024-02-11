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

public class KISSRandom extends IntProvider
{
    private static final int SEED_SIZE = 4;
    private int              z;
    private int              w;
    private int              jsr;
    private int              jcong;

    public KISSRandom(int[] seed)
    {
        setSeedInternal(seed);
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new int[]{z, w, jsr, jcong}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * 4);
        final int[] tmp = NumberFactory.makeIntArray(c[0]);
        z = tmp[0];
        w = tmp[1];
        jsr = tmp[2];
        jcong = tmp[3];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(int[] seed)
    {
        // Reset the whole state of this RNG (i.e. the 4 state variables).
        // Filling procedure is not part of the reference code.
        final int[] tmp = new int[SEED_SIZE];
        fillState(tmp, seed);
        z = tmp[0];
        w = tmp[1];
        jsr = tmp[2];
        jcong = tmp[3];
    }

    @Override
    public int next()
    {
        z = computeNew(36969, z);
        w = computeNew(18000, w);
        final int mwc = (z << 16) + w;
        // Cf. correction mentioned in the reply to the original post:
        // https://programmingpraxis.com/2010/10/05/george-marsaglias-random-number-generators/
        jsr ^= jsr << 13;
        jsr ^= jsr >>> 17;
        jsr ^= jsr << 5;
        jcong = 69069 * jcong + 1234567;
        return (mwc ^ jcong) + jsr;
    }

    private static int computeNew(int mult, int previous)
    {
        return mult * (previous & 65535) + (previous >>> 16);
    }
}
