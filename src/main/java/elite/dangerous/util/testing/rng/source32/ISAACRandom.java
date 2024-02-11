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

public class ISAACRandom extends IntProvider
{
    private static final int SIZE_L    = 8;
    private static final int SIZE      = 1 << SIZE_L;
    private static final int H_SIZE    = SIZE >> 1;
    private static final int MASK      = SIZE - 1 << 2;
    private static final int GLD_RATIO = 0x9e3779b9;
    private final int[]      rsl       = new int[SIZE];
    private final int[]      mem       = new int[SIZE];
    private int              count;
    private int              isaacA;
    private int              isaacB;
    private int              isaacC;
    private final int[]      arr       = new int[8];
    private int              isaacX;
    private int              isaacI;
    private int              isaacJ;

    public ISAACRandom(int[] seed)
    {
        setSeedInternal(seed);
    }

    @Override
    protected byte[] getStateInternal()
    {
        final int[] sRsl = Arrays.copyOf(rsl, SIZE);
        final int[] sMem = Arrays.copyOf(mem, SIZE);
        final int[] sRem = Arrays.copyOf(new int[]{count, isaacA, isaacB, isaacC}, 4);
        final int[] s = new int[2 * SIZE + sRem.length];
        System.arraycopy(sRsl, 0, s, 0, SIZE);
        System.arraycopy(sMem, 0, s, SIZE, SIZE);
        System.arraycopy(sRem, 0, s, 2 * SIZE, sRem.length);
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (2 * SIZE + 4) * 4);
        final int[] tmp = NumberFactory.makeIntArray(c[0]);
        System.arraycopy(tmp, 0, rsl, 0, SIZE);
        System.arraycopy(tmp, SIZE, mem, 0, SIZE);
        final int offset = 2 * SIZE;
        count = tmp[offset];
        isaacA = tmp[offset + 1];
        isaacB = tmp[offset + 2];
        isaacC = tmp[offset + 3];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(int[] seed)
    {
        final int seedLen = seed.length;
        final int rslLen = rsl.length;
        System.arraycopy(seed, 0, rsl, 0, Math.min(seedLen, rslLen));
        if (seedLen < rslLen)
        {
            for (int j = seedLen; j < rslLen; j++)
            {
                final long k = rsl[j - seedLen];
                rsl[j] = (int) (0x6c078965L * (k ^ k >> 30) + j & 0xffffffffL);
            }
        }
        initState();
    }

    @Override
    public int next()
    {
        if (count < 0)
        {
            isaac();
            count = SIZE - 1;
        }
        return rsl[count--];
    }

    private void isaac()
    {
        isaacI = 0;
        isaacJ = H_SIZE;
        isaacB += ++isaacC;
        while (isaacI < H_SIZE)
        {
            isaac2();
        }
        isaacJ = 0;
        while (isaacJ < H_SIZE)
        {
            isaac2();
        }
    }

    private void isaac2()
    {
        isaacX = mem[isaacI];
        isaacA ^= isaacA << 13;
        isaacA += mem[isaacJ++];
        isaac3();
        isaacX = mem[isaacI];
        isaacA ^= isaacA >>> 6;
        isaacA += mem[isaacJ++];
        isaac3();
        isaacX = mem[isaacI];
        isaacA ^= isaacA << 2;
        isaacA += mem[isaacJ++];
        isaac3();
        isaacX = mem[isaacI];
        isaacA ^= isaacA >>> 16;
        isaacA += mem[isaacJ++];
        isaac3();
    }

    private void isaac3()
    {
        mem[isaacI] = mem[(isaacX & MASK) >> 2] + isaacA + isaacB;
        isaacB = mem[(mem[isaacI] >> SIZE_L & MASK) >> 2] + isaacX;
        rsl[isaacI++] = isaacB;
    }

    private void initState()
    {
        isaacA = 0;
        isaacB = 0;
        isaacC = 0;
        Arrays.fill(arr, GLD_RATIO);
        for (int j = 0; j < 4; j++)
        {
            shuffle();
        }
        // fill in mem[] with messy stuff
        for (int j = 0; j < SIZE; j += 8)
        {
            arr[0] += rsl[j];
            arr[1] += rsl[j + 1];
            arr[2] += rsl[j + 2];
            arr[3] += rsl[j + 3];
            arr[4] += rsl[j + 4];
            arr[5] += rsl[j + 5];
            arr[6] += rsl[j + 6];
            arr[7] += rsl[j + 7];
            shuffle();
            setState(j);
        }
        // second pass makes all of seed affect all of mem
        for (int j = 0; j < SIZE; j += 8)
        {
            arr[0] += mem[j];
            arr[1] += mem[j + 1];
            arr[2] += mem[j + 2];
            arr[3] += mem[j + 3];
            arr[4] += mem[j + 4];
            arr[5] += mem[j + 5];
            arr[6] += mem[j + 6];
            arr[7] += mem[j + 7];
            shuffle();
            setState(j);
        }
        isaac();
        count = SIZE - 1;
    }

    private void shuffle()
    {
        arr[0] ^= arr[1] << 11;
        arr[3] += arr[0];
        arr[1] += arr[2];
        arr[1] ^= arr[2] >>> 2;
        arr[4] += arr[1];
        arr[2] += arr[3];
        arr[2] ^= arr[3] << 8;
        arr[5] += arr[2];
        arr[3] += arr[4];
        arr[3] ^= arr[4] >>> 16;
        arr[6] += arr[3];
        arr[4] += arr[5];
        arr[4] ^= arr[5] << 10;
        arr[7] += arr[4];
        arr[5] += arr[6];
        arr[5] ^= arr[6] >>> 4;
        arr[0] += arr[5];
        arr[6] += arr[7];
        arr[6] ^= arr[7] << 8;
        arr[1] += arr[6];
        arr[7] += arr[0];
        arr[7] ^= arr[0] >>> 9;
        arr[2] += arr[7];
        arr[0] += arr[1];
    }

    private void setState(int start)
    {
        mem[start] = arr[0];
        mem[start + 1] = arr[1];
        mem[start + 2] = arr[2];
        mem[start + 3] = arr[3];
        mem[start + 4] = arr[4];
        mem[start + 5] = arr[5];
        mem[start + 6] = arr[6];
        mem[start + 7] = arr[7];
    }
}
