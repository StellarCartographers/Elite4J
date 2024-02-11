/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source64;

import elite.dangerous.util.testing.rng.NumberFactory;

public class PcgRxsMXs64 extends LongProvider
{
    private static final int  SEED_SIZE         = 2;
    private static final long DEFAULT_INCREMENT = 1442695040888963407L;
    private long              state;
    private long              increment;

    public PcgRxsMXs64(Long seed)
    {
        increment = DEFAULT_INCREMENT;
        state = bump(seed + this.increment);
    }

    public PcgRxsMXs64(long[] seed)
    {
        if (seed.length < SEED_SIZE)
        {
            final long[] tmp = new long[SEED_SIZE];
            fillState(tmp, seed);
            setSeedInternal(tmp);
        } else
        {
            setSeedInternal(seed);
        }
    }

    private void setSeedInternal(long[] seed)
    {
        // Ensure the increment is odd to provide a maximal period LCG.
        this.increment = (seed[1] << 1) | 1;
        this.state = bump(seed[0] + this.increment);
    }

    private long bump(long input)
    {
        return input * 6364136223846793005L + increment;
    }

    @Override
    public long next()
    {
        final long x = state;
        state = bump(state);
        final long word = ((x >>> ((x >>> 59) + 5)) ^ x) * -5840758589994634535L;
        return (word >>> 43) ^ word;
    }

    @Override
    protected byte[] getStateInternal()
    {
        // The increment is divided by 2 before saving.
        // This transform is used in the reference PCG code; it prevents restoring from
        // a byte state a non-odd increment that results in a sub-maximal period generator.
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{state, increment >>> 1}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * 8);
        final long[] tempseed = NumberFactory.makeLongArray(c[0]);
        state = tempseed[0];
        // Reverse the transform performed during getState to make the increment odd again.
        increment = tempseed[1] << 1 | 1;
        super.setStateInternal(c[1]);
    }
}
