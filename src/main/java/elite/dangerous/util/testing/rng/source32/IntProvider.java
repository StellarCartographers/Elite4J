/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

import elite.dangerous.util.testing.provider.BaseProvider;
import elite.dangerous.util.testing.rng.NumberFactory;

public abstract class IntProvider extends BaseProvider implements RandomIntSource
{
    private static final int EMPTY_BOOL_SOURCE = 1;
    private int              booleanSource     = EMPTY_BOOL_SOURCE;

    public IntProvider()
    {
        super();
    }

    protected IntProvider(IntProvider source)
    {
        booleanSource = source.booleanSource;
    }

    protected void resetCachedState()
    {
        booleanSource = EMPTY_BOOL_SOURCE;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(booleanSource), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, Integer.BYTES);
        booleanSource = NumberFactory.makeInt(c[0]);
        super.setStateInternal(c[1]);
    }

    @Override
    public int nextInt()
    {
        return next();
    }

    @Override
    public boolean nextBoolean()
    {
        int bits = booleanSource;
        if (bits == 1)
        {
            // Refill
            bits = next();
            // Store a refill flag in the sign bit and the unused 31 bits, return lowest bit
            booleanSource = Integer.MIN_VALUE | (bits >>> 1);
            return (bits & 0x1) == 1;
        }
        // Shift down eventually triggering refill, return current lowest bit
        booleanSource = bits >>> 1;
        return (bits & 0x1) == 1;
    }

    @Override
    public double nextDouble()
    {
        return NumberFactory.makeDouble(next(), next());
    }

    @Override
    public long nextLong()
    {
        return NumberFactory.makeLong(next(), next());
    }

    @Override
    public void nextBytes(byte[] bytes)
    {
        nextBytesFill(this, bytes, 0, bytes.length);
    }

    @Override
    public void nextBytes(byte[] bytes, int start, int len)
    {
        checkFromIndexSize(start, len, bytes.length);
        nextBytesFill(this, bytes, start, len);
    }

    static void nextBytesFill(RandomIntSource source, byte[] bytes, int start, int len)
    {
        int index = start; // Index of first insertion.
        // Index of first insertion plus multiple of 4 part of length
        // (i.e. length with 2 least significant bits unset).
        final int indexLoopLimit = index + (len & 0x7ffffffc);
        // Start filling in the byte array, 4 bytes at a time.
        while (index < indexLoopLimit)
        {
            final int random = source.next();
            bytes[index++] = (byte) random;
            bytes[index++] = (byte) (random >>> 8);
            bytes[index++] = (byte) (random >>> 16);
            bytes[index++] = (byte) (random >>> 24);
        }
        final int indexLimit = start + len; // Index of last insertion + 1.
        // Fill in the remaining bytes.
        if (index < indexLimit)
        {
            int random = source.next();
            while (true)
            {
                bytes[index++] = (byte) random;
                if (index < indexLimit)
                {
                    random >>>= 8;
                } else
                {
                    break;
                }
            }
        }
    }

    private static int checkFromIndexSize(int fromIndex, int size, int length)
    {
        // check for any negatives,
        // or overflow safe length check given the values are all positive
        // remaining = length - fromIndex
        if ((fromIndex | size | length) < 0 || size > length - fromIndex)
        {
            throw new IndexOutOfBoundsException(
                            // Note: %<d is 'relative indexing' to re-use the last argument
                            String.format("Range [%d, %<d + %d) out of bounds for length %d", fromIndex, size, length));
        }
        return fromIndex;
    }
}
