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

abstract class AbstractXoShiRo512 extends LongProvider implements LongJumpableUniformRandomProvider
{
    private static final int    SEED_SIZE              = 8;
    private static final long[] JUMP_COEFFICIENTS      = {0x33ed89b6e7a353f9L, 0x760083d7955323beL, 0x2837f2fbb5f22faeL, 0x4b8c5674d309511cL, 0xb11ac47a7ba28c25L, 0xf1be7667092bcc1cL, 0x53851efdb6df0aafL, 0x1ebbc8b23eaf25dbL};
    private static final long[] LONG_JUMP_COEFFICIENTS = {0x11467fef8f921d28L, 0xa2a819f2e79c8ea8L, 0xa8299fc284b3959aL, 0xb4d347340ca63ee1L, 0x1cb0940bedbff6ceL, 0xd956c5c4fa1f8e17L, 0x915e38fd4eda93bcL, 0x5b3ccdfa5d7daca5L};
    // State is maintained using variables rather than an array for performance
    protected long              state0;
    protected long              state1;
    protected long              state2;
    protected long              state3;
    protected long              state4;
    protected long              state5;
    protected long              state6;
    protected long              state7;

    AbstractXoShiRo512(long[] seed)
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

    AbstractXoShiRo512(long seed0, long seed1, long seed2, long seed3, long seed4, long seed5, long seed6, long seed7)
    {
        state0 = seed0;
        state1 = seed1;
        state2 = seed2;
        state3 = seed3;
        state4 = seed4;
        state5 = seed5;
        state6 = seed6;
        state7 = seed7;
    }

    protected AbstractXoShiRo512(AbstractXoShiRo512 source)
    {
        super(source);
        state0 = source.state0;
        state1 = source.state1;
        state2 = source.state2;
        state3 = source.state3;
        state4 = source.state4;
        state5 = source.state5;
        state6 = source.state6;
        state7 = source.state7;
    }

    private void setState(long[] state)
    {
        state0 = state[0];
        state1 = state[1];
        state2 = state[2];
        state3 = state[3];
        state4 = state[4];
        state5 = state[5];
        state6 = state[6];
        state7 = state[7];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{state0, state1, state2, state3, state4, state5, state6, state7}), super.getStateInternal());
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
        final long t = state1 << 11;
        state2 ^= state0;
        state5 ^= state1;
        state1 ^= state2;
        state7 ^= state3;
        state3 ^= state4;
        state4 ^= state5;
        state0 ^= state6;
        state6 ^= state7;
        state6 ^= t;
        state7 = Long.rotateLeft(state7, 21);
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

    protected abstract AbstractXoShiRo512 copy();

    private void performJump(long[] jumpCoefficients)
    {
        long s0 = 0;
        long s1 = 0;
        long s2 = 0;
        long s3 = 0;
        long s4 = 0;
        long s5 = 0;
        long s6 = 0;
        long s7 = 0;
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
                    s4 ^= state4;
                    s5 ^= state5;
                    s6 ^= state6;
                    s7 ^= state7;
                }
                next();
            }
        }
        state0 = s0;
        state1 = s1;
        state2 = s2;
        state3 = s3;
        state4 = s4;
        state5 = s5;
        state6 = s6;
        state7 = s7;
        resetCachedState();
    }
}
