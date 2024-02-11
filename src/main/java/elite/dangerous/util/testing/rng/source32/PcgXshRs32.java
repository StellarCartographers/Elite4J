/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class PcgXshRs32 extends AbstractPcg6432
{
    public PcgXshRs32(Long seed)
    {
        super(seed);
    }

    public PcgXshRs32(long[] seed)
    {
        super(seed);
    }

    @Override
    protected int transform(long x)
    {
        final int count = (int) (x >>> 61);
        return (int) ((x ^ (x >>> 22)) >>> (22 + count));
    }
}
