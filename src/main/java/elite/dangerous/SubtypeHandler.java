/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous;

import static elite.dangerous.SubtypeHandler.Wrapper.*;

import lombok.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import elite.dangerous.journal.Event;
import elite.dangerous.journal.events.combat.*;
import elite.dangerous.journal.events.exploration.*;

class SubtypeHandler
{
    static Optional<Class<?>> getSubtypeIfPresent(JsonNode node)
    {
        return Subtypes.get(node);
    }

    enum Subtypes
    {
        // !off
        BOUNTY(Bounty.class, Cast().To(BountySkimmer.class).When(node -> node.has("Target") && node.get("Target").asText().equals("Skimmer")).Default(BountyDefault.class)),
        DIED(Cast().To(DiedByPVP.class).When(node -> node.has("KillerShip")).To(DiedByWing.class).When(node -> node.has("Killers")).Default(Died.class)),
        SCAN(Cast().To(ScanPlanetOrMoon.class).When(node -> node.has("PlanetClass")).Default(ScanStar.class)),
        SHIPTARGET(ShipTargeted.class, Cast().To(ScanStageOne.class).When(node -> node.has("ScanStage") && node.get("ScanStage").asInt() == 1).To(ScanStageTwo.class).When(node -> node.has("ScanStage") && node.get("ScanStage").asInt() == 2).To(ScanStageThree.class)
                        .When(node -> node.has("ScanStage") && node.get("ScanStage").asInt() == 3).To(ShipTargetLocked.class).When(node -> node.get("TargetLocked").asBoolean()).Default(ShipTargetLost.class))
        // @on
        ;

        final Class<?>                 baseClass;
        final Wrapper                  cast;
        static Map<Class<?>, Subtypes> MAP = new HashMap<>();
        static
        {
            Stream.of(Subtypes.values()).forEach(h ->
            {
                MAP.put(h.baseClass, h);
            });
        }

        Subtypes(Wrapper cast)
        {
            this.baseClass = cast.fallback();
            this.cast = cast;
        }

        Subtypes(Class<? extends Event> baseClass, Wrapper cast)
        {
            this.baseClass = baseClass;
            this.cast = cast;
        }

        static Optional<Class<?>> get(JsonNode node)
        {
            Class<? extends Event> clazz = Elite4J.Journal.getJournalEvents().get(node.get("event").asText());
            return MAP.containsKey(clazz) ? Optional.of(MAP.get(clazz).cast.getEventClass(node)) : Optional.empty();
        }
    }

    private static class Ordered extends LinkedHashMap<Predicate<JsonNode>, Class<?>>
    {
        private static final long serialVersionUID = 868582529288824311L;
        private Class<?>[]        singleValue;

        Ordered()
        {
            super();
        }

        private void putFirst(Class<?> value)
        {
            if (this.singleValue != null)
            {
                return;
            }
            this.singleValue = new Class<?>[]{value};
        }

        Class<?> first()
        {
            return this.singleValue[0];
        }

        @Override
        public Class<?> put(Predicate<JsonNode> key, Class<?> value)
        {
            this.putFirst(value);
            if (super.containsValue(value))
                return value;
            else
                return super.put(key, value);
        }

        @Override
        public void clear() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(BiFunction<? super Predicate<JsonNode>, ? super Class<?>, ? extends Class<?>> function) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void putAll(Map<? extends Predicate<JsonNode>, ? extends Class<?>> m)
        {
            m.entrySet().forEach(e -> this.put(e.getKey(), e.getValue()));
        }

        @Override
        public Class<?> remove(Object key) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Class<?> putIfAbsent(Predicate<JsonNode> key, Class<?> value)
        {
            return this.put(key, value);
        }

        @Override
        public boolean remove(Object key, Object value) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean replace(Predicate<JsonNode> key, Class<?> oldValue, Class<?> newValue) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Class<?> replace(Predicate<JsonNode> key, Class<?> value) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Class<?> computeIfAbsent(Predicate<JsonNode> key, Function<? super Predicate<JsonNode>, ? extends Class<?>> mappingFunction) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Class<?> computeIfPresent(Predicate<JsonNode> key, BiFunction<? super Predicate<JsonNode>, ? super Class<?>, ? extends Class<?>> remappingFunction) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Class<?> compute(Predicate<JsonNode> key, BiFunction<? super Predicate<JsonNode>, ? super Class<?>, ? extends Class<?>> remappingFunction) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Class<?> merge(Predicate<JsonNode> key, Class<?> value, BiFunction<? super Class<?>, ? super Class<?>, ? extends Class<?>> remappingFunction) throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }

    @JsonDeserialize(builder = Wrapper.Builder.class)
    static class Wrapper
    {
        @Getter
        Class<?> fallback;
        Ordered  map;

        Wrapper(Builder builder)
        {
            this.fallback = builder.fallback;
            this.map = builder.map;
        }

        Class<?> getEventClass(JsonNode node)
        {
            for (Predicate<JsonNode> when : map.keySet())
            {
                if (when.test(node))
                {
                    return map.get(when);
                }
            }
            return fallback;
        }

        public static CastTo Cast()
        {
            return new Builder();
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        @JsonPOJOBuilder(buildMethodName = "Finish", withPrefix = "")
        static final class Builder implements CastTo, WhenTrue, FinalAction
        {
            @Setter
            Class<?>         fallback;
            Ordered          map = new Ordered();
            @Setter
            private Class<?> classReference;
            @Setter
            private boolean  toProvided;

            @Override
            @NonNull
            public WhenTrue To(Class<?> to)
            {
                this.classReference(to);
                this.toProvided(true);
                return this;
            }

            @Override
            @NonNull
            public FinalAction When(Predicate<JsonNode> when)
            {
                if (!this.toProvided)
                {
                    throw new RuntimeException("Tried setting 'when' (Predicate) before 'to' (Class<?>) reference was set");
                }
                this.map.put(when, this.classReference);
                this.classReference(null);
                this.toProvided(false);
                return this;
            }

            @Override
            @NonNull
            public Wrapper Default(Class<?> fallback)
            {
                this.fallback(fallback);
                return Create();
            }

            @Override
            @NonNull
            public Wrapper Create()
            {
                if (this.fallback == null)
                    this.fallback(this.map.first());
                return new Wrapper(this);
            }
        }

        private interface CastTo
        {
            @NonNull
            WhenTrue To(Class<?> to);
        }

        private interface WhenTrue
        {
            @NonNull
            FinalAction When(Predicate<JsonNode> when);
        }

        private interface FinalAction extends CastTo
        {
            @NonNull
            Wrapper Default(Class<?> fallback);

            @NonNull
            Wrapper Create();
        }
    }
}
