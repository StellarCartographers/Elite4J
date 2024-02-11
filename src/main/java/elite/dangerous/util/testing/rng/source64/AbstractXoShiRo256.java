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

abstract class AbstractXoShiRo256 extends LongProvider implements LongJumpableUniformRandomProvider
{
    private static final int    SEED_SIZE              = 4;
    private static final long[] JUMP_COEFFICIENTS      = {0x180ec6d33cfd0abaL, 0xd5a61266f0c9392cL, 0xa9582618e03fc9aaL, 0x39abdc4529b1661cL};
    private static final long[] LONG_JUMP_COEFFICIENTS = {0x76e15d3efefdcbbfL, 0xc5004e441c522fb3L, 0x77710069854ee241L, 0x39109bb02acbe635L};
    // State is maintained using variables rather than an array for performance
    protected long              state0;
    protected long              state1;
    protected long              state2;
    protected long              state3;

    AbstractXoShiRo256(long[] seed)
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

    AbstractXoShiRo256(long seed0, long seed1, long seed2, long seed3)
    {
        state0 = seed0;
        state1 = seed1;
        state2 = seed2;
        state3 = seed3;
    }

    protected AbstractXoShiRo256(AbstractXoShiRo256 source)
    {
        super(source);
        state0 = source.state0;
        state1 = source.state1;
        state2 = source.state2;
        state3 = source.state3;
    }

    private void setState(long[] state)
    {
        state0 = state[0];
        state1 = state[1];
        state2 = state[2];
        state3 = state[3];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{state0, state1, state2, state3}), super.getStateInternal());
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
        final long t = state1 << 17;
        state2 ^= state0;
        state3 ^= state1;
        state1 ^= state2;
        state0 ^= state3;
        state2 ^= t;
        state3 = Long.rotateLeft(state3, 45);
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

    protected abstract AbstractXoShiRo256 copy();

    private void performJump(long[] jumpCoefficients)
    {
        long s0 = 0;
        long s1 = 0;
        long s2 = 0;
        long s3 = 0;
        for (final long jc : jumpCoefficients)
        {
            for (int b = 0; b < 64; b++)
            {
                if ((jc & (1L << b)) != 0)
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
