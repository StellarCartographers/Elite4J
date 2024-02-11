/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

public class Long2IntArray implements Seed2ArrayConverter<Long, int[]>
{
    private final int size;

    public Long2IntArray(int size)
    {
        this.size = size;
    }

    @Override
    public int[] convert(Long seed)
    {
        return convert(seed, size);
    }

    @Override
    public int[] convert(Long seed, int outputSize)
    {
        return Conversions.long2IntArray(seed, outputSize);
    }
}
