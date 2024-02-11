/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

public class ByteArray2IntArray implements SeedConverter<byte[], int[]>
{
    @Override
    public int[] convert(byte[] seed)
    {
        // Full length conversion
        return Conversions.byteArray2IntArray(seed, Conversions.intSizeFromByteSize(seed.length));
    }
}