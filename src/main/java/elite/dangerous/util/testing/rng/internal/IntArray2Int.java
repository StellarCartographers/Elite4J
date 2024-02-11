/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

public class IntArray2Int implements SeedConverter<int[], Integer>
{
    @Override
    public Integer convert(int[] seed)
    {
        return Conversions.intArray2Int(seed);
    }
}
