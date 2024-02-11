/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

final class LXMSupport
{
    static final int M32             = 0xadb4a92d;
    static final int M32P            = 0x65640001;
    static final int C32P            = 0x046b0000;
    static final int GOLDEN_RATIO_32 = 0x9e3779b9;

    private LXMSupport()
    {
    }

    static int lea32(int x)
    {
        x = (x ^ (x >>> 16)) * 0xd36d884b;
        x = (x ^ (x >>> 16)) * 0xd36d884b;
        return x ^ (x >>> 16);
    }
}
