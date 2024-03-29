/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util;

import static java.util.stream.Collector.Characteristics.*;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

import elite.dangerous.fdev.Outfitting;

@UtilityClass
public class ModuleCollector
{
    static final Set<Collector.Characteristics> CH_ID = from(IDENTITY_FINISH);

    static final Set<Collector.Characteristics> from(Collector.Characteristics... arr)
    {
        return Collections.unmodifiableSet(EnumSet.of(arr[0], Arrays.copyOfRange(arr, 1, arr.length)));
    }

    @SuppressWarnings("unchecked")
    private static <I, R> Function<I, R> castingIdentity()
    {
        return i -> (R) i;
    }

    // @noformat
    static class AccumulatorImpl<T, A, R> implements Collector<T, A, R>
    {
        private final Supplier<A>          supplier;
        private final BiConsumer<A, T>     accumulator;
        private final BinaryOperator<A>    combiner;
        private final Function<A, R>       finisher;
        private final Set<Characteristics> characteristics;

        AccumulatorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Function<A, R> finisher, Set<Characteristics> characteristics)
        {
            this.supplier = supplier;
            this.accumulator = accumulator;
            this.combiner = combiner;
            this.finisher = finisher;
            this.characteristics = characteristics;
        }

        AccumulatorImpl(Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner, Set<Characteristics> characteristics)
        {
            this(supplier, accumulator, combiner, castingIdentity(), characteristics);
        }

        @Override
        public BiConsumer<A, T> accumulator()
        {
            return accumulator;
        }

        @Override
        public Supplier<A> supplier()
        {
            return supplier;
        }

        @Override
        public BinaryOperator<A> combiner()
        {
            return combiner;
        }

        @Override
        public Function<A, R> finisher()
        {
            return finisher;
        }

        @Override
        public Set<Characteristics> characteristics()
        {
            return characteristics;
        }
    }

    public static <T extends Outfitting.Module> Collector<T, ?, ModuleList> toList()
    {
        return new AccumulatorImpl<>((Supplier<ModuleList>) ModuleList::new, ModuleList::add, (left, right) ->
        {
            left.addAll(right);
            return left;
        }, CH_ID);
    }
}
