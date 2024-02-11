/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class Well19937a extends AbstractWell
{
    private static final int        K     = 19937;
    private static final int        M1    = 70;
    private static final int        M2    = 179;
    private static final int        M3    = 449;
    private static final IndexTable TABLE = new IndexTable(K, M1, M2, M3);

    public Well19937a(int[] seed)
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
        final int z0 = (0x80000000 & v[indexRm1]) ^ (0x7FFFFFFF & v[indexRm2]);
        final int z1 = (v0 ^ (v0 << 25)) ^ (vM1 ^ (vM1 >>> 27));
        final int z2 = (vM2 >>> 9) ^ (vM3 ^ (vM3 >>> 1));
        final int z3 = z1 ^ z2;
        final int z4 = z0 ^ (z1 ^ (z1 << 9)) ^ (z2 ^ (z2 << 21)) ^ (z3 ^ (z3 >>> 21));
        v[index] = z3;
        v[indexRm1] = z4;
        v[indexRm2] &= 0x80000000;
        index = indexRm1;
        return z4;
    }
}
