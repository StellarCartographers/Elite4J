/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.provider;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class UniformRandomProviderSupport
{
    private static final String INVALID_STREAM_SIZE = "Invalid stream size: ";
    private static final String INVALID_UPPER_BOUND = "Upper bound must be above zero: ";
    private static final String INVALID_RANGE       = "Invalid range: [%s, %s)";
    private static final long   POW_32              = 1L << 32;
    private static final String NULL_ACTION         = "action must not be null";

    private UniformRandomProviderSupport()
    {
    }

    static void validateStreamSize(long size)
    {
        if (size < 0)
        {
            throw new IllegalArgumentException(INVALID_STREAM_SIZE + size);
        }
    }

    static void validateUpperBound(int bound)
    {
        if (bound <= 0)
        {
            throw new IllegalArgumentException(INVALID_UPPER_BOUND + bound);
        }
    }

    static void validateUpperBound(long bound)
    {
        if (bound <= 0)
        {
            throw new IllegalArgumentException(INVALID_UPPER_BOUND + bound);
        }
    }

    static void validateUpperBound(float bound)
    {
        // Negation of logic will detect NaN
        if (!(bound > 0 && bound <= Float.MAX_VALUE))
        {
            throw new IllegalArgumentException(INVALID_UPPER_BOUND + bound);
        }
    }

    static void validateUpperBound(double bound)
    {
        // Negation of logic will detect NaN
        if (!(bound > 0 && bound <= Double.MAX_VALUE))
        {
            throw new IllegalArgumentException(INVALID_UPPER_BOUND + bound);
        }
    }

    static void validateRange(int origin, int bound)
    {
        if (origin >= bound)
        {
            throw new IllegalArgumentException(String.format(INVALID_RANGE, origin, bound));
        }
    }

    static void validateRange(long origin, long bound)
    {
        if (origin >= bound)
        {
            throw new IllegalArgumentException(String.format(INVALID_RANGE, origin, bound));
        }
    }

    static void validateRange(double origin, double bound)
    {
        if (origin >= bound || !Double.isFinite(origin) || !Double.isFinite(bound))
        {
            throw new IllegalArgumentException(String.format(INVALID_RANGE, origin, bound));
        }
    }

    static void validateFromIndexSize(int fromIndex, int size, int length)
    {
        // check for any negatives (assume 'length' is positive array length),
        // or overflow safe length check given the values are all positive
        // remaining = length - fromIndex
        if ((fromIndex | size) < 0 || size > length - fromIndex)
        {
            throw new IndexOutOfBoundsException(
                            // Note: %<d is 'relative indexing' to re-use the last argument
                            String.format("Range [%d, %<d + %d) out of bounds for length %d", fromIndex, size, length));
        }
    }

    static void nextBytes(UniformRandomProvider source, byte[] bytes, int start, int len)
    {
        // Index of first insertion plus multiple of 8 part of length
        // (i.e. length with 3 least significant bits unset).
        final int indexLoopLimit = start + (len & 0x7ffffff8);
        // Start filling in the byte array, 8 bytes at a time.
        int index = start;
        while (index < indexLoopLimit)
        {
            final long random = source.nextLong();
            bytes[index++] = (byte) random;
            bytes[index++] = (byte) (random >>> 8);
            bytes[index++] = (byte) (random >>> 16);
            bytes[index++] = (byte) (random >>> 24);
            bytes[index++] = (byte) (random >>> 32);
            bytes[index++] = (byte) (random >>> 40);
            bytes[index++] = (byte) (random >>> 48);
            bytes[index++] = (byte) (random >>> 56);
        }
        // Index of last insertion + 1
        final int indexLimit = start + len;
        // Fill in the remaining bytes.
        if (index < indexLimit)
        {
            long random = source.nextLong();
            for (;;)
            {
                bytes[index++] = (byte) random;
                if (index == indexLimit)
                {
                    break;
                }
                random >>>= 8;
            }
        }
    }

    static int nextInt(UniformRandomProvider source, int n)
    {
        // Lemire (2019): Fast Random Integer Generation in an Interval
        // https://arxiv.org/abs/1805.10941
        long m = (source.nextInt() & 0xffffffffL) * n;
        long l = m & 0xffffffffL;
        if (l < n)
        {
            // 2^32 % n
            final long t = POW_32 % n;
            while (l < t)
            {
                m = (source.nextInt() & 0xffffffffL) * n;
                l = m & 0xffffffffL;
            }
        }
        return (int) (m >>> 32);
    }

    static int nextInt(UniformRandomProvider source, int origin, int bound)
    {
        final int n = bound - origin;
        if (n > 0)
        {
            return nextInt(source, n) + origin;
        }
        // Range too large to fit in a positive integer.
        // Use simple rejection.
        int v = source.nextInt();
        while (v < origin || v >= bound)
        {
            v = source.nextInt();
        }
        return v;
    }

    static long nextLong(UniformRandomProvider source, long n)
    {
        long bits;
        long val;
        do
        {
            bits = source.nextLong() >>> 1;
            val = bits % n;
        } while (bits - val + (n - 1) < 0);
        return val;
    }

    static long nextLong(UniformRandomProvider source, long origin, long bound)
    {
        final long n = bound - origin;
        if (n > 0)
        {
            return nextLong(source, n) + origin;
        }
        // Range too large to fit in a positive integer.
        // Use simple rejection.
        long v = source.nextLong();
        while (v < origin || v >= bound)
        {
            v = source.nextLong();
        }
        return v;
    }

    static float nextFloat(UniformRandomProvider source, float bound)
    {
        float v = source.nextFloat() * bound;
        if (v >= bound)
        {
            // Correct rounding
            v = Math.nextDown(bound);
        }
        return v;
    }

    static float nextFloat(UniformRandomProvider source, float origin, float bound)
    {
        float v = source.nextFloat();
        // This expression allows (bound - origin) to be infinite
        // origin + (bound - origin) * v
        // == origin - origin * v + bound * v
        v = (1f - v) * origin + v * bound;
        if (v >= bound)
        {
            // Correct rounding
            v = Math.nextDown(bound);
        }
        return v;
    }

    static double nextDouble(UniformRandomProvider source, double bound)
    {
        double v = source.nextDouble() * bound;
        if (v >= bound)
        {
            // Correct rounding
            v = Math.nextDown(bound);
        }
        return v;
    }

    static double nextDouble(UniformRandomProvider source, double origin, double bound)
    {
        double v = source.nextDouble();
        // This expression allows (bound - origin) to be infinite
        // origin + (bound - origin) * v
        // == origin - origin * v + bound * v
        v = (1f - v) * origin + v * bound;
        if (v >= bound)
        {
            // Correct rounding
            v = Math.nextDown(bound);
        }
        return v;
    }
    // Spliterator support

    private static class ProviderSpliterator
    {
        protected long       position;
        protected final long end;

        ProviderSpliterator(long start, long end)
        {
            position = start;
            this.end = end;
        }
        // Methods required by all Spliterators

        // See Spliterator.estimateSize()
        public long estimateSize()
        {
            return end - position;
        }

        // See Spliterator.characteristics()
        public int characteristics()
        {
            return Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.NONNULL | Spliterator.IMMUTABLE;
        }
    }

    static class ProviderSplitsSpliterator extends ProviderSpliterator implements Spliterator<SplittableUniformRandomProvider>
    {
        private final SplittableUniformRandomProvider source;
        private final SplittableUniformRandomProvider rng;

        ProviderSplitsSpliterator(long start, long end, SplittableUniformRandomProvider source, SplittableUniformRandomProvider rng)
        {
            super(start, end);
            this.source = source;
            this.rng = rng;
        }

        @Override
        public Spliterator<SplittableUniformRandomProvider> trySplit()
        {
            final long start = position;
            final long middle = (start + end) >>> 1;
            if (middle <= start)
            {
                return null;
            }
            position = middle;
            return new ProviderSplitsSpliterator(start, middle, source.split(), rng);
        }

        @Override
        public boolean tryAdvance(Consumer<? super SplittableUniformRandomProvider> action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            final long pos = position;
            if (pos < end)
            {
                // Advance before exceptions from the action are relayed to the caller
                position = pos + 1;
                action.accept(rng.split(source));
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(Consumer<? super SplittableUniformRandomProvider> action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            long pos = position;
            final long last = end;
            if (pos < last)
            {
                // Ensure forEachRemaining is called only once
                position = last;
                final SplittableUniformRandomProvider s = source;
                final SplittableUniformRandomProvider r = rng;
                do
                {
                    action.accept(r.split(s));
                } while (++pos < last);
            }
        }
    }

    static class ProviderIntsSpliterator extends ProviderSpliterator implements Spliterator.OfInt
    {
        private final SplittableUniformRandomProvider                source;
        private final ToIntFunction<SplittableUniformRandomProvider> gen;

        ProviderIntsSpliterator(long start, long end, SplittableUniformRandomProvider source, ToIntFunction<SplittableUniformRandomProvider> gen)
        {
            super(start, end);
            this.source = source;
            this.gen = gen;
        }

        @Override
        public Spliterator.OfInt trySplit()
        {
            final long start = position;
            final long middle = (start + end) >>> 1;
            if (middle <= start)
            {
                return null;
            }
            position = middle;
            return new ProviderIntsSpliterator(start, middle, source.split(), gen);
        }

        @Override
        public boolean tryAdvance(IntConsumer action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            final long pos = position;
            if (pos < end)
            {
                // Advance before exceptions from the action are relayed to the caller
                position = pos + 1;
                action.accept(gen.applyAsInt(source));
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(IntConsumer action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            long pos = position;
            final long last = end;
            if (pos < last)
            {
                // Ensure forEachRemaining is called only once
                position = last;
                final SplittableUniformRandomProvider s = source;
                final ToIntFunction<SplittableUniformRandomProvider> g = gen;
                do
                {
                    action.accept(g.applyAsInt(s));
                } while (++pos < last);
            }
        }
    }

    static class ProviderLongsSpliterator extends ProviderSpliterator implements Spliterator.OfLong
    {
        private final SplittableUniformRandomProvider                 source;
        private final ToLongFunction<SplittableUniformRandomProvider> gen;

        ProviderLongsSpliterator(long start, long end, SplittableUniformRandomProvider source, ToLongFunction<SplittableUniformRandomProvider> gen)
        {
            super(start, end);
            this.source = source;
            this.gen = gen;
        }

        @Override
        public Spliterator.OfLong trySplit()
        {
            final long start = position;
            final long middle = (start + end) >>> 1;
            if (middle <= start)
            {
                return null;
            }
            position = middle;
            return new ProviderLongsSpliterator(start, middle, source.split(), gen);
        }

        @Override
        public boolean tryAdvance(LongConsumer action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            final long pos = position;
            if (pos < end)
            {
                // Advance before exceptions from the action are relayed to the caller
                position = pos + 1;
                action.accept(gen.applyAsLong(source));
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(LongConsumer action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            long pos = position;
            final long last = end;
            if (pos < last)
            {
                // Ensure forEachRemaining is called only once
                position = last;
                final SplittableUniformRandomProvider s = source;
                final ToLongFunction<SplittableUniformRandomProvider> g = gen;
                do
                {
                    action.accept(g.applyAsLong(s));
                } while (++pos < last);
            }
        }
    }

    static class ProviderDoublesSpliterator extends ProviderSpliterator implements Spliterator.OfDouble
    {
        private final SplittableUniformRandomProvider                   source;
        private final ToDoubleFunction<SplittableUniformRandomProvider> gen;

        ProviderDoublesSpliterator(long start, long end, SplittableUniformRandomProvider source, ToDoubleFunction<SplittableUniformRandomProvider> gen)
        {
            super(start, end);
            this.source = source;
            this.gen = gen;
        }

        @Override
        public Spliterator.OfDouble trySplit()
        {
            final long start = position;
            final long middle = (start + end) >>> 1;
            if (middle <= start)
            {
                return null;
            }
            position = middle;
            return new ProviderDoublesSpliterator(start, middle, source.split(), gen);
        }

        @Override
        public boolean tryAdvance(DoubleConsumer action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            final long pos = position;
            if (pos < end)
            {
                // Advance before exceptions from the action are relayed to the caller
                position = pos + 1;
                action.accept(gen.applyAsDouble(source));
                return true;
            }
            return false;
        }

        @Override
        public void forEachRemaining(DoubleConsumer action)
        {
            Objects.requireNonNull(action, NULL_ACTION);
            long pos = position;
            final long last = end;
            if (pos < last)
            {
                // Ensure forEachRemaining is called only once
                position = last;
                final SplittableUniformRandomProvider s = source;
                final ToDoubleFunction<SplittableUniformRandomProvider> g = gen;
                do
                {
                    action.accept(g.applyAsDouble(s));
                } while (++pos < last);
            }
        }
    }
}
