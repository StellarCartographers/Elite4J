/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

public class XoRoShiRo64Star extends AbstractXoRoShiRo64
{
    public XoRoShiRo64Star(int[] seed)
    {
        super(seed);
    }

    public XoRoShiRo64Star(int seed0, int seed1)
    {
        super(seed0, seed1);
    }

    @Override
    protected int nextOutput()
    {
        return state0 * 0x9e3779bb;
    }
}
