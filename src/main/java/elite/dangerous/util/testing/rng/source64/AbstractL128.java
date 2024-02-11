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

abstract class AbstractL128 extends LongProvider implements LongJumpableUniformRandomProvider
{
    private static final int  SEED_SIZE = 4;
    private static final long ML        = LXMSupport.M128L;
    protected long            lah;
    protected long            lal;
    protected long            lsh;
    protected long            lsl;

    AbstractL128(long[] seed)
    {
        setState(extendSeed(seed, SEED_SIZE));
    }

    AbstractL128(long seed0, long seed1, long seed2, long seed3)
    {
        lah = seed0;
        // Additive parameter must be odd
        lal = seed1 | 1;
        lsh = seed2;
        lsl = seed3;
    }

    AbstractL128(AbstractL128 source)
    {
        super(source);
        lah = source.lah;
        lal = source.lal;
        lsh = source.lsh;
        lsl = source.lsl;
    }

    private void setState(long[] state)
    {
        lah = state[0];
        // Additive parameter must be odd
        lal = state[1] | 1;
        lsh = state[2];
        lsl = state[3];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{lah, lal, lsh, lsl}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, SEED_SIZE * Long.BYTES);
        setState(NumberFactory.makeLongArray(c[0]));
        super.setStateInternal(c[1]);
    }

    @Override
    public UniformRandomProvider jump()
    {
        final UniformRandomProvider copy = copy();
        // Advance the LCG 1 step.
        // The LCG is, in effect, "s = m * s + a" where m = ((1LL << 64) + ML)
        final long sh = lsh;
        final long sl = lsl;
        final long u = ML * sl;
        // High half
        lsh = ML * sh + LXMSupport.unsignedMultiplyHigh(ML, sl) + sl + lah +
        // Carry propagation
                        LXMSupport.unsignedAddHigh(u, lal);
        // Low half
        lsl = u + lal;
        resetCachedState();
        return copy;
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        final JumpableUniformRandomProvider copy = copy();
        // Advance the LCG 2^64 steps
        // s = m' * s + c' * c
        // Specialised routine given M128PL=1, C128PL=0 and many terms
        // can be dropped as the low half is unchanged and there is no carry
        // sh = m'l * sh // sh
        // + high(m'l * sl) // dropped as m'l=1 and there is no high part
        // + m'h * sl
        // + c'l * ah // dropped as c'l=0
        // + high(c'l * ah) // dropped as c'l=0
        // + c'h * al
        // sl = m'l * sl + c'l * al
        // = sl
        lsh = lsh + LXMSupport.M128PH * lsl + LXMSupport.C128PH * lal;
        resetCachedState();
        return copy;
    }

    abstract AbstractL128 copy();
}
