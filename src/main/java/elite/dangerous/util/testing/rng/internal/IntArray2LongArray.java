/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

public class IntArray2LongArray implements SeedConverter<int[], long[]>
{
    @Override
    public long[] convert(int[] seed)
    {
        // Full length conversion
        return Conversions.intArray2LongArray(seed, Conversions.longSizeFromIntSize(seed.length));
    }
}
