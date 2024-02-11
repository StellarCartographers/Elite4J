/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

import java.security.SecureRandom;
import java.util.concurrent.locks.ReentrantLock;

import elite.dangerous.util.testing.provider.UniformRandomProvider;
import elite.dangerous.util.testing.rng.NumberFactory;
import elite.dangerous.util.testing.rng.source64.*;

public final class SeedFactory
{
    private static final int                   XO_RO_SHI_RO_1024_STATE_SIZE = 16;
    private static final int                   INT_ARRAY_BLOCK_SIZE         = 8;
    private static final int                   LONG_ARRAY_BLOCK_SIZE        = 4;
    private static final ReentrantLock         LOCK                         = new ReentrantLock(false);
    private static final UniformRandomProvider SEED_GENERATOR;
    static
    {
        // Use a secure RNG so that different instances (e.g. in multiple JVM
        // instances started in rapid succession) will have different seeds.
        final SecureRandom seedGen = new SecureRandom();
        final byte[] bytes = new byte[8 * XO_RO_SHI_RO_1024_STATE_SIZE];
        seedGen.nextBytes(bytes);
        final long[] seed = NumberFactory.makeLongArray(bytes);
        // The XoRoShiRo1024PlusPlus generator cannot recover from an all zero seed and
        // will produce low quality initial output if initialized with some zeros.
        // Ensure it is non zero at all array positions using a SplitMix64
        // generator (this is insensitive to a zero seed so can use the first seed value).
        final SplitMix64 rng = new SplitMix64(seed[0]);
        for (int i = 0; i < seed.length; i++)
        {
            seed[i] = ensureNonZero(rng, seed[i]);
        }
        SEED_GENERATOR = new XoRoShiRo1024PlusPlus(seed);
    }

    private SeedFactory()
    {
    }

    public static int createInt()
    {
        LOCK.lock();
        try
        {
            return SEED_GENERATOR.nextInt();
        } finally
        {
            LOCK.unlock();
        }
    }

    public static long createLong()
    {
        LOCK.lock();
        try
        {
            return SEED_GENERATOR.nextLong();
        } finally
        {
            LOCK.unlock();
        }
    }

    public static int[] createIntArray(int n)
    {
        // Behaviour from v1.3 is to ensure the first position is non-zero
        return createIntArray(n, 0, Math.min(n, 1));
    }

    static int[] createIntArray(int n, int from, int to)
    {
        final int[] seed = new int[n];
        // Compute the size that can be filled with complete blocks
        final int blockSize = INT_ARRAY_BLOCK_SIZE * (n / INT_ARRAY_BLOCK_SIZE);
        int i = 0;
        while (i < blockSize)
        {
            final int end = i + INT_ARRAY_BLOCK_SIZE;
            fillIntArray(seed, i, end);
            i = end;
        }
        // Final fill only if required
        if (i != n)
        {
            fillIntArray(seed, i, n);
        }
        ensureNonZero(seed, from, to);
        return seed;
    }

    public static long[] createLongArray(int n)
    {
        // Behaviour from v1.3 is to ensure the first position is non-zero
        return createLongArray(n, 0, Math.min(n, 1));
    }

    static long[] createLongArray(int n, int from, int to)
    {
        final long[] seed = new long[n];
        // Compute the size that can be filled with complete blocks
        final int blockSize = LONG_ARRAY_BLOCK_SIZE * (n / LONG_ARRAY_BLOCK_SIZE);
        int i = 0;
        while (i < blockSize)
        {
            final int end = i + LONG_ARRAY_BLOCK_SIZE;
            fillLongArray(seed, i, end);
            i = end;
        }
        // Final fill only if required
        if (i != n)
        {
            fillLongArray(seed, i, n);
        }
        ensureNonZero(seed, from, to);
        return seed;
    }

    private static void fillIntArray(int[] array, int start, int end)
    {
        LOCK.lock();
        try
        {
            for (int i = start; i < end; i++)
            {
                array[i] = SEED_GENERATOR.nextInt();
            }
        } finally
        {
            LOCK.unlock();
        }
    }

