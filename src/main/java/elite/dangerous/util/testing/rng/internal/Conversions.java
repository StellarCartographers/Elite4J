/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

final class Conversions
{
    private static final long GOLDEN_RATIO = MixFunctions.GOLDEN_RATIO_64;

    private Conversions()
    {
    }

    static int intSizeFromByteSize(int size)
    {
        return (size + 3) >>> 2;
    }

    static int longSizeFromByteSize(int size)
    {
        return (size + 7) >>> 3;
    }

    static int intSizeFromLongSize(int size)
    {
        // Avoid overflow when doubling the length.
        // If n is negative the signed shift creates a mask with all bits set;
        // otherwise it is zero and n is unchanged after the or operation.
        // The final mask clears the sign bit in the event n did overflow.
        final int n = size << 1;
        return (n | (n >> 31)) & Integer.MAX_VALUE;
    }

    static int longSizeFromIntSize(int size)
    {
        return (size + 1) >>> 1;
    }

    static long int2Long(int input)
    {
        return MixFunctions.stafford13(input + GOLDEN_RATIO);
    }

    static int[] int2IntArray(int input, int length)
    {
        return long2IntArray(input, length);
    }

    static long[] int2LongArray(int input, int length)
    {
        return long2LongArray(input, length);
    }

    static int long2Int(long input)
    {
        return (int) input ^ (int) (input >>> 32);
    }

    static int[] long2IntArray(long input, int length)
    {
        // Special case to avoid creating a zero-filled array of length 2.
        long v = input == -GOLDEN_RATIO ? ~input : input;
        final int[] output = new int[length];
        // Process pairs
        final int n = length & ~0x1;
        for (int i = 0; i < n; i += 2)
        {
            final long x = MixFunctions.stafford13(v += GOLDEN_RATIO);
            output[i] = (int) x;
            output[i + 1] = (int) (x >>> 32);
        }
        // Final value
        if (n < length)
        {
            output[n] = (int) MixFunctions.stafford13(v + GOLDEN_RATIO);
        }
        return output;
    }

    static long[] long2LongArray(long input, int length)
    {
        long v = input;
        final long[] output = new long[length];
        for (int i = 0; i < length; i++)
        {
            output[i] = MixFunctions.stafford13(v += GOLDEN_RATIO);
        }
        return output;
    }

    static int intArray2Int(int[] input)
    {
        int output = 0;
        for (final int i : input)
        {
            output ^= i;
        }
        return output;
    }

    static long intArray2Long(int[] input)
    {
        long output = 0;
        final int n = input.length;
        // xor in the bits to a long in little-endian order
        for (int i = 0; i < n; i++)
        {
            // i = int index
            // i >> 1 = long index
            // i & 0x1 = int number in the long [0, 1]
            // (i & 0x1) << 5 = little-endian byte shift to the long {0, 32}
            output ^= (input[i] & 0xffffffffL) << ((i & 0x1) << 5);
        }
        return output;
    }

    static long[] intArray2LongArray(int[] input, int length)
    {
        final long[] output = new long[length];
        // Overflow-safe minimum using long
        final int n = (int) Math.min(input.length, length * 2L);
        // Little-endian fill
        for (int i = 0; i < n; i++)
        {
            // i = int index
            // i >> 1 = long index
            // i & 0x1 = int number in the long [0, 1]
            // (i & 0x1) << 5 = little-endian byte shift to the long {0, 32}
            output[i >> 1] |= (input[i] & 0xffffffffL) << ((i & 0x1) << 5);
        }
        return output;
    }

    static int longArray2Int(long[] input)
    {
        return Conversions.long2Int(longArray2Long(input));
    }

    static long longArray2Long(long[] input)
    {
        long output = 0;
        for (final long i : input)
        {
            output ^= i;
        }
        return output;
    }

    static int[] longArray2IntArray(long[] input, int length)
    {
        final int[] output = new int[length];
        // Overflow-safe minimum using long
        final int n = (int) Math.min(input.length * 2L, length);
        // Little-endian fill
        // Alternate low/high 32-bits from each long
        for (int i = 0; i < n; i++)
        {
            // i = int index
            // i >> 1 = long index
            // i & 0x1 = int number in the long [0, 1]
            // (i & 0x1) << 5 = little-endian long shift to the int {0, 32}
            output[i] = (int) ((input[i >> 1]) >>> ((i & 0x1) << 5));
        }
        return output;
    }

    static int byteArray2Int(byte[] input)
    {
        int output = 0;
        final int n = input.length;
        // xor in the bits to an int in little-endian order
        for (int i = 0; i < n; i++)
        {
            // i = byte index
            // i >> 2 = integer index
            // i & 0x3 = byte number in the integer [0, 3]
            // (i & 0x3) << 3 = little-endian byte shift to the integer {0, 8, 16, 24}
            output ^= (input[i] & 0xff) << ((i & 0x3) << 3);
        }
        return output;
    }

    static int[] byteArray2IntArray(byte[] input, int length)
    {
        final int[] output = new int[length];
        // Overflow-safe minimum using long
        final int n = (int) Math.min(input.length, length * (long) Integer.BYTES);
        // Little-endian fill
        for (int i = 0; i < n; i++)
        {
            // i = byte index
            // i >> 2 = integer index
            // i & 0x3 = byte number in the integer [0, 3]
            // (i & 0x3) << 3 = little-endian byte shift to the integer {0, 8, 16, 24}
            output[i >> 2] |= (input[i] & 0xff) << ((i & 0x3) << 3);
        }
        return output;
    }

    static long byteArray2Long(byte[] input)
    {
        long output = 0;
        final int n = input.length;
        // xor in the bits to a long in little-endian order
        for (int i = 0; i < n; i++)
        {
            // i = byte index
            // i >> 3 = long index
            // i & 0x7 = byte number in the long [0, 7]
            // (i & 0x7) << 3 = little-endian byte shift to the long {0, 8, 16, 24, 32, 36, 40, 48, 56}
            output ^= (input[i] & 0xffL) << ((i & 0x7) << 3);
        }
        return output;
    }

    static long[] byteArray2LongArray(byte[] input, int length)
    {
        final long[] output = new long[length];
        // Overflow-safe minimum using long
        final int n = (int) Math.min(input.length, length * (long) Long.BYTES);
        // Little-endian fill
        for (int i = 0; i < n; i++)
        {
            // i = byte index
            // i >> 3 = long index
            // i & 0x7 = byte number in the long [0, 7]
            // (i & 0x7) << 3 = little-endian byte shift to the long {0, 8, 16, 24, 32, 36, 40, 48, 56}
            output[i >> 3] |= (input[i] & 0xffL) << ((i & 0x7) << 3);
        }
        return output;
    }
}
