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

public class Long2Int implements SeedConverter<Long, Integer>
{
    @SuppressWarnings("deprecation")
    @Override
    public Integer convert(Long seed)
    {
        return NumberFactory.makeInt(seed);
    }
}
