/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

public class Int2Long implements SeedConverter<Integer, Long>
{
    @Override
    public Long convert(Integer seed)
    {
        return Conversions.int2Long(seed);
    }
}
