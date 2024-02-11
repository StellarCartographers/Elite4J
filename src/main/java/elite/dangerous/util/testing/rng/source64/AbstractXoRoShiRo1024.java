/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import java.util.Arrays;

import elite.dangerous.util.testing.provider.*;
import elite.dangerous.util.testing.rng.NumberFactory;

abstract class AbstractXoRoShiRo1024 extends LongProvider implements LongJumpableUniformRandomProvider
{
    private static final int    SEED_SIZE              = 16;
    private static final long[] JUMP_COEFFICIENTS      = {0x931197d8e3177f17L, 0xb59422e0b9138c5fL, 0xf06a6afb49d668bbL, 0xacb8a6412c8a1401L, 0x12304ec85f0b3468L, 0xb7dfe7079209891eL, 0x405b7eec77d9eb14L, 0x34ead68280c44e4aL, 0xe0e4ba3e0ac9e366L, 0x8f46eda8348905b7L,
                    0x328bf4dbad90d6ffL, 0xc8fd6fb31c9effc3L, 0xe899d452d4b67652L, 0x45f387286ade3205L, 0x03864f454a8920bdL, 0xa68fa28725b1b384L,};
    private static final long[] LONG_JUMP_COEFFICIENTS = {0x7374156360bbf00fL, 0x4630c2efa3b3c1f6L, 0x6654183a892786b1L, 0x94f7bfcbfb0f1661L, 0x27d8243d3d13eb2dL, 0x9701730f3dfb300fL, 0x2f293baae6f604adL, 0xa661831cb60cd8b6L, 0x68280c77d9fe008cL, 0x50554160f5ba9459L,
                    0x2fc20b17ec7b2a9aL, 0x49189bbdc8ec9f8fL, 0x92a65bca41852cc1L, 0xf46820dd0509c12aL, 0x52b00c35fbf92185L, 0x1e5b3b7f589e03c1L,};
    private final long[]        state                  = new long[SEED_SIZE];
    private int                 index;

    AbstractXoRoShiRo1024(long[] seed)
    {
        setSeedInternal(seed);
    }

    protected AbstractXoRoShiRo1024(AbstractXoRoShiRo1024 source)
    {
        super(source);
        System.arraycopy(source.state, 0, state, 0, SEED_SIZE);
        index = source.index;
    }

    @Override
    protected byte[] getStateInternal()
    {
        final long[] s = Arrays.copyOf(state, SEED_SIZE + 1);
        s[SEED_SIZE] = index;
        return composeStateInternal(NumberFactory.makeByteArray(s), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, (SEED_SIZE + 1) * 8);
        final long[] tmp = NumberFactory.makeLongArray(c[0]);
        System.arraycopy(tmp, 0, state, 0, SEED_SIZE);
        index = (int) tmp[SEED_SIZE];
        super.setStateInternal(c[1]);
    }

    private void setSeedInternal(long[] seed)
    {
        // Reset the whole state of this RNG (i.e. "state" and "index").
        // Filling procedure is not part of the reference code.
        fillState(state, seed);
        index = 0;
    }

    @Override
    public long next()
    {
        final int q = index;
        index = (index + 1) & 15;
        final long s0 = state[index];
        long s15 = state[q];
        final long result = transform(s0, s15);
        s15 ^= s0;
        state[q] = Long.rotateLeft(s0, 25) ^ s15 ^ (s15 << 27);
        state[index] = Long.rotateLeft(s15, 36);
        return result;
    }

    protected abstract long transform(long s0, long s15);

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

    protected abstract AbstractXoRoShiRo1024 copy();

    private void performJump(long[] jumpCoefficients)
    {
        final long[] newState = new long[SEED_SIZE];
        for (final long jc : jumpCoefficients)
        {
            for (int b = 0; b < 64; b++)
            {
                if ((jc & (1L << b)) != 0)
                {
                    for (int i = 0; i < SEED_SIZE; i++)
                    {
                        newState[i] ^= state[(i + index) & 15];
                    }
                }
                next();
            }
        }
        // Note: Calling the next() function updates 'index'.
        // The present index effectively becomes 0.
        for (int j = 0; j < 16; j++)
        {
            state[(j + index) & 15] = newState[j];
        }
        resetCachedState();
    }
}
