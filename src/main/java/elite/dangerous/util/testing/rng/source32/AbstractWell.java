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

public abstract class AbstractWell extends IntProvider
{
    private static final int BLOCK_SIZE = 32;
    protected int            index;
    protected final int[]    v;

    protected AbstractWell(final int k, final int[] seed)
    {
        final int r = calculateBlockCount(k);
        v = new int[r];
        index = 0;
        // Initialize the pool content.
        setSeedInternal(seed);
    }

    @Override
    protected byte[] getStateInternal()
    {
        final int[] s = Arrays.copyOf(v, v.length + 1);
        s[v.length] = index;
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (v.length + 1) * 4);
        final int[] tmp = NumberFactory.makeIntArray(c[0]);
        System.arraycopy(tmp, 0, v, 0, v.length);
        index = tmp[v.length];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(final int[] seed)
    {
        System.arraycopy(seed, 0, v, 0, Math.min(seed.length, v.length));
        if (seed.length < v.length)
        {
            for (int i = seed.length; i < v.length; ++i)
            {
                final long current = v[i - seed.length];
                v[i] = (int) ((1812433253L * (current ^ (current >> 30)) + i) & 0xffffffffL);
            }
        }
        index = 0;
    }

    private static int calculateBlockCount(final int k)
    {
        // The bits pool contains k bits, k = r w - p where r is the number
        // of w bits blocks, w is the block size (always 32 in the original paper)
        // and p is the number of unused bits in the last block.
        return (k + BLOCK_SIZE - 1) / BLOCK_SIZE;
    }

    protected static final class IndexTable
    {
        private final int[] iRm1;
        private final int[] iRm2;
        private final int[] i1;
        private final int[] i2;
        private final int[] i3;

        public IndexTable(final int k, final int m1, final int m2, final int m3)
        {
            final int r = calculateBlockCount(k);
            // precompute indirection index tables. These tables are used for optimizing access
            // they allow saving computations like "(j + r - 2) % r" with costly modulo operations
            iRm1 = new int[r];
            iRm2 = new int[r];
            i1 = new int[r];
            i2 = new int[r];
            i3 = new int[r];
            for (int j = 0; j < r; ++j)
            {
                iRm1[j] = (j + r - 1) % r;
                iRm2[j] = (j + r - 2) % r;
                i1[j] = (j + m1) % r;
                i2[j] = (j + m2) % r;
                i3[j] = (j + m3) % r;
            }
        }

        public int getIndexPred(final int index)
        {
            return iRm1[index];
        }

        public int getIndexPred2(final int index)
        {
            return iRm2[index];
        }

        public int getIndexM1(final int index)
        {
            return i1[index];
        }

        public int getIndexM2(final int index)
        {
            return i2[index];
        }

        public int getIndexM3(final int index)
        {
            return i3[index];
        }
    }
}
