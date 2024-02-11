/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

import elite.dangerous.util.testing.rng.NumberFactory;

public enum NativeSeedType
{
    INT(Integer.class, 4) {
        @Override
        public Integer createSeed(int size, int from, int to)
        {
            return SeedFactory.createInt();
        }

        @Override
        protected Integer convert(Integer seed, int size)
        {
            return seed;
        }

        @Override
        protected Integer convert(Long seed, int size)
        {
            return Conversions.long2Int(seed);
        }

        @Override
        protected Integer convert(int[] seed, int size)
        {
            return Conversions.intArray2Int(seed);
        }

        @Override
        protected Integer convert(long[] seed, int size)
        {
            return Conversions.longArray2Int(seed);
        }

        @Override
        protected Integer convert(byte[] seed, int size)
        {
            return Conversions.byteArray2Int(seed);
        }
    },
    LONG(Long.class, 8) {
        @Override
        public Long createSeed(int size, int from, int to)
        {
            return SeedFactory.createLong();
        }

        @Override
        protected Long convert(Integer seed, int size)
        {
            return Conversions.int2Long(seed);
        }

        @Override
        protected Long convert(Long seed, int size)
        {
            return seed;
        }

        @Override
        protected Long convert(int[] seed, int size)
        {
            return Conversions.intArray2Long(seed);
        }

        @Override
        protected Long convert(long[] seed, int size)
        {
            return Conversions.longArray2Long(seed);
        }

        @Override
        protected Long convert(byte[] seed, int size)
        {
            return Conversions.byteArray2Long(seed);
        }
    },
    INT_ARRAY(int[].class, 4) {
        @Override
        public int[] createSeed(int size, int from, int to)
        {
            // Limit the number of calls to the synchronized method. The generator
            // will support self-seeding.
            return SeedFactory.createIntArray(Math.min(size, RANDOM_SEED_ARRAY_SIZE), from, to);
        }

        @Override
        protected int[] convert(Integer seed, int size)
        {
            return Conversions.int2IntArray(seed, size);
        }

        @Override
        protected int[] convert(Long seed, int size)
        {
            return Conversions.long2IntArray(seed, size);
        }

        @Override
        protected int[] convert(int[] seed, int size)
        {
            return seed;
        }

        @Override
        protected int[] convert(long[] seed, int size)
        {
            // Avoid zero filling seeds that are too short
            return Conversions.longArray2IntArray(seed, Math.min(size, Conversions.intSizeFromLongSize(seed.length)));
        }

        @Override
        protected int[] convert(byte[] seed, int size)
        {
            // Avoid zero filling seeds that are too short
            return Conversions.byteArray2IntArray(seed, Math.min(size, Conversions.intSizeFromByteSize(seed.length)));
        }
    },
    LONG_ARRAY(long[].class, 8) {
        @Override
        public long[] createSeed(int size, int from, int to)
        {
            // Limit the number of calls to the synchronized method. The generator
            // will support self-seeding.
            return SeedFactory.createLongArray(Math.min(size, RANDOM_SEED_ARRAY_SIZE), from, to);
        }

        @Override
        protected long[] convert(Integer seed, int size)
        {
            return Conversions.int2LongArray(seed, size);
        }

        @Override
        protected long[] convert(Long seed, int size)
        {
            return Conversions.long2LongArray(seed, size);
        }

        @Override
        protected long[] convert(int[] seed, int size)
        {
            // Avoid zero filling seeds that are too short
            return Conversions.intArray2LongArray(seed, Math.min(size, Conversions.longSizeFromIntSize(seed.length)));
        }

        @Override
        protected long[] convert(long[] seed, int size)
        {
            return seed;
        }

        @Override
        protected long[] convert(byte[] seed, int size)
        {
            // Avoid zero filling seeds that are too short
            return Conversions.byteArray2LongArray(seed, Math.min(size, Conversions.longSizeFromByteSize(seed.length)));
        }
    };

    private static final String UNRECOGNISED_SEED      = "Unrecognized seed type: ";
    private static final int    RANDOM_SEED_ARRAY_SIZE = 128;
    private final Class<?>      type;
    private final int           bytes;

    NativeSeedType(Class<?> type, int bytes)
    {
        this.type = type;
        this.bytes = bytes;
    }

    public Class<?> getType()
    {
        return type;
    }

    public int getBytes()
    {
        return bytes;
    }

    public Object createSeed(int size)
    {
        // Maintain behaviour since 1.3 to ensure position [0] of array seeds is non-zero.
        return createSeed(size, 0, Math.min(size, 1));
    }

    public abstract Object createSeed(int size, int from, int to);

    public Object convertSeed(Object seed, int size)
    {
        // Convert to native type.
        // Each method must be overridden by specific implementations.
        if (seed instanceof Integer)
        {
            return convert((Integer) seed, size);
        } else if (seed instanceof Long)
        {
            return convert((Long) seed, size);
        } else if (seed instanceof int[])
        {
            return convert((int[]) seed, size);
        } else if (seed instanceof long[])
        {
            return convert((long[]) seed, size);
        } else if (seed instanceof byte[])
        {
            return convert((byte[]) seed, size);
        }
        throw new UnsupportedOperationException(unrecognizedSeedMessage(seed));
    }

    protected abstract Object convert(Integer seed, int size);

    protected abstract Object convert(Long seed, int size);

    protected abstract Object convert(int[] seed, int size);

    protected abstract Object convert(long[] seed, int size);

    protected abstract Object convert(byte[] seed, int size);

    public static byte[] convertSeedToBytes(Object seed)
    {
        if (seed instanceof Integer)
        {
            return NumberFactory.makeByteArray((Integer) seed);
        } else if (seed instanceof Long)
        {
            return NumberFactory.makeByteArray((Long) seed);
        } else if (seed instanceof int[])
        {
            return NumberFactory.makeByteArray((int[]) seed);
        } else if (seed instanceof long[])
        {
            return NumberFactory.makeByteArray((long[]) seed);
        } else if (seed instanceof byte[])
        {
            return (byte[]) seed;
        }
        throw new UnsupportedOperationException(unrecognizedSeedMessage(seed));
    }

    private static String unrecognizedSeedMessage(Object seed)
    {
        return UNRECOGNISED_SEED + ((seed == null) ? "null" : seed.getClass().getName());
    }
}
