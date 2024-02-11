/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

public class XorShift1024StarPhi extends XorShift1024Star
{
    public XorShift1024StarPhi(long[] seed)
    {
        super(seed, 0x9e3779b97f4a7c13L);
    }

    protected XorShift1024StarPhi(XorShift1024StarPhi source)
    {
        super(source);
    }

    @Override
    protected XorShift1024StarPhi copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new XorShift1024StarPhi(this);
    }
}
