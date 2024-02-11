/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

public final class NumberFactory
{
    private static final float  FLOAT_MULTIPLIER      = 0x1.0p-24f;
    private static final double DOUBLE_MULTIPLIER     = 0x1.0p-53d;
    private static final long   LONG_LOWEST_BYTE_MASK = 0xffL;
    private static final int    LONG_SIZE             = 8;
    private static final int    INT_LOWEST_BYTE_MASK  = 0xff;
    private static final int    INT_SIZE              = 4;

    private NumberFactory()
    {
    }

    @Deprecated
    public static boolean makeBoolean(int v)
    {
        return v < 0;
    }

    @Deprecated
    public static boolean makeBoolean(long v)
    {
        return v < 0;
    }

    public static double makeDouble(long v)
    {
        // Require the least significant 53-bits so shift the higher bits across
        return (v >>> 11) * DOUBLE_MULTIPLIER;
    }

    public static double makeDouble(int v, int w)
    {
        // Require the least significant 53-bits from a long.
        // Join the most significant 26 from v with 27 from w.
        final long high = ((long) (v >>> 6)) << 27; // 26-bits remain
        final int low = w >>> 5; // 27-bits remain
        return (high | low) * DOUBLE_MULTIPLIER;
    }

    public static float makeFloat(int v)
    {
        // Require the least significant 24-bits so shift the higher bits across
        return (v >>> 8) * FLOAT_MULTIPLIER;
    }

    public static long makeLong(int v, int w)
    {
        return (((long) v) << 32) | (w & 0xffffffffL);
    }

    @Deprecated
    public static int makeInt(long v)
    {
        return extractHi(v) ^ extractLo(v);
    }

    public static int extractHi(long v)
    {
        return (int) (v >>> 32);
    }

    public static int extractLo(long v)
    {
        return (int) v;
    }

    public static byte[] makeByteArray(long v)
    {
        final byte[] b = new byte[LONG_SIZE];
        putLong(v, b, 0);
        return b;
    }

    private static void putLong(long v, byte[] buffer, int index)
    {
        buffer[index] = (byte) (v & LONG_LOWEST_BYTE_MASK);
        buffer[index + 1] = (byte) ((v >>> 8) & LONG_LOWEST_BYTE_MASK);
        buffer[index + 2] = (byte) ((v >>> 16) & LONG_LOWEST_BYTE_MASK);
        buffer[index + 3] = (byte) ((v >>> 24) & LONG_LOWEST_BYTE_MASK);
        buffer[index + 4] = (byte) ((v >>> 32) & LONG_LOWEST_BYTE_MASK);
        buffer[index + 5] = (byte) ((v >>> 40) & LONG_LOWEST_BYTE_MASK);
        buffer[index + 6] = (byte) ((v >>> 48) & LONG_LOWEST_BYTE_MASK);
        buffer[index + 7] = (byte) (v >>> 56);
    }

    public static long makeLong(byte[] input)
    {
        checkSize(LONG_SIZE, input.length);
        return getLong(input, 0);
    }

    private static long getLong(byte[] input, int index)
    {
        return (input[index] & LONG_LOWEST_BYTE_MASK) | (input[index + 1] & LONG_LOWEST_BYTE_MASK) << 8 | (input[index + 2] & LONG_LOWEST_BYTE_MASK) << 16 | (input[index + 3] & LONG_LOWEST_BYTE_MASK) << 24 | (input[index + 4] & LONG_LOWEST_BYTE_MASK) << 32
                        | (input[index + 5] & LONG_LOWEST_BYTE_MASK) << 40 | (input[index + 6] & LONG_LOWEST_BYTE_MASK) << 48 | (input[index + 7] & LONG_LOWEST_BYTE_MASK) << 56;
    }

    public static byte[] makeByteArray(long[] input)
    {
        final int size = input.length * LONG_SIZE;
        final byte[] b = new byte[size];
        for (int i = 0; i < input.length; i++)
        {
            putLong(input[i], b, i * LONG_SIZE);
        }
        return b;
    }

    public static long[] makeLongArray(byte[] input)
    {
        final int size = input.length;
        final int num = size / LONG_SIZE;
        checkSize(num * LONG_SIZE, size);
        final long[] output = new long[num];
        for (int i = 0; i < num; i++)
        {
            output[i] = getLong(input, i * LONG_SIZE);
        }
        return output;
    }

    public static byte[] makeByteArray(int v)
    {
        final byte[] b = new byte[INT_SIZE];
        putInt(v, b, 0);
        return b;
    }

    private static void putInt(int v, byte[] buffer, int index)
    {
        buffer[index] = (byte) (v & INT_LOWEST_BYTE_MASK);
        buffer[index + 1] = (byte) ((v >>> 8) & INT_LOWEST_BYTE_MASK);
        buffer[index + 2] = (byte) ((v >>> 16) & INT_LOWEST_BYTE_MASK);
        buffer[index + 3] = (byte) (v >>> 24);
    }

    public static int makeInt(byte[] input)
    {
        checkSize(INT_SIZE, input.length);
        return getInt(input, 0);
    }

    private static int getInt(byte[] input, int index)
    {
        return (input[index] & INT_LOWEST_BYTE_MASK) | (input[index + 1] & INT_LOWEST_BYTE_MASK) << 8 | (input[index + 2] & INT_LOWEST_BYTE_MASK) << 16 | (input[index + 3] & INT_LOWEST_BYTE_MASK) << 24;
    }

    public static byte[] makeByteArray(int[] input)
    {
        final int size = input.length * INT_SIZE;
        final byte[] b = new byte[size];
        for (int i = 0; i < input.length; i++)
        {
            putInt(input[i], b, i * INT_SIZE);
        }
        return b;
    }

    public static int[] makeIntArray(byte[] input)
    {
        final int size = input.length;
        final int num = size / INT_SIZE;
        checkSize(num * INT_SIZE, size);
        final int[] output = new int[num];
        for (int i = 0; i < num; i++)
        {
            output[i] = getInt(input, i * INT_SIZE);
        }
        return output;
    }

    private static void checkSize(int expected, int actual)
    {
        if (expected != actual)
        {
            throw new IllegalArgumentException("Array size: Expected " + expected + " but was " + actual);
        }
    }
}