    private static void fillLongArray(long[] array, int start, int end)
    {
        LOCK.lock();
        try
        {
            for (int i = start; i < end; i++)
            {
                array[i] = SEED_GENERATOR.nextLong();
            }
        } finally
        {
            LOCK.unlock();
        }
    }

    static byte[] createByteArray(UniformRandomProvider source, int n, int from, int to)
    {
        final byte[] seed = new byte[n];
        source.nextBytes(seed);
        ensureNonZero(seed, from, to, source);
        return seed;
    }

    static void ensureNonZero(int[] seed, int from, int to)
    {
        if (from >= to)
        {
            return;
        }
        // No check on the range so an IndexOutOfBoundsException will occur if invalid
        for (int i = from; i < to; i++)
        {
            if (seed[i] != 0)
            {
                return;
            }
        }
        // Fill with non-zero values using a SplitMix-style PRNG.
        // The range is at least 1.
        // To ensure the first value is not zero requires the input to the mix function
        // to be non-zero. This is ensured if the start is even since the increment is odd.
        int x = createInt() << 1;
        for (int i = from; i < to; i++)
        {
            seed[i] = MixFunctions.murmur3(x += MixFunctions.GOLDEN_RATIO_32);
        }
    }

    static void ensureNonZero(long[] seed, int from, int to)
    {
        if (from >= to)
        {
            return;
        }
        // No check on the range so an IndexOutOfBoundsException will occur if invalid
        for (int i = from; i < to; i++)
        {
            if (seed[i] != 0)
            {
                return;
            }
        }
        // Fill with non-zero values using a SplitMix-style PRNG.
        // The range is at least 1.
        // To ensure the first value is not zero requires the input to the mix function
        // to be non-zero. This is ensured if the start is even since the increment is odd.
        long x = createLong() << 1;
        for (int i = from; i < to; i++)
        {
            seed[i] = MixFunctions.stafford13(x += MixFunctions.GOLDEN_RATIO_64);
        }
    }

    static void ensureNonZero(byte[] seed, int from, int to, UniformRandomProvider source)
    {
        if (from >= to)
        {
            return;
        }
        // No check on the range so an IndexOutOfBoundsException will occur if invalid
        for (int i = from; i < to; i++)
        {
            if (seed[i] != 0)
            {
                return;
            }
        }
        // Defend against a faulty source of randomness (which supplied all zero bytes)
        // by filling with non-zero values using a SplitMix-style PRNG seeded from the source.
        // The range is at least 1.
        // To ensure the first value is not zero requires the input to the mix function
        // to be non-zero. This is ensured if the start is even since the increment is odd.
        long x = source.nextLong() << 1;
        // Process in blocks of 8.
        // Get the length without the final 3 bits set for a multiple of 8.
        final int len = (to - from) & ~0x7;
        final int end = from + len;
        int i = from;
        while (i < end)
        {
            long v = MixFunctions.stafford13(x += MixFunctions.GOLDEN_RATIO_64);
            for (int j = 0; j < 8; j++)
            {
                seed[i++] = (byte) v;
                v >>>= 8;
            }
        }
        if (i < to)
        {
            // The final bytes.
            long v = MixFunctions.stafford13(x + MixFunctions.GOLDEN_RATIO_64);
            // Note the special case where no blocks have been processed requires these
            // bytes to be non-zero, i.e. (to - from) < 8. In this case the value 'v' will
            // be non-zero due to the initialisation of 'x' as even.
            // Rotate the value so the least significant byte is non-zero. The rotation
            // in bits is rounded down to the nearest 8-bit block to ensure a byte rotation.
            if (len == 0)
            {
                v = Long.rotateRight(v, Long.numberOfTrailingZeros(v) & ~0x7);
            }
            while (i < to)
            {
                seed[i++] = (byte) v;
                v >>>= 8;
            }
        }
    }

    static long ensureNonZero(RandomLongSource source, long value)
    {
        long result = value;
        while (result == 0)
        {
            result = source.next();
        }
        return result;
    }
}
