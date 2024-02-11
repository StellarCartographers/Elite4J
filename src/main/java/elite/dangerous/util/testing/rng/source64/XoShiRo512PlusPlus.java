/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

public class XoShiRo512PlusPlus extends AbstractXoShiRo512
{
    public XoShiRo512PlusPlus(long[] seed)
    {
        super(seed);
    }

    public XoShiRo512PlusPlus(long seed0, long seed1, long seed2, long seed3, long seed4, long seed5, long seed6, long seed7)
    {
        super(seed0, seed1, seed2, seed3, seed4, seed5, seed6, seed7);
    }

    protected XoShiRo512PlusPlus(XoShiRo512PlusPlus source)
    {
        super(source);
    }

    @Override
    protected long nextOutput()
    {
        return Long.rotateLeft(state0 + state2, 17) + state2;
    }

    @Override
    protected XoShiRo512PlusPlus copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new XoShiRo512PlusPlus(this);
    }
}
