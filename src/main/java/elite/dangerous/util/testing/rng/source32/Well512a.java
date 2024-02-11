/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class Well512a extends AbstractWell
{
    private static final int        K     = 512;
    private static final int        M1    = 13;
    private static final int        M2    = 9;
    private static final int        M3    = 5;
    private static final IndexTable TABLE = new IndexTable(K, M1, M2, M3);

    public Well512a(int[] seed)
    {
        super(K, seed);
    }

    @Override
    public int next()
    {
        final int indexRm1 = TABLE.getIndexPred(index);
        final int vi = v[index];
        final int vi1 = v[TABLE.getIndexM1(index)];
        final int vi2 = v[TABLE.getIndexM2(index)];
        final int z0 = v[indexRm1];
        // the values below include the errata of the original article
        final int z1 = (vi ^ (vi << 16)) ^ (vi1 ^ (vi1 << 15));
        final int z2 = vi2 ^ (vi2 >>> 11);
        final int z3 = z1 ^ z2;
        final int z4 = (z0 ^ (z0 << 2)) ^ (z1 ^ (z1 << 18)) ^ (z2 << 28) ^ (z3 ^ ((z3 << 5) & 0xda442d24));
        v[index] = z3;
        v[indexRm1] = z4;
        index = indexRm1;
        return z4;
    }
}
