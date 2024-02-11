/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class Well19937c extends Well19937a
{
    public Well19937c(int[] seed)
    {
        super(seed);
    }

    @Override
    public int next()
    {
        int z4 = super.next();
        // Matsumoto-Kurita tempering to get a maximally equidistributed generator.
        z4 ^= (z4 << 7) & 0xe46e1700;
        z4 ^= (z4 << 15) & 0x9b868000;
        return z4;
    }
}
