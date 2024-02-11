/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.internal;

import java.lang.reflect.*;

import elite.dangerous.util.testing.provider.*;
import elite.dangerous.util.testing.rng.source32.*;
import elite.dangerous.util.testing.rng.source64.*;

public final class ProviderBuilder
{
    private static final String INTERNAL_ERROR_MSG = "Internal error: Please file a bug report";

    private ProviderBuilder()
    {
    }

    public static RestorableUniformRandomProvider create(RandomSourceInternal source)
    {
        // Delegate to the random source allowing generator specific implementations.
        return source.create();
    }

    public static RestorableUniformRandomProvider create(RandomSourceInternal source, Object seed, Object[] args)
    {
        // Delegate to the random source allowing generator specific implementations.
        // This method checks arguments for null and calls the appropriate internal method.
        if (args != null)
        {
            return source.create(seed, args);
        }
        return seed == null ? source.create() : source.create(seed);
    }

    public enum RandomSourceInternal
    {
        JDK(JDKRandom.class, 1, NativeSeedType.LONG),
        WELL_512_A(Well512a.class, 16, 0, 16, NativeSeedType.INT_ARRAY),
        WELL_1024_A(Well1024a.class, 32, 0, 32, NativeSeedType.INT_ARRAY),
        WELL_19937_A(Well19937a.class, 624, 0, 623, NativeSeedType.INT_ARRAY),
        WELL_19937_C(Well19937c.class, 624, 0, 623, NativeSeedType.INT_ARRAY),
        WELL_44497_A(Well44497a.class, 1391, 0, 1390, NativeSeedType.INT_ARRAY),
        WELL_44497_B(Well44497b.class, 1391, 0, 1390, NativeSeedType.INT_ARRAY),
        MT(MersenneTwister.class, 624, NativeSeedType.INT_ARRAY),
        ISAAC(ISAACRandom.class, 256, NativeSeedType.INT_ARRAY),
        SPLIT_MIX_64(SplitMix64.class, 1, NativeSeedType.LONG),
        XOR_SHIFT_1024_S(XorShift1024Star.class, 16, 0, 16, NativeSeedType.LONG_ARRAY),
        TWO_CMRES(TwoCmres.class, 1, NativeSeedType.INT),
        TWO_CMRES_SELECT(TwoCmres.class, 1, NativeSeedType.INT, Integer.TYPE, Integer.TYPE),
        MT_64(MersenneTwister64.class, 312, NativeSeedType.LONG_ARRAY),
        MWC_256(MultiplyWithCarry256.class, 257, 0, 257, NativeSeedType.INT_ARRAY),
        KISS(KISSRandom.class,
                        // If zero in initial 3 positions the output is a simple LCG
                        4, 0, 3, NativeSeedType.INT_ARRAY),
        XOR_SHIFT_1024_S_PHI(XorShift1024StarPhi.class, 16, 0, 16, NativeSeedType.LONG_ARRAY),
        XO_RO_SHI_RO_64_S(XoRoShiRo64Star.class, 2, 0, 2, NativeSeedType.INT_ARRAY),
        XO_RO_SHI_RO_64_SS(XoRoShiRo64StarStar.class, 2, 0, 2, NativeSeedType.INT_ARRAY),
        XO_SHI_RO_128_PLUS(XoShiRo128Plus.class, 4, 0, 4, NativeSeedType.INT_ARRAY),
        XO_SHI_RO_128_SS(XoShiRo128StarStar.class, 4, 0, 4, NativeSeedType.INT_ARRAY),
        XO_RO_SHI_RO_128_PLUS(XoRoShiRo128Plus.class, 2, 0, 2, NativeSeedType.LONG_ARRAY),
        XO_RO_SHI_RO_128_SS(XoRoShiRo128StarStar.class, 2, 0, 2, NativeSeedType.LONG_ARRAY),
        XO_SHI_RO_256_PLUS(XoShiRo256Plus.class, 4, 0, 4, NativeSeedType.LONG_ARRAY),
        XO_SHI_RO_256_SS(XoShiRo256StarStar.class, 4, 0, 4, NativeSeedType.LONG_ARRAY),
        XO_SHI_RO_512_PLUS(XoShiRo512Plus.class, 8, 0, 8, NativeSeedType.LONG_ARRAY),
        XO_SHI_RO_512_SS(XoShiRo512StarStar.class, 8, 0, 8, NativeSeedType.LONG_ARRAY),
        PCG_XSH_RR_32(PcgXshRr32.class, 2, NativeSeedType.LONG_ARRAY),
        PCG_XSH_RS_32(PcgXshRs32.class, 2, NativeSeedType.LONG_ARRAY),
        PCG_RXS_M_XS_64(PcgRxsMXs64.class, 2, NativeSeedType.LONG_ARRAY),
        PCG_MCG_XSH_RR_32(PcgMcgXshRr32.class, 1, NativeSeedType.LONG),
        PCG_MCG_XSH_RS_32(PcgMcgXshRs32.class, 1, NativeSeedType.LONG),
        MSWS(MiddleSquareWeylSequence.class,
                        // Many partially zero seeds can create low quality initial output.
                        // The Weyl increment cascades bits into the random state so ideally it
                        // has a high number of bit transitions. Minimally ensure it is non-zero.
                        3, 2, 3, NativeSeedType.LONG_ARRAY) {
            @Override
            protected Object createSeed()
            {
                return createMswsSeed(SeedFactory.createLong());
            }

            @Override
            protected Object convertSeed(Object seed)
            {
                // Allow seeding with primitives to generate a good seed
                if (seed instanceof Integer)
                {
                    return createMswsSeed((Integer) seed);
                } else if (seed instanceof Long)
                {
                    return createMswsSeed((Long) seed);
                }
                // Other types (e.g. the native long[]) are handled by the default conversion
                return super.convertSeed(seed);
            }

            @Override
            protected byte[] createByteArraySeed(UniformRandomProvider source)
            {
                // The seed requires approximately 4-6 calls to nextInt().
                // Wrap the input and switch to a default if the input is faulty.
                final UniformRandomProvider wrapped = new IntProvider()
                {
                    private int                   calls = 100;
                    private UniformRandomProvider defaultGen;

                    @Override
                    public int next()
                    {
                        if (calls == 0)
                        {
                            // The input source is broken.
                            // Seed a default
                            if (defaultGen == null)
                            {
                                defaultGen = new SplitMix64(source.nextLong());
                            }
                            return defaultGen.nextInt();
                        }
                        calls--;
                        return source.nextInt();
                    }

                    @Override
                    public long nextLong()
                    {
                        // No specific requirements so always use the source
                        return source.nextLong();
                    }
                };
                return NativeSeedType.convertSeedToBytes(createMswsSeed(wrapped));
            }

            private long[] createMswsSeed(long seed)
            {
                return createMswsSeed(new SplitMix64(seed));
            }

            private long[] createMswsSeed(UniformRandomProvider source)
            {
                final long increment = SeedUtils.createLongHexPermutation(source);
                // The initial state should not be low complexity but the Weyl
                // state can be any number.
                final long state = increment;
                final long weylState = source.nextLong();
                return new long[]{state, weylState, increment};
            }
        },
        SFC_32(DotyHumphreySmallFastCounting32.class, 3, NativeSeedType.INT_ARRAY),
        SFC_64(DotyHumphreySmallFastCounting64.class, 3, NativeSeedType.LONG_ARRAY),
        JSF_32(JenkinsSmallFast32.class, 1, NativeSeedType.INT),
        JSF_64(JenkinsSmallFast64.class, 1, NativeSeedType.LONG),
        XO_SHI_RO_128_PP(XoShiRo128PlusPlus.class, 4, 0, 4, NativeSeedType.INT_ARRAY),
        XO_RO_SHI_RO_128_PP(XoRoShiRo128PlusPlus.class, 2, 0, 2, NativeSeedType.LONG_ARRAY),
        XO_SHI_RO_256_PP(XoShiRo256PlusPlus.class, 4, 0, 4, NativeSeedType.LONG_ARRAY),
        XO_SHI_RO_512_PP(XoShiRo512PlusPlus.class, 8, 0, 8, NativeSeedType.LONG_ARRAY),
        XO_RO_SHI_RO_1024_PP(XoRoShiRo1024PlusPlus.class, 16, 0, 16, NativeSeedType.LONG_ARRAY),
        XO_RO_SHI_RO_1024_S(XoRoShiRo1024Star.class, 16, 0, 16, NativeSeedType.LONG_ARRAY),
        XO_RO_SHI_RO_1024_SS(XoRoShiRo1024StarStar.class, 16, 0, 16, NativeSeedType.LONG_ARRAY),
        PCG_XSH_RR_32_OS(PcgXshRr32.class, 1, NativeSeedType.LONG),
        PCG_XSH_RS_32_OS(PcgXshRs32.class, 1, NativeSeedType.LONG),
        PCG_RXS_M_XS_64_OS(PcgRxsMXs64.class, 1, NativeSeedType.LONG),
        L64_X128_SS(L64X128StarStar.class, 4, 2, 4, NativeSeedType.LONG_ARRAY),
        L64_X128_MIX(L64X128Mix.class, 4, 2, 4, NativeSeedType.LONG_ARRAY),
        L64_X256_MIX(L64X256Mix.class, 6, 2, 6, NativeSeedType.LONG_ARRAY),
        L64_X1024_MIX(L64X1024Mix.class, 18, 2, 18, NativeSeedType.LONG_ARRAY),
        L128_X128_MIX(L128X128Mix.class, 6, 4, 6, NativeSeedType.LONG_ARRAY),
        L128_X256_MIX(L128X256Mix.class, 8, 4, 8, NativeSeedType.LONG_ARRAY),
        L128_X1024_MIX(L128X1024Mix.class, 20, 4, 20, NativeSeedType.LONG_ARRAY),
        L32_X64_MIX(L32X64Mix.class, 4, 2, 4, NativeSeedType.INT_ARRAY);

