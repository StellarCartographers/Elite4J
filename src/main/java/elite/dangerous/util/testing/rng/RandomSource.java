/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

import java.util.stream.*;

import elite.dangerous.util.testing.provider.*;
import elite.dangerous.util.testing.rng.internal.*;

public enum RandomSource
{
    JDK(ProviderBuilder.RandomSourceInternal.JDK),
    WELL_512_A(ProviderBuilder.RandomSourceInternal.WELL_512_A),
    WELL_1024_A(ProviderBuilder.RandomSourceInternal.WELL_1024_A),
    WELL_19937_A(ProviderBuilder.RandomSourceInternal.WELL_19937_A),
    WELL_19937_C(ProviderBuilder.RandomSourceInternal.WELL_19937_C),
    WELL_44497_A(ProviderBuilder.RandomSourceInternal.WELL_44497_A),
    WELL_44497_B(ProviderBuilder.RandomSourceInternal.WELL_44497_B),
    MT(ProviderBuilder.RandomSourceInternal.MT),
    ISAAC(ProviderBuilder.RandomSourceInternal.ISAAC),
    SPLIT_MIX_64(ProviderBuilder.RandomSourceInternal.SPLIT_MIX_64),
    @Deprecated
    XOR_SHIFT_1024_S(ProviderBuilder.RandomSourceInternal.XOR_SHIFT_1024_S),
    TWO_CMRES(ProviderBuilder.RandomSourceInternal.TWO_CMRES),
    TWO_CMRES_SELECT(ProviderBuilder.RandomSourceInternal.TWO_CMRES_SELECT),
    MT_64(ProviderBuilder.RandomSourceInternal.MT_64),
    MWC_256(ProviderBuilder.RandomSourceInternal.MWC_256),
    KISS(ProviderBuilder.RandomSourceInternal.KISS),
    XOR_SHIFT_1024_S_PHI(ProviderBuilder.RandomSourceInternal.XOR_SHIFT_1024_S_PHI),
    XO_RO_SHI_RO_64_S(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_64_S),
    XO_RO_SHI_RO_64_SS(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_64_SS),
    XO_SHI_RO_128_PLUS(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_128_PLUS),
    XO_SHI_RO_128_SS(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_128_SS),
    XO_RO_SHI_RO_128_PLUS(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_128_PLUS),
    XO_RO_SHI_RO_128_SS(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_128_SS),
    XO_SHI_RO_256_PLUS(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_256_PLUS),
    XO_SHI_RO_256_SS(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_256_SS),
    XO_SHI_RO_512_PLUS(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_512_PLUS),
    XO_SHI_RO_512_SS(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_512_SS),
    PCG_XSH_RR_32(ProviderBuilder.RandomSourceInternal.PCG_XSH_RR_32),
    PCG_XSH_RS_32(ProviderBuilder.RandomSourceInternal.PCG_XSH_RS_32),
    PCG_RXS_M_XS_64(ProviderBuilder.RandomSourceInternal.PCG_RXS_M_XS_64),
    PCG_MCG_XSH_RR_32(ProviderBuilder.RandomSourceInternal.PCG_MCG_XSH_RR_32),
    PCG_MCG_XSH_RS_32(ProviderBuilder.RandomSourceInternal.PCG_MCG_XSH_RS_32),
    MSWS(ProviderBuilder.RandomSourceInternal.MSWS),
    SFC_32(ProviderBuilder.RandomSourceInternal.SFC_32),
    SFC_64(ProviderBuilder.RandomSourceInternal.SFC_64),
    JSF_32(ProviderBuilder.RandomSourceInternal.JSF_32),
    JSF_64(ProviderBuilder.RandomSourceInternal.JSF_64),
    XO_SHI_RO_128_PP(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_128_PP),
    XO_RO_SHI_RO_128_PP(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_128_PP),
    XO_SHI_RO_256_PP(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_256_PP),
    XO_SHI_RO_512_PP(ProviderBuilder.RandomSourceInternal.XO_SHI_RO_512_PP),
    XO_RO_SHI_RO_1024_PP(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_1024_PP),
    XO_RO_SHI_RO_1024_S(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_1024_S),
    XO_RO_SHI_RO_1024_SS(ProviderBuilder.RandomSourceInternal.XO_RO_SHI_RO_1024_SS),
    PCG_XSH_RR_32_OS(ProviderBuilder.RandomSourceInternal.PCG_XSH_RR_32_OS),
    PCG_XSH_RS_32_OS(ProviderBuilder.RandomSourceInternal.PCG_XSH_RS_32_OS),
    PCG_RXS_M_XS_64_OS(ProviderBuilder.RandomSourceInternal.PCG_RXS_M_XS_64_OS),
    L64_X128_SS(ProviderBuilder.RandomSourceInternal.L64_X128_SS),
    L64_X128_MIX(ProviderBuilder.RandomSourceInternal.L64_X128_MIX),
    L64_X256_MIX(ProviderBuilder.RandomSourceInternal.L64_X256_MIX),
    L64_X1024_MIX(ProviderBuilder.RandomSourceInternal.L64_X1024_MIX),
    L128_X128_MIX(ProviderBuilder.RandomSourceInternal.L128_X128_MIX),
    L128_X256_MIX(ProviderBuilder.RandomSourceInternal.L128_X256_MIX),
    L128_X1024_MIX(ProviderBuilder.RandomSourceInternal.L128_X1024_MIX),
    L32_X64_MIX(ProviderBuilder.RandomSourceInternal.L32_X64_MIX);

