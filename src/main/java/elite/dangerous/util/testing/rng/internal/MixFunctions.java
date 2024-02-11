/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

final class MixFunctions
{
    static final long GOLDEN_RATIO_64 = 0x9e3779b97f4a7c15L;
    static final int  GOLDEN_RATIO_32 = 0x9e3779b9;

    private MixFunctions()
    {
    }

    static long stafford13(long x)
    {
        x = (x ^ (x >>> 30)) * 0xbf58476d1ce4e5b9L;
        x = (x ^ (x >>> 27)) * 0x94d049bb133111ebL;
        return x ^ (x >>> 31);
    }

    static int murmur3(int x)
    {
        x = (x ^ (x >>> 16)) * 0x85ebca6b;
        x = (x ^ (x >>> 13)) * 0xc2b2ae35;
        return x ^ (x >>> 16);
    }
}