        private final Class<? extends UniformRandomProvider> rng;
        private final int                                    nativeSeedSize;
        private final int                                    notAllZeroFrom;
        private final int                                    notAllZeroTo;
        private final Class<?>[]                             args;
        private final NativeSeedType                         nativeSeedType;
        private transient Constructor<?>                     rngConstructor;

        RandomSourceInternal(Class<? extends UniformRandomProvider> rng, int nativeSeedSize, NativeSeedType nativeSeedType, Class<?>... args)
        {
            this(rng, nativeSeedSize, 0, 0, nativeSeedType, args);
        }

        RandomSourceInternal(Class<? extends UniformRandomProvider> rng, int nativeSeedSize, int notAllZeroFrom, int notAllZeroTo, NativeSeedType nativeSeedType, Class<?>... args)
        {
            this.rng = rng;
            this.nativeSeedSize = nativeSeedSize;
            this.notAllZeroFrom = notAllZeroFrom;
            this.notAllZeroTo = notAllZeroTo;
            this.nativeSeedType = nativeSeedType;
            // Build the complete list of class types for the constructor
            this.args = (Class<?>[]) Array.newInstance(args.getClass().getComponentType(), 1 + args.length);
            this.args[0] = nativeSeedType.getType();
            System.arraycopy(args, 0, this.args, 1, args.length);
        }

