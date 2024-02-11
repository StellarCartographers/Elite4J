/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

public class XoShiRo256StarStar extends AbstractXoShiRo256
{
    public XoShiRo256StarStar(long[] seed)
    {
        super(seed);
    }

    public XoShiRo256StarStar(long seed0, long seed1, long seed2, long seed3)
    {
        super(seed0, seed1, seed2, seed3);
    }

    protected XoShiRo256StarStar(XoShiRo256StarStar source)
    {
        super(source);
    }

    @Override
    protected long nextOutput()
    {
        return Long.rotateLeft(state1 * 5, 7) * 9;
    }

    @Override
    protected XoShiRo256StarStar copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new XoShiRo256StarStar(this);
    }
}
