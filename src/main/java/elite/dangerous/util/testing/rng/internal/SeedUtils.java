/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

import elite.dangerous.util.testing.provider.UniformRandomProvider;
import elite.dangerous.util.testing.rng.NumberFactory;

final class SeedUtils
{
    private static final int    MOD_09          = 256 % 9;
    private static final int    MOD_10          = 256 % 10;
    private static final int    MOD_11          = 256 % 11;
    private static final int    MOD_12          = 256 % 12;
    private static final int    MOD_13          = 256 % 13;
    private static final int    MOD_14          = 256 % 14;
    private static final int    MOD_15          = 256 % 15;
    private static final byte[] HEX_DIGIT_ARRAY = {0xf, 0xe, 0xd, 0xc, 0xb, 0xa, 0x9, 0x8, 0x7, 0x6, 0x5, 0x4, 0x3, 0x2, 0x1, 0x0};

    private static class UnsignedByteProvider
    {
        private static final int            MASK_2_BITS = 0x3;
        private static final int            MASK_8_BITS = 0xff;
        private final UniformRandomProvider rng;
        private int                         bits;
        private int                         counter;

        UnsignedByteProvider(UniformRandomProvider rng)
        {
            this.rng = rng;
        }

        int nextUnsignedByte()
        {
            // Every 4 bytes generate a new 32-bit value
            final int count = counter & MASK_2_BITS;
            counter++;
            if (count == 0)
            {
                bits = rng.nextInt();
                // Consume the first byte
                return bits & MASK_8_BITS;
            }
            // Consume a remaining byte (occurs 3 times)
            bits >>>= 8;
            return bits & MASK_8_BITS;
        }
    }

    private SeedUtils()
    {
    }

    static int createIntHexPermutation(UniformRandomProvider rng)
    {
        final UnsignedByteProvider provider = new UnsignedByteProvider(rng);
        return createUpperBitsHexPermutation(provider);
    }

    static long createLongHexPermutation(UniformRandomProvider rng)
    {
        final UnsignedByteProvider provider = new UnsignedByteProvider(rng);
        // Extract upper bits and combine with a second sample
        return NumberFactory.makeLong(createUpperBitsHexPermutation(provider), createUpperBitsHexPermutation(provider));
    }

    private static int createUpperBitsHexPermutation(UnsignedByteProvider provider)
    {
        // Compute a Fisher-Yates shuffle in-place on the 16 hex digits.
        // Each digit is chosen uniformly from the remaining digits.
        // The value is swapped with the current digit.
        // The following is an optimised sampling algorithm that generates
        // a uniform deviate in the range [0,n) from an unsigned byte.
        // The expected number of samples is 256/n.
        // This has a bias when n does not divide into 256. So samples must
        // be rejected at a rate of (256 % n) / 256:
        // n 256 % n Rejection rate
        // 9 4 0.015625
        // 10 6 0.0234375
        // 11 3 0.01171875
        // 12 4 0.015625
        // 13 9 0.03515625
        // 14 4 0.015625
        // 15 1 0.00390625
        // 16 0 0
        // The probability of no rejections is 1 - (1-p15) * (1-p14) ... = 0.115
        final byte[] digits = HEX_DIGIT_ARRAY.clone();
        // The first digit has no bias. Get an index using a mask to avoid modulus.
        int bits = copyToOutput(digits, 0, 15, provider.nextUnsignedByte() & 0xf);
        // All remaining digits have a bias so use the rejection algorithm to find
        // an appropriate uniform deviate in the range [0,n)
        bits = copyToOutput(digits, bits, 14, nextUnsignedByteInRange(provider, MOD_15, 15));
        bits = copyToOutput(digits, bits, 13, nextUnsignedByteInRange(provider, MOD_14, 14));
        bits = copyToOutput(digits, bits, 12, nextUnsignedByteInRange(provider, MOD_13, 13));
        bits = copyToOutput(digits, bits, 11, nextUnsignedByteInRange(provider, MOD_12, 12));
        bits = copyToOutput(digits, bits, 10, nextUnsignedByteInRange(provider, MOD_11, 11));
        bits = copyToOutput(digits, bits, 9, nextUnsignedByteInRange(provider, MOD_10, 10));
        bits = copyToOutput(digits, bits, 8, nextUnsignedByteInRange(provider, MOD_09, 9));
        return bits;
    }

    private static int nextUnsignedByteInRange(UnsignedByteProvider provider, int threshold, int n)
    {
        // Rejection method using multiply by a fraction:
        // n * [0, 2^8 - 1)
        // ------------
        // 2^8
        // The result is mapped back to an integer and will be in the range [0, n)
        int m;
        do
        {
            // Compute product of n * [0, 2^8 - 1)
            m = n * provider.nextUnsignedByte();
            // Test the sample uniformity.
        } while ((m & 0xff) < threshold);
        // Final divide by 2^8
        return m >>> 8;
    }

    private static int copyToOutput(byte[] digits, int bits, int upper, int lower)
    {
        // Move the existing bits up and append the next hex digit.
        // This is equivalent to swapping lower to upper.
        final int newbits = bits << 4 | digits[lower] & 0xf;
        // Swap upper to lower.
        digits[lower] = digits[upper];
        return newbits;
    }
}
