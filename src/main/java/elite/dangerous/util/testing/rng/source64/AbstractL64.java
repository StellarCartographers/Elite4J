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

abstract class AbstractL64 extends LongProvider implements LongJumpableUniformRandomProvider
{
    private static final int SEED_SIZE = 2;
    protected long           la;
    protected long           ls;

    AbstractL64(long[] seed)
    {
        setState(extendSeed(seed, SEED_SIZE));
    }

    AbstractL64(long seed0, long seed1)
    {
        // Additive parameter must be odd
        la = seed0 | 1;
        ls = seed1;
    }

    AbstractL64(AbstractL64 source)
    {
        super(source);
        la = source.la;
        ls = source.ls;
    }

    private void setState(long[] state)
    {
        // Additive parameter must be odd
        la = state[0] | 1;
        ls = state[1];
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{la, ls}), super.getStateInternal());
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
        // Advance the LCG 1 step
        ls = LXMSupport.M64 * ls + la;
        resetCachedState();
        return copy;
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        final JumpableUniformRandomProvider copy = copy();
        // Advance the LCG 2^32 steps
        ls = LXMSupport.M64P * ls + LXMSupport.C64P * la;
        resetCachedState();
        return copy;
    }

    abstract AbstractL64 copy();
}
