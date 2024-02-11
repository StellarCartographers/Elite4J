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

public class XorShift1024Star extends LongProvider implements JumpableUniformRandomProvider
{
    private static final int    SEED_SIZE         = 16;
    private static final long[] JUMP_COEFFICIENTS = {0x84242f96eca9c41dL, 0xa3c65b8776f96855L, 0x5b34a39f070b5837L, 0x4489affce4f31a1eL, 0x2ffeeb0a48316f40L, 0xdc2d9891fe68c022L, 0x3659132bb12fea70L, 0xaac17d8efa43cab8L, 0xc4cb815590989b13L, 0x5ee975283d71c93bL,
                    0x691548c86c1bd540L, 0x7910c41d10a1e6a5L, 0x0b5fc64563b3e2a8L, 0x047f7684e9fc949dL, 0xb99181f2d8f685caL, 0x284600e3f30e38c3L};
    private final long[]        state             = new long[SEED_SIZE];
    private final long          multiplier;
    private int                 index;

    public XorShift1024Star(long[] seed)
    {
        this(seed, 1181783497276652981L);
    }

    protected XorShift1024Star(long[] seed, long multiplier)
    {
        setSeedInternal(seed);
        this.multiplier = multiplier;
    }

    protected XorShift1024Star(XorShift1024Star source)
    {
        super(source);
        System.arraycopy(source.state, 0, state, 0, SEED_SIZE);
        multiplier = source.multiplier;
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
        final long s0 = state[index];
        index = (index + 1) & 15;
        long s1 = state[index];
        s1 ^= s1 << 31; // a
        state[index] = s1 ^ s0 ^ (s1 >>> 11) ^ (s0 >>> 30); // b,c
        return state[index] * multiplier;
    }

    @Override
    public UniformRandomProvider jump()
    {
        final UniformRandomProvider copy = copy();
        performJump();
        return copy;
    }

    protected XorShift1024Star copy()
    {
        // This exists to ensure the jump function returns
        // the correct class type. It should not be public.
        return new XorShift1024Star(this);
    }

    private void performJump()
    {
        final long[] newState = new long[SEED_SIZE];
        for (final long jc : JUMP_COEFFICIENTS)
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
        for (int j = 0; j < 16; j++)
        {
            state[(j + index) & 15] = newState[j];
        }
        resetCachedState();
    }
}
