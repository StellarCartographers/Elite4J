/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import elite.dangerous.util.testing.provider.*;

public class XoRoShiRo128PlusPlus extends AbstractXoRoShiRo128
{
    private static final long[] JUMP_COEFFICIENTS      = {0x2bd7a6a6e99c2ddcL, 0x0992ccaf6a6fca05L};
    private static final long[] LONG_JUMP_COEFFICIENTS = {0x360fd5f2cf8d5d99L, 0x9c6e6877736c46e3L};

    public XoRoShiRo128PlusPlus(long[] seed)
    {
        super(seed);
    }

    public XoRoShiRo128PlusPlus(long seed0, long seed1)
    {
        super(seed0, seed1);
    }

    protected XoRoShiRo128PlusPlus(XoRoShiRo128PlusPlus source)
    {
        super(source);
    }

    @Override
    public long next()
    {
        // Override the abstract class to use a different state update step.
        // Note: This requires different jump coefficients.
        final long s0 = state0;
        long s1 = state1;
        final long result = Long.rotateLeft(s0 + s1, 17) + s0;
        s1 ^= s0;
        state0 = Long.rotateLeft(s0, 49) ^ s1 ^ (s1 << 21); // a, b
        state1 = Long.rotateLeft(s1, 28); // c
        return result;
    }

    @Override
    protected long nextOutput()
    {
        throw new UnsupportedOperationException("The PlusPlus algorithm redefines the next() method");
    }

    @Override
    public UniformRandomProvider jump()
    {
        // Duplicated from the abstract class to change the jump coefficients
        final UniformRandomProvider copy = copy();
        performJump(JUMP_COEFFICIENTS);
        return copy;
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        // Duplicated from the abstract class to change the jump coefficients
        final JumpableUniformRandomProvider copy = copy();
        performJump(LONG_JUMP_COEFFICIENTS);
        return copy;
    }

    @Override
    protected XoRoShiRo128PlusPlus copy()
    {
        // This exists to ensure the jump function performed in the super class returns
        // the correct class type. It should not be public.
        return new XoRoShiRo128PlusPlus(this);
    }
}
