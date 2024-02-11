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
import java.util.stream.*;

public interface SplittableUniformRandomProvider extends UniformRandomProvider
{
    default SplittableUniformRandomProvider split()
    {
        return split(this);
    }

    SplittableUniformRandomProvider split(UniformRandomProvider source);

    default Stream<SplittableUniformRandomProvider> splits()
    {
        return splits(Long.MAX_VALUE, this);
    }

    default Stream<SplittableUniformRandomProvider> splits(SplittableUniformRandomProvider source)
    {
        return this.splits(Long.MAX_VALUE, source);
    }

    default Stream<SplittableUniformRandomProvider> splits(long streamSize)
    {
        return splits(streamSize, this);
    }

    default Stream<SplittableUniformRandomProvider> splits(long streamSize, SplittableUniformRandomProvider source)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        Objects.requireNonNull(source, "source");
        return StreamSupport.stream(new UniformRandomProviderSupport.ProviderSplitsSpliterator(0, streamSize, source, this), false);
    }

    @Override
    default IntStream ints()
    {
        return ints(Long.MAX_VALUE);
    }

    @Override
    default IntStream ints(int origin, int bound)
    {
        return ints(Long.MAX_VALUE, origin, bound);
    }

    @Override
    default IntStream ints(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return StreamSupport.intStream(new UniformRandomProviderSupport.ProviderIntsSpliterator(0, streamSize, this, UniformRandomProvider::nextInt), false);
    }

    @Override
    default IntStream ints(long streamSize, int origin, int bound)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        UniformRandomProviderSupport.validateRange(origin, bound);
        return StreamSupport.intStream(new UniformRandomProviderSupport.ProviderIntsSpliterator(0, streamSize, this, rng -> rng.nextInt(origin, bound)), false);
    }

    @Override
    default LongStream longs()
    {
        return longs(Long.MAX_VALUE);
    }

    @Override
    default LongStream longs(long origin, long bound)
    {
        return longs(Long.MAX_VALUE, origin, bound);
    }

    @Override
    default LongStream longs(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return StreamSupport.longStream(new UniformRandomProviderSupport.ProviderLongsSpliterator(0, streamSize, this, UniformRandomProvider::nextLong), false);
    }

    @Override
    default LongStream longs(long streamSize, long origin, long bound)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        UniformRandomProviderSupport.validateRange(origin, bound);
        return StreamSupport.longStream(new UniformRandomProviderSupport.ProviderLongsSpliterator(0, streamSize, this, rng -> rng.nextLong(origin, bound)), false);
    }

    @Override
    default DoubleStream doubles()
    {
        return doubles(Long.MAX_VALUE);
    }

    @Override
    default DoubleStream doubles(double origin, double bound)
    {
        return doubles(Long.MAX_VALUE, origin, bound);
    }

    @Override
    default DoubleStream doubles(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return StreamSupport.doubleStream(new UniformRandomProviderSupport.ProviderDoublesSpliterator(0, streamSize, this, UniformRandomProvider::nextDouble), false);
    }

    @Override
    default DoubleStream doubles(long streamSize, double origin, double bound)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        UniformRandomProviderSupport.validateRange(origin, bound);
        return StreamSupport.doubleStream(new UniformRandomProviderSupport.ProviderDoublesSpliterator(0, streamSize, this, rng -> rng.nextDouble(origin, bound)), false);
    }
}
