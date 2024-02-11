/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class Well1024a extends AbstractWell
{
    private static final int        K     = 1024;
    private static final int        M1    = 3;
    private static final int        M2    = 24;
    private static final int        M3    = 10;
    private static final IndexTable TABLE = new IndexTable(K, M1, M2, M3);

    public Well1024a(int[] seed)
    {
        super(K, seed);
    }

    @Override
    public int next()
    {
        final int indexRm1 = TABLE.getIndexPred(index);
        final int v0 = v[index];
        final int vM1 = v[TABLE.getIndexM1(index)];
        final int vM2 = v[TABLE.getIndexM2(index)];
        final int vM3 = v[TABLE.getIndexM3(index)];
        final int z0 = v[indexRm1];
        final int z1 = v0 ^ (vM1 ^ (vM1 >>> 8));
        final int z2 = (vM2 ^ (vM2 << 19)) ^ (vM3 ^ (vM3 << 14));
        final int z3 = z1 ^ z2;
        final int z4 = (z0 ^ (z0 << 11)) ^ (z1 ^ (z1 << 7)) ^ (z2 ^ (z2 << 13));
        v[index] = z3;
        v[indexRm1] = z4;
        index = indexRm1;
        return z4;
    }
}
