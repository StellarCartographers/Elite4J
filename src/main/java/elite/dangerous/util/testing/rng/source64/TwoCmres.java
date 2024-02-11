/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import java.util.*;

import elite.dangerous.util.testing.rng.NumberFactory;

public class TwoCmres extends LongProvider
{
    private static final String        INTERNAL_ERROR_MSG = "Internal error: Please file a bug report";
    private static final byte          SEED_GUARD         = 9;
    private static final Cmres.Factory FACTORY            = new Cmres.Factory();
    private final Cmres                x;
    private final Cmres                y;
    private long                       xx;
    private long                       yy;

    private TwoCmres(int seed, Cmres x, Cmres y)
    {
        this.x = x;
        this.y = y;
        setSeedInternal(seed);
    }

    public TwoCmres(Integer seed)
    {
        this(seed, 0, 1);
    }

    public TwoCmres(Integer seed, int i, int j)
    {
        this(seed, FACTORY.getIfDifferent(i, j), FACTORY.get(j));
    }

    @Override
    public long next()
    {
        xx = x.transform(xx);
        yy = y.transform(yy);
        return xx + yy;
    }

    @Override
    public String toString()
    {
        return super.toString() + " (" + x + " + " + y + ")";
    }

    public static int numberOfSubcycleGenerators()
    {
        return FACTORY.numberOfSubcycleGenerators();
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{xx, yy}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, 16);
        final long[] state = NumberFactory.makeLongArray(c[0]);
        xx = state[0];
        yy = state[1];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(int seed)
    {
        // The seeding procedure consists in going away from some
        // point known to be in the cycle.
        // The total number of calls to the "transform" method will
        // not exceed about 130,000 (which is negligible as seeding
        // will not occur more than once in normal usage).
        // Make two positive 16-bits integers from the 32-bit seed.
        // Add the small positive seed guard. The result will never be negative.
        final int xMax = (seed & 0xffff) + (SEED_GUARD & 0xff);
        final int yMax = (seed >>> 16) + (SEED_GUARD & 0xff);
        xx = x.getStart();
        for (int i = xMax; i > 0; i--)
        {
            xx = x.transform(xx);
        }
        yy = y.getStart();
        for (int i = yMax; i > 0; i--)
        {
            yy = y.transform(yy);
        }
    }

    static class Cmres
    {
        private static final String SEP        = ", ";
        private static final String HEX_FORMAT = "0x%016xL";
        private final int           start;
        private final long          multiply;
        private final int           rotate;

        Cmres(long multiply, int rotate, int start)
        {
            this.multiply = multiply;
            this.rotate = rotate;
            this.start = start;
        }

        @Override
        public String toString()
        {
            final String m = String.format((java.util.Locale) null, HEX_FORMAT, multiply);
            return "Cmres: [" + m + SEP + rotate + SEP + start + "]";
        }

        public long getMultiply()
        {
            return multiply;
        }

        public int getStart()
        {
            return start;
        }

        long transform(long state)
        {
            long s = state;
            s *= multiply;
            s = Long.rotateLeft(s, rotate);
            s -= state;
            return s;
        }

        static class Factory
        {
            private static final List<Cmres> TABLE = new ArrayList<>();
            //
            // Populates the table.
            // It lists parameters known to be good (provided in
            // the article referred to above).
            // To maintain compatibility, new entries must be added
            // only at the end of the table.
            //
            static
            {
                add(0xedce446814d3b3d9L, 33, 0x13b572e7);
                add(0xc5b3cf786c806df7L, 33, 0x13c8e18a);
                add(0xdd91bbb8ab9e0e65L, 31, 0x06dd03a6);
                add(0x7b69342c0790221dL, 31, 0x1646bb8b);
                add(0x0c72c0d18614c32bL, 33, 0x06014a3d);
                add(0xd8d98c13bebe26c9L, 33, 0x014e8475);
                add(0xcb039dc328bbc40fL, 31, 0x008684bd);
                add(0x858c5ef3c021ed2fL, 32, 0x0dc8d622);
                add(0x4c8be96bfc23b127L, 33, 0x0b6b20cc);
                add(0x11eab77f808cf641L, 32, 0x06534421);
                add(0xbc9bd78810fd28fdL, 31, 0x1d9ba40d);
                add(0x0f1505c780688cb5L, 33, 0x0b7b7b67);
                add(0xadc174babc2053afL, 31, 0x267f4197);
                add(0x900b6b82b31686d9L, 31, 0x023c6985);
                // Add new entries here.
            }

            int numberOfSubcycleGenerators()
            {
                return TABLE.size();
            }

            Cmres get(int index)
            {
                if (index < 0 || index >= TABLE.size())
                {
                    throw new IndexOutOfBoundsException("Out of interval [0, " + (TABLE.size() - 1) + "]");
                }
                return TABLE.get(index);
            }

            Cmres getIfDifferent(int index, int other)
            {
                if (index == other)
                {
                    throw new IllegalArgumentException("Subcycle generators must be different");
                }
                return get(index);
            }

            private static void add(long multiply, int rotate, int start)
            {
                // Validity check: if there are duplicates, the class initialization
                // will fail (and the JVM will report "NoClassDefFoundError").
                checkUnique(TABLE, multiply);
                TABLE.add(new Cmres(multiply, rotate, start));
            }

            static void checkUnique(List<Cmres> table, long multiply)
            {
                for (final Cmres sg : table)
                {
                    if (multiply == sg.getMultiply())
                    {
                        throw new IllegalStateException(INTERNAL_ERROR_MSG);
                    }
                }
            }
        }
    }
}