        public Class<?> getRng()
        {
            return rng;
        }

        Class<?> getSeed()
        {
            return args[0];
        }

        Class<?>[] getArgs()
        {
            return args;
        }

        public <SEED> boolean isNativeSeed(SEED seed)
        {
            return seed != null && getSeed().equals(seed.getClass());
        }

        RestorableUniformRandomProvider create()
        {
            // Create a seed.
            final Object nativeSeed = createSeed();
            // Instantiate.
            return create(getConstructor(), new Object[]{nativeSeed});
        }

        RestorableUniformRandomProvider create(Object seed)
        {
            // Convert seed to native type.
            final Object nativeSeed = convertSeed(seed);
            // Instantiate.
            return create(getConstructor(), new Object[]{nativeSeed});
        }

        RestorableUniformRandomProvider create(Object seed, Object[] constructorArgs)
        {
            final Object nativeSeed = createNativeSeed(seed);
            // Build a single array with all the arguments to be passed
            // (in the right order) to the constructor.
            Object[] all = new Object[constructorArgs.length + 1];
            all[0] = nativeSeed;
            System.arraycopy(constructorArgs, 0, all, 1, constructorArgs.length);
            // Instantiate.
            return create(getConstructor(), all);
        }

        protected Object createSeed()
        {
            // Ensure the seed is not all-zero in the sub-range
            return nativeSeedType.createSeed(nativeSeedSize, notAllZeroFrom, notAllZeroTo);
        }

        protected byte[] createByteArraySeed(UniformRandomProvider source)
        {
            // Ensure the seed is not all-zero in the sub-range.
            // Note: Convert the native seed array size/positions to byte size/positions.
            final int bytes = nativeSeedType.getBytes();
            return SeedFactory.createByteArray(source, bytes * nativeSeedSize, bytes * notAllZeroFrom, bytes * notAllZeroTo);
        }

        protected Object convertSeed(Object seed)
        {
            return nativeSeedType.convertSeed(seed, nativeSeedSize);
        }

        private Object createNativeSeed(Object seed)
        {
            return seed == null ? createSeed() : convertSeed(seed);
        }

        public final byte[] createSeedBytes()
        {
            // Custom implementations can override createSeed
            final Object seed = createSeed();
            return NativeSeedType.convertSeedToBytes(seed);
        }

        public final byte[] createSeedBytes(UniformRandomProvider source)
        {
            // Custom implementations can override createByteArraySeed
            return createByteArraySeed(source);
        }

        private Constructor<?> getConstructor()
        {
            // The constructor never changes so it is stored for re-use.
            Constructor<?> constructor = rngConstructor;
            if (constructor == null)
            {
                // If null this is either the first attempt to find it or
                // look-up previously failed and this method will throw
                // upon each invocation.
                constructor = createConstructor();
                rngConstructor = constructor;
            }
            return constructor;
        }

        private Constructor<?> createConstructor()
        {
            try
            {
                return getRng().getConstructor(getArgs());
            } catch (NoSuchMethodException e)
            {
                // Info in "RandomSourceInternal" is inconsistent with the
                // constructor of the implementation.
                throw new IllegalStateException(INTERNAL_ERROR_MSG, e);
            }
        }

        private static RestorableUniformRandomProvider create(Constructor<?> rng, Object[] args)
        {
            try
            {
                return (RestorableUniformRandomProvider) rng.newInstance(args);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e)
            {
                throw new IllegalStateException(INTERNAL_ERROR_MSG, e);
            }
        }
    }
}
