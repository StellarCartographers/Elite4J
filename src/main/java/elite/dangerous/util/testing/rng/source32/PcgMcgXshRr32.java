/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class PcgMcgXshRr32 extends AbstractPcgMcg6432
{
    public PcgMcgXshRr32(Long seed)
    {
        super(seed);
    }

    @Override
    protected int transform(long x)
    {
        final int count = (int) (x >>> 59);
        return Integer.rotateRight((int) ((x ^ (x >>> 18)) >>> 27), count);
    }
}
