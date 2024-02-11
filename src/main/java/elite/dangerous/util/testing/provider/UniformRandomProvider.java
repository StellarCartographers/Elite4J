/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.provider;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public interface UniformRandomProvider
{
    default void nextBytes(byte[] bytes)
    {
        UniformRandomProviderSupport.nextBytes(this, bytes, 0, bytes.length);
    }

    default void nextBytes(byte[] bytes, int start, int len)
    {
        UniformRandomProviderSupport.validateFromIndexSize(start, len, bytes.length);
        UniformRandomProviderSupport.nextBytes(this, bytes, start, len);
    }

    default int nextInt()
    {
        return (int) (nextLong() >>> 32);
    }

    default int nextInt(int n)
    {
        UniformRandomProviderSupport.validateUpperBound(n);
        return UniformRandomProviderSupport.nextInt(this, n);
    }

    default int nextInt(int origin, int bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return UniformRandomProviderSupport.nextInt(this, origin, bound);
    }

    long nextLong();

    default long nextLong(long n)
    {
        UniformRandomProviderSupport.validateUpperBound(n);
        return UniformRandomProviderSupport.nextLong(this, n);
    }

    default long nextLong(long origin, long bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return UniformRandomProviderSupport.nextLong(this, origin, bound);
    }

    default boolean nextBoolean()
    {
        return nextInt() < 0;
    }

    default float nextFloat()
    {
        return (nextInt() >>> 8) * 0x1.0p-24f;
    }

    default float nextFloat(float bound)
    {
        UniformRandomProviderSupport.validateUpperBound(bound);
        return UniformRandomProviderSupport.nextFloat(this, bound);
    }

    default float nextFloat(float origin, float bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return UniformRandomProviderSupport.nextFloat(this, origin, bound);
    }

    default double nextDouble()
    {
        return (nextLong() >>> 11) * 0x1.0p-53;
    }

    default double nextDouble(double bound)
    {
        UniformRandomProviderSupport.validateUpperBound(bound);
        return UniformRandomProviderSupport.nextDouble(this, bound);
    }

    default double nextDouble(double origin, double bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return UniformRandomProviderSupport.nextDouble(this, origin, bound);
    }

    default IntStream ints()
    {
        return IntStream.generate(this::nextInt).sequential();
    }

    default IntStream ints(int origin, int bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return IntStream.generate(() -> nextInt(origin, bound)).sequential();
    }

    default IntStream ints(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return ints().limit(streamSize);
    }

    default IntStream ints(long streamSize, int origin, int bound)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        UniformRandomProviderSupport.validateRange(origin, bound);
        return ints(origin, bound).limit(streamSize);
    }

    default LongStream longs()
    {
        return LongStream.generate(this::nextLong).sequential();
    }

    default LongStream longs(long origin, long bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return LongStream.generate(() -> nextLong(origin, bound)).sequential();
    }

    default LongStream longs(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return longs().limit(streamSize);
    }

    default LongStream longs(long streamSize, long origin, long bound)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        UniformRandomProviderSupport.validateRange(origin, bound);
        return longs(origin, bound).limit(streamSize);
    }

    default DoubleStream doubles()
    {
        return DoubleStream.generate(this::nextDouble).sequential();
    }

    default DoubleStream doubles(double origin, double bound)
    {
        UniformRandomProviderSupport.validateRange(origin, bound);
        return DoubleStream.generate(() -> nextDouble(origin, bound)).sequential();
    }

    default DoubleStream doubles(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return doubles().limit(streamSize);
    }

    default DoubleStream doubles(long streamSize, double origin, double bound)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        UniformRandomProviderSupport.validateRange(origin, bound);
        return doubles(origin, bound).limit(streamSize);
    }
}
