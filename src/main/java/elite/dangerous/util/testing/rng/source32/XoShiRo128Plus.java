/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class XoShiRo128Plus extends AbstractXoShiRo128
{
    public XoShiRo128Plus(int[] seed)
    {
        super(seed);
    }

    public XoShiRo128Plus(int seed0, int seed1, int seed2, int seed3)
    {
        super(seed0, seed1, seed2, seed3);
    }

    protected XoShiRo128Plus(XoShiRo128Plus source)
    {
        super(source);
    }

    @Override
    protected int nextOutput()
    {
        return state0 + state3;
    }

    @Override
    protected XoShiRo128Plus copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new XoShiRo128Plus(this);
    }
}
