/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class PcgXshRr32 extends AbstractPcg6432
{
    public PcgXshRr32(Long seed)
    {
        super(seed);
    }

    public PcgXshRr32(long[] seed)
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
