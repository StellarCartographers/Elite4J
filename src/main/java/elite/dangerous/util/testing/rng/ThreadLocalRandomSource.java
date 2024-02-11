/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

import java.util.EnumMap;

import elite.dangerous.util.testing.provider.UniformRandomProvider;

public final class ThreadLocalRandomSource
{
    private static final EnumMap<RandomSource, ThreadLocal<UniformRandomProvider>> SOURCES = new EnumMap<>(RandomSource.class);

    private ThreadLocalRandomSource()
    {
    }

    private static class ThreadLocalRng extends ThreadLocal<UniformRandomProvider>
    {
        private final RandomSource source;

        ThreadLocalRng(RandomSource source)
        {
            this.source = source;
        }

        @Override
        protected UniformRandomProvider initialValue()
        {
            // Create with the default seed generation method
            return source.create();
        }
    }

    public static UniformRandomProvider current(RandomSource source)
    {
        ThreadLocal<UniformRandomProvider> rng = SOURCES.get(source);
        // Implement double-checked locking:
        // https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
        if (rng == null)
        {
            // Do the checks on the source here since it is an edge case
            // and the EnumMap handles null (returning null).
            if (source == null)
            {
                throw new IllegalArgumentException("Random source is null");
            }
            synchronized (SOURCES)
            {
                rng = SOURCES.computeIfAbsent(source, ThreadLocalRng::new);
            }
        }
        return rng.get();
    }
}
