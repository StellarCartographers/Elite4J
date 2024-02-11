/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

final class LXMSupport
{
    static final long         M64                       = 0xd1342543de82ef95L;
    static final long         M64P                      = 0x8d23804c00000001L;
    static final long         C64P                      = 0x16691c9700000000L;
    static final long         M128L                     = 0xd605bbb58c8abbfdL;
    static final long         M128PH                    = 0x31f179f5224754f4L;
    static final long         C128PH                    = 0x61139b28883277c3L;
    static final long         GOLDEN_RATIO_64           = 0x9e3779b97f4a7c15L;
    private static final long INT_TO_UNSIGNED_BYTE_MASK = 0xffff_ffffL;

    private LXMSupport()
    {
    }

    static long lea64(long x)
    {
        x = (x ^ (x >>> 32)) * 0xdaba0b6eb09322e3L;
        x = (x ^ (x >>> 32)) * 0xdaba0b6eb09322e3L;
        return x ^ (x >>> 32);
    }

    static long unsignedMultiplyHigh(long value1, long value2)
    {
        // Computation is based on the following observation about the upper (a and x)
        // and lower (b and y) bits of unsigned big-endian integers:
        // ab * xy
        // = b * y
        // + b * x0
        // + a0 * y
        // + a0 * x0
        // = b * y
        // + b * x * 2^32
        // + a * y * 2^32
        // + a * x * 2^64
        //
        // Summation using a character for each byte:
        //
        // byby byby
        // + bxbx bxbx 0000
        // + ayay ayay 0000
        // + axax axax 0000 0000
        //
        // The summation can be rearranged to ensure no overflow given
        // that the result of two unsigned 32-bit integers multiplied together
        // plus two full 32-bit integers cannot overflow 64 bits:
        // > long x = (1L << 32) - 1
        // > x * x + x + x == -1 (all bits set, no overflow)
        //
        // The carry is a composed intermediate which will never overflow:
        //
        // byby byby
        // + bxbx 0000
        // + ayay ayay 0000
        //
        // + bxbx 0000 0000
        // + axax axax 0000 0000
        final long a = value1 >>> 32;
        final long b = value1 & INT_TO_UNSIGNED_BYTE_MASK;
        final long x = value2 >>> 32;
        final long y = value2 & INT_TO_UNSIGNED_BYTE_MASK;
        final long by = b * y;
        final long bx = b * x;
        final long ay = a * y;
        final long ax = a * x;
        // Cannot overflow
        final long carry = (by >>> 32) + (bx & INT_TO_UNSIGNED_BYTE_MASK) + ay;
        // Note:
        // low = (carry << 32) | (by & INT_TO_UNSIGNED_BYTE_MASK)
        // Benchmarking shows outputting low to a long[] output argument
        // has no benefit over computing 'low = value1 * value2' separately.
        return (bx >>> 32) + (carry >>> 32) + ax;
    }

    static long unsignedAddHigh(long left, long right)
    {
        // Method compiles to 13 bytes as Java byte code.
        // This is below the default of 35 for code inlining.
        //
        // The unsigned add of left + right may have a 65-bit result.
        // If both values are shifted right by 1 then the sum will be
        // within a 64-bit long. The right is assumed to have a low
        // bit of 1 which has been lost in the shift. The method must
        // compute if a 1 was shifted off the left which would have
        // triggered a carry when adding to the right's assumed 1.
        // The intermediate 64-bit result is shifted
        // 63 bits to obtain the most significant bit of the 65-bit result.
        // Using -1 is the same as a shift of (64 - 1) as only the last 6 bits
        // are used by the shift but requires 1 less byte in java byte code.
        //
        // 01100001 left
        // + 10011111 right always has low bit set to 1
        //
        // 0110000 1 carry last bit of left
        // + 1001111 |
        // + 1 <-+
        // = 10000000 carry bit generated
        return ((left >>> 1) + (right >>> 1) + (left & 1)) >>> -1;
    }
}
