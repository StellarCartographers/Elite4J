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

abstract class AbstractL64X128 extends AbstractL64
{
    protected static final long M              = LXMSupport.M64;
    private static final int    SEED_SIZE      = 4;
    private static final int    XBG_STATE_SIZE = 2;
    protected long              x0;
    protected long              x1;

    AbstractL64X128(long[] seed)
    {
        super(seed = extendSeed(seed, SEED_SIZE));
        x0 = seed[2];
        x1 = seed[3];
    }

    AbstractL64X128(long seed0, long seed1, long seed2, long seed3)
    {
        super(seed0, seed1);
        x0 = seed2;
        x1 = seed3;
    }

    AbstractL64X128(AbstractL64X128 source)
    {
        super(source);
        x0 = source.x0;
        x1 = source.x1;
    }

    @Override
    protected byte[] getStateInternal()
    {
        return composeStateInternal(NumberFactory.makeByteArray(new long[]{x0, x1}), super.getStateInternal());
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        final byte[][] c = splitStateInternal(s, XBG_STATE_SIZE * Long.BYTES);
        final long[] tmp = NumberFactory.makeLongArray(c[0]);
        x0 = tmp[0];
        x1 = tmp[1];
        super.setStateInternal(c[1]);
    }

    @Override
    public UniformRandomProvider jump()
    {
        return super.jump();
    }

    @Override
    public JumpableUniformRandomProvider longJump()
    {
        return super.longJump();
    }
}
