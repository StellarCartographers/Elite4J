/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

import elite.dangerous.util.testing.provider.*;

public final class RandomStreams
{
    private static final int SEED_CHAR_BITS = 4;

    public interface SeededObjectFactory<T>
    {
        T create(long seed, UniformRandomProvider source);
    }

    private RandomStreams()
    {
    }

    public static <T> Stream<T> generateWithSeed(long streamSize, SplittableUniformRandomProvider source, SeededObjectFactory<T> factory)
    {
        if (streamSize < 0)
        {
            throw new IllegalArgumentException("Invalid stream size: " + streamSize);
        }
        Objects.requireNonNull(source, "source");
        Objects.requireNonNull(factory, "factory");
        final long seed = createSeed(source);
        return StreamSupport.stream(new SeededObjectSpliterator<>(0, streamSize, source, factory, seed), false);
    }

    static long createSeed(UniformRandomProvider rng)
    {
        // Initial random bits. Lowest bit must be set.
        long bits = rng.nextLong() | 1;
        // Mask to extract characters.
        // Can be used to sample from (n-1) n-bit characters.
        final long n = (1L << SEED_CHAR_BITS) - 1;
        // Extract the unique character.
        final long unique = bits & n;
        // Check the rest of the characters do not match the unique character.
        // This loop extracts the remaining characters and replaces if required.
        // This will work if the characters do not evenly divide into 64 as we iterate
        // over the count of remaining bits. The original order is maintained so that
        // if the bits already satisfy the requirements they are unchanged.
        for (int i = SEED_CHAR_BITS; i < Long.SIZE; i += SEED_CHAR_BITS)
        {
            // Next character
            long c = (bits >>> i) & n;
            if (c == unique)
            {
                // Branch frequency of 2^-bits.
                // This code is deliberately branchless.
                // Avoid nextInt(n) using: c = floor(n * ([0, 2^32) / 2^32))
                // Rejection rate for non-uniformity will be negligible: 2^32 % 15 == 1
                // so any rejection algorithm only has to exclude 1 value from nextInt().
                c = (n * Integer.toUnsignedLong(rng.nextInt())) >>> Integer.SIZE;
                // Ensure the sample is uniform in [0, n] excluding the unique character
                c = (unique + c + 1) & n;
                // Replace by masking out the current character and bitwise add the new one
                bits = (bits & ~(n << i)) | (c << i);
            }
        }
        return bits;
    }

    private static final class SeededObjectSpliterator<T> implements Spliterator<T>
    {
        private static final String                   NULL_ACTION = "action must not be null";
        private long                                  position;
        private final long                            end;
        private long                                  seed;
        private final SplittableUniformRandomProvider source;
        private final SeededObjectFactory<T>          factory;

        SeededObjectSpliterator(long start, long end, SplittableUniformRandomProvider source, SeededObjectFactory<T> factory, long seed)
        {
            position = start;
            this.end = end;
            this.seed = seed;
            this.source = source;
            this.factory = factory;
        }

        @Override
        public long estimateSize()
        {
            return end - position;
        }

        @Override
        public int characteristics()
        {
            return Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.IMMUTABLE;
        }

        @Override
        public Spliterator<T> trySplit()
        {
            final long start = position;
            final long middle = (start + end) >>> 1;
            if (middle <= start)
            {
                return null;
            }
            // The child spliterator can use the same seed as the position does not overlap
            final SeededObjectSpliterator<T> s = new SeededObjectSpliterator<>(start, middle, source.split(), factory, seed);
            // Since the position has increased ensure the seed does not overlap
            position = middle;
            while (seed != 0 && Long.compareUnsigned(Long.lowestOneBit(seed), middle) <= 0)
            {
                seed <<= SEED_CHAR_BITS;
            }
            return s;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            final long pos = position;
            if (pos < end)
            {
                // Advance before exceptions from the action are relayed to the caller
                position = pos + 1;
                action.accept(factory.create(seed | pos, source));
                // If the position overlaps the seed, shift it by 1 character
                if ((position & seed) != 0)
                {
                    seed <<= SEED_CHAR_BITS;
                }
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            long pos = position;
            final long last = end;
            if (pos < last)
            {
                // Ensure forEachRemaining is called only once
                position = last;
                final SplittableUniformRandomProvider s = source;
                final SeededObjectFactory<T> f = factory;
                do
                {
                    action.accept(f.create(seed | pos, s));
                    pos++;
                    // If the position overlaps the seed, shift it by 1 character
                    if ((pos & seed) != 0)
                    {
                        seed <<= SEED_CHAR_BITS;
                    }
                } while (pos < last);
            }
        }
    }
}
