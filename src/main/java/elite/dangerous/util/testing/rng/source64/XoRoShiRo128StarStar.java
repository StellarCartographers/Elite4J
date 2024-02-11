/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

public class XoRoShiRo128StarStar extends AbstractXoRoShiRo128
{
    public XoRoShiRo128StarStar(long[] seed)
    {
        super(seed);
    }

    public XoRoShiRo128StarStar(long seed0, long seed1)
    {
        super(seed0, seed1);
    }

    protected XoRoShiRo128StarStar(XoRoShiRo128StarStar source)
    {
        super(source);
    }

    @Override
    protected long nextOutput()
    {
        return Long.rotateLeft(state0 * 5, 7) * 9;
    }

    @Override
    protected XoRoShiRo128StarStar copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new XoRoShiRo128StarStar(this);
    }
}