    private final ProviderBuilder.RandomSourceInternal internalIdentifier;

    RandomSource(ProviderBuilder.RandomSourceInternal id)
    {
        internalIdentifier = id;
    }

    ProviderBuilder.RandomSourceInternal getInternalIdentifier()
    {
        return internalIdentifier;
    }

    public boolean isNativeSeed(Object seed)
    {
        return internalIdentifier.isNativeSeed(seed);
    }

    public byte[] createSeed()
    {
        return internalIdentifier.createSeedBytes();
    }

    public byte[] createSeed(UniformRandomProvider rng)
    {
        return internalIdentifier.createSeedBytes(rng);
    }

    public boolean isJumpable()
    {
        return isAssignableTo(JumpableUniformRandomProvider.class);
    }

    public boolean isLongJumpable()
    {
        return isAssignableTo(LongJumpableUniformRandomProvider.class);
    }

    public boolean isSplittable()
    {
        return isAssignableTo(SplittableUniformRandomProvider.class);
    }

    private boolean isAssignableTo(Class<?> type)
    {
        return type.isAssignableFrom(internalIdentifier.getRng());
    }

    public RestorableUniformRandomProvider create()
    {
        return ProviderBuilder.create(getInternalIdentifier());
    }

    public RestorableUniformRandomProvider create(Object seed, Object... data)
    {
        return ProviderBuilder.create(getInternalIdentifier(), seed, data);
    }

    @Deprecated
    public static RestorableUniformRandomProvider create(RandomSource source)
    {
        return ProviderBuilder.create(source.getInternalIdentifier());
    }

    @Deprecated
    public static RestorableUniformRandomProvider create(RandomSource source, Object seed, Object... data)
    {
        return ProviderBuilder.create(source.getInternalIdentifier(), seed, data);
    }

    public static int createInt()
    {
        return SeedFactory.createInt();
    }

    public static long createLong()
    {
        return SeedFactory.createLong();
    }

    public static int[] createIntArray(int n)
    {
        return SeedFactory.createIntArray(n);
    }

    public static long[] createLongArray(int n)
    {
        return SeedFactory.createLongArray(n);
    }

    public static UniformRandomProvider unrestorable(final UniformRandomProvider delegate)
    {
        return new UniformRandomProvider()
        {
            @Override
            public void nextBytes(byte[] bytes)
            {
                delegate.nextBytes(bytes);
            }

            @Override
            public void nextBytes(byte[] bytes, int start, int len)
            {
                delegate.nextBytes(bytes, start, len);
            }

            @Override
            public int nextInt()
            {
                return delegate.nextInt();
            }

            @Override
            public int nextInt(int n)
            {
                return delegate.nextInt(n);
            }

            @Override
            public int nextInt(int origin, int bound)
            {
                return delegate.nextInt(origin, bound);
            }

            @Override
            public long nextLong()
            {
                return delegate.nextLong();
            }

            @Override
            public long nextLong(long n)
            {
                return delegate.nextLong(n);
            }

            @Override
            public long nextLong(long origin, long bound)
            {
                return delegate.nextLong(origin, bound);
            }

            @Override
            public boolean nextBoolean()
            {
                return delegate.nextBoolean();
            }

            @Override
            public float nextFloat()
            {
                return delegate.nextFloat();
            }

            @Override
            public float nextFloat(float bound)
            {
                return delegate.nextFloat(bound);
            }

            @Override
            public float nextFloat(float origin, float bound)
            {
                return delegate.nextFloat(origin, bound);
            }

            @Override
            public double nextDouble()
            {
                return delegate.nextDouble();
            }

            @Override
            public double nextDouble(double bound)
            {
                return delegate.nextDouble(bound);
            }

            @Override
            public double nextDouble(double origin, double bound)
            {
                return delegate.nextDouble(origin, bound);
            }

            @Override
            public IntStream ints()
            {
                return delegate.ints();
            }

            @Override
            public IntStream ints(int origin, int bound)
            {
                return delegate.ints(origin, bound);
            }

            @Override
            public IntStream ints(long streamSize)
            {
                return delegate.ints(streamSize);
            }

            @Override
            public IntStream ints(long streamSize, int origin, int bound)
            {
                return delegate.ints(streamSize, origin, bound);
            }

            @Override
            public LongStream longs()
            {
                return delegate.longs();
            }

            @Override
            public LongStream longs(long origin, long bound)
            {
                return delegate.longs(origin, bound);
            }

            @Override
            public LongStream longs(long streamSize)
            {
                return delegate.longs(streamSize);
            }

            @Override
            public LongStream longs(long streamSize, long origin, long bound)
            {
                return delegate.longs(streamSize, origin, bound);
            }

            @Override
            public DoubleStream doubles()
            {
                return delegate.doubles();
            }

            @Override
            public DoubleStream doubles(double origin, double bound)
            {
                return delegate.doubles(origin, bound);
            }

            @Override
            public DoubleStream doubles(long streamSize)
            {
                return delegate.doubles(streamSize);
            }

            @Override
            public DoubleStream doubles(long streamSize, double origin, double bound)
            {
                return delegate.doubles(streamSize, origin, bound);
            }

            @Override
            public String toString()
            {
                return delegate.toString();
            }
        };
    }
}
