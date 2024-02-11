/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

import elite.dangerous.util.testing.provider.*;
import elite.dangerous.util.testing.rng.NumberFactory;

abstract class AbstractXoShiRo128 extends IntProvider implements LongJumpableUniformRandomProvider
{
    private static final int   SEED_SIZE              = 4;
    private static final int[] JUMP_COEFFICIENTS      = {0x8764000b, 0xf542d2d3, 0x6fa035c3, 0x77f2db5b};
    private static final int[] LONG_JUMP_COEFFICIENTS = {0xb523952e, 0x0b6f099f, 0xccf5a0ef, 0x1c580662};
    // State is maintained using variables rather than an array for performance
    protected int              state0;
    protected int              state1;
    protected int              state2;
    protected int              state3;

    AbstractXoShiRo128(int[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            final int[] state = new int[SEED_SIZE];
            fillState(state, seed);
            setState(state);
        } else
        {
            setState(seed);
        }
    }

    AbstractXoShiRo128(int seed0, int seed1, int seed2, int seed3)
    {
        state0 = seed0;
        state1 = seed1;
        state2 = seed2;
        state3 = seed3;
    }

    protected AbstractXoShiRo128(AbstractXoShiRo128 source)
    {
        super(source);
        state0 = source.state0;
        state1 = source.state1;
        state2 = source.state2;
        state3 = source.state3;
    }

    private void setState(int[] state)
    {
        state0 = state[0];
        state1 = state[1];
        state2 = state[2];
        state3 = state[3];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new int[]{state0, state1, state2, state3}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * 4);
        setState(NumberFactory.makeIntArray(c[0]));
        super.setStateInternal(c[1]);
    }

    @Override
    public int next()
    {
        final int result = nextOutput();
        final int t = state1 << 9;
        state2 ^= state0;
        state3 ^= state1;
        state1 ^= state2;
        state0 ^= state3;
        state2 ^= t;
        state3 = Integer.rotateLeft(state3, 11);
        return result;
    }

    protected abstract int nextOutput();

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

    protected abstract AbstractXoShiRo128 copy();

    private void performJump(int[] jumpCoefficients)
    {
        int s0 = 0;
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        for (final int jc : jumpCoefficients)
        {
            for (int b = 0; b < 32; b++)
            {
                if ((jc & (1 << b)) != 0)
                {
                    s0 ^= state0;
                    s1 ^= state1;
                    s2 ^= state2;
                    s3 ^= state3;
                }
                next();
            }
        }
        state0 = s0;
        state1 = s1;
        state2 = s2;
        state3 = s3;
        resetCachedState();
    }
}
