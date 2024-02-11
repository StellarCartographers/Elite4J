/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

public class XoRoShiRo1024Star extends AbstractXoRoShiRo1024
{
    public XoRoShiRo1024Star(long[] seed)
    {
        super(seed);
    }

    protected XoRoShiRo1024Star(XoRoShiRo1024Star source)
    {
        super(source);
    }

    @Override
    protected long transform(long s0, long s15)
    {
        return s0 * 0x9e3779b97f4a7c13L;
    }

    @Override
    protected XoRoShiRo1024Star copy()
    {
        // This exists to ensure the jump function returns
        // the correct class type. It should not be public.
        return new XoRoShiRo1024Star(this);
    }
}
