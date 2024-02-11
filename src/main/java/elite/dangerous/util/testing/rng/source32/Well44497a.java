/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class Well44497a extends AbstractWell
{
    private static final int        K     = 44497;
    private static final int        M1    = 23;
    private static final int        M2    = 481;
    private static final int        M3    = 229;
    private static final IndexTable TABLE = new IndexTable(K, M1, M2, M3);

    public Well44497a(int[] seed)
    {
        super(K, seed);
    }

    @Override
    public int next()
    {
        final int indexRm1 = TABLE.getIndexPred(index);
        final int indexRm2 = TABLE.getIndexPred2(index);
        final int v0 = v[index];
        final int vM1 = v[TABLE.getIndexM1(index)];
        final int vM2 = v[TABLE.getIndexM2(index)];
        final int vM3 = v[TABLE.getIndexM3(index)];
        // the values below include the errata of the original article
        final int z0 = (0xFFFF8000 & v[indexRm1]) ^ (0x00007FFF & v[indexRm2]);
        final int z1 = (v0 ^ (v0 << 24)) ^ (vM1 ^ (vM1 >>> 30));
        final int z2 = (vM2 ^ (vM2 << 10)) ^ (vM3 << 26);
        final int z3 = z1 ^ z2;
        final int z2Prime = ((z2 << 9) ^ (z2 >>> 23)) & 0xfbffffff;
        final int z2Second = ((z2 & 0x00020000) == 0) ? z2Prime : (z2Prime ^ 0xb729fcec);
        final int z4 = z0 ^ (z1 ^ (z1 >>> 20)) ^ z2Second ^ z3;
        v[index] = z3;
        v[indexRm1] = z4;
        v[indexRm2] &= 0xFFFF8000;
        index = indexRm1;
        return z4;
    }
}
