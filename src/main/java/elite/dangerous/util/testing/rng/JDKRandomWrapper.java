/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

import java.util.Random;

import elite.dangerous.util.testing.provider.UniformRandomProvider;

public final class JDKRandomWrapper implements UniformRandomProvider
{
    private final Random rng;

    public JDKRandomWrapper(Random rng)
    {
        this.rng = rng;
    }

    @Override
    public void nextBytes(byte[] bytes)
    {
        rng.nextBytes(bytes);
    }

    @Override
    public void nextBytes(byte[] bytes, int start, int len)
    {
        final byte[] reduced = new byte[len];
        rng.nextBytes(reduced);
        System.arraycopy(reduced, 0, bytes, start, len);
    }

    @Override
    public int nextInt()
    {
        return rng.nextInt();
    }

    @Override
    public int nextInt(int n)
    {
        return rng.nextInt(n);
    }

    @Override
    public long nextLong()
    {
        return rng.nextLong();
    }

    @Override
    public long nextLong(long n)
    {
        // Code copied from "o.a.c.rng.core.BaseProvider".
        if (n <= 0)
        {
            throw new IllegalArgumentException("Must be strictly positive: " + n);
        }
        long bits;
        long val;
        do
        {
            bits = nextLong() >>> 1;
            val = bits % n;
        } while (bits - val + (n - 1) < 0);
        return val;
    }

    @Override
    public boolean nextBoolean()
    {
        return rng.nextBoolean();
    }

    @Override
    public float nextFloat()
    {
        return rng.nextFloat();
    }

    @Override
    public double nextDouble()
    {
        return rng.nextDouble();
    }
}
