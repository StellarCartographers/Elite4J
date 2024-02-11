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
import elite.dangerous.util.testing.rng.NumberFactory;

abstract class AbstractXoRoShiRo128 extends LongProvider implements LongJumpableUniformRandomProvider
{
    private static final int    SEED_SIZE              = 2;
    private static final long[] JUMP_COEFFICIENTS      = {0xdf900294d8f554a5L, 0x170865df4b3201fcL};
    private static final long[] LONG_JUMP_COEFFICIENTS = {0xd2a98b26625eee7bL, 0xdddf9b1090aa7ac1L};
    // State is maintained using variables rather than an array for performance
    protected long              state0;
    protected long              state1;

    AbstractXoRoShiRo128(long[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            final long[] state = new long[SEED_SIZE];
            fillState(state, seed);
            setState(state);
        } else
        {
            setState(seed);
        }
    }

    AbstractXoRoShiRo128(long seed0, long seed1)
    {
        state0 = seed0;
        state1 = seed1;
    }

    protected AbstractXoRoShiRo128(AbstractXoRoShiRo128 source)
    {
        super(source);
        state0 = source.state0;
        state1 = source.state1;
    }

    private void setState(long[] state)
    {
        state0 = state[0];
        state1 = state[1];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{state0, state1}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * 8);
        setState(NumberFactory.makeLongArray(c[0]));
        super.setStateInternal(c[1]);
    }

    @Override
    public long next()
    {
        final long result = nextOutput();
        final long s0 = state0;
        long s1 = state1;
        s1 ^= s0;
        state0 = Long.rotateLeft(s0, 24) ^ s1 ^ (s1 << 16); // a, b
        state1 = Long.rotateLeft(s1, 37); // c
        return result;
    }

    protected abstract long nextOutput();

    @Override
    public UniformRandomProvider jump()
    {
        final UniformRandomProvider copy = copy();
        performJump(JUMP_COEFFICIENTS);
        return copy;
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        final JumpableUniformRandomProvider copy = copy();
        performJump(LONG_JUMP_COEFFICIENTS);
        return copy;
    }

    protected abstract AbstractXoRoShiRo128 copy();

    final void performJump(long[] jumpCoefficients)
    {
        long s0 = 0;
        long s1 = 0;
        for (final long jc : jumpCoefficients)
        {
            for (int b = 0; b < 64; b++)
            {
                if ((jc & (1L << b)) != 0)
                {
                    s0 ^= state0;
                    s1 ^= state1;
                }
                next();
            }
        }
        state0 = s0;
        state1 = s1;
        resetCachedState();
    }
}
