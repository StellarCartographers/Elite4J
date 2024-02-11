/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng.source32;

import java.io.*;
import java.util.Random;

import elite.dangerous.util.testing.rng.NumberFactory;

public class JDKRandom extends IntProvider
{
    private Random delegate;

    private static final class ValidatingObjectInputStream extends ObjectInputStream
    {
        ValidatingObjectInputStream(final InputStream in) throws IOException
        {
            super(in);
        }

        @Override
        protected Class<?> resolveClass(final ObjectStreamClass osc) throws IOException, ClassNotFoundException
        {
            // For legacy reasons the Random class is serialized using only primitives
            // even though modern implementations use AtomicLong.
            // The only expected class is java.util.Random.
            if (!Random.class.getName().equals(osc.getName()))
            {
                throw new IllegalStateException("Stream does not contain java.util.Random: " + osc.getName());
            }
            return super.resolveClass(osc);
        }
    }

    public JDKRandom(Long seed)
    {
        delegate = new Random(seed);
    }

    @Override
    public int next()
    {
        return delegate.nextInt();
    }

    @Override
    protected byte[] getStateInternal()
    {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bos))
        {
            // Serialize the "delegate".
            oos.writeObject(delegate);
            final byte[] state = bos.toByteArray();
            final int stateSize = state.length; // To allow state recovery.
            // Compose the size with the state
            final byte[] sizeAndState = composeStateInternal(NumberFactory.makeByteArray(stateSize), state);
            return composeStateInternal(sizeAndState, super.getStateInternal());
        } catch (IOException e)
        {
            // Workaround checked exception.
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void setStateInternal(byte[] s)
    {
        // First obtain the state size
        final byte[][] s2 = splitStateInternal(s, 4);
        final int stateSize = NumberFactory.makeInt(s2[0]);
        // Second obtain the state
        final byte[][] c = splitStateInternal(s2[1], stateSize);
        // Use look-ahead deserialization to validate the state byte[] contains java.util.Random.
        try (ByteArrayInputStream bis = new ByteArrayInputStream(c[0]); ObjectInputStream ois = new ValidatingObjectInputStream(bis))
        {
            delegate = (Random) ois.readObject();
        } catch (ClassNotFoundException | IOException e)
        {
            // Workaround checked exception.
            throw new IllegalStateException(e);
        }
        super.setStateInternal(c[1]);
    }
}
