/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

public class XoRoShiRo1024StarStar extends AbstractXoRoShiRo1024
{
    public XoRoShiRo1024StarStar(long[] seed)
    {
        super(seed);
    }

    protected XoRoShiRo1024StarStar(XoRoShiRo1024StarStar source)
    {
        super(source);
    }

    @Override
    protected long transform(long s0, long s15)
    {
        return Long.rotateLeft(s0 * 5, 7) * 9;
    }

    @Override
    protected XoRoShiRo1024StarStar copy()
    {
        // This exists to ensure the jump function returns
        // the correct class type. It should not be public.
        return new XoRoShiRo1024StarStar(this);
    }
}
