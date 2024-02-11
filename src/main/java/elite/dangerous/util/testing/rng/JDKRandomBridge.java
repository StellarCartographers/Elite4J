/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

import java.io.*;
import java.util.Random;

import elite.dangerous.util.testing.provider.RestorableUniformRandomProvider;

public final class JDKRandomBridge extends Random
{
    private static final long                         serialVersionUID = 20161107L;
    private final RandomSource                        source;
    private transient RestorableUniformRandomProvider delegate;
    private final transient boolean                   isInitialized;

    public JDKRandomBridge(RandomSource source, Object seed)
    {
        this.source = source;
        delegate = source.create(seed);
        isInitialized = true;
    }

    @Override
    public synchronized void setSeed(long seed)
    {
        if (isInitialized)
        {
            delegate = source.create(seed);
            // Force the clearing of the "haveNextNextGaussian" flag
            // (cf. Javadoc of the base class); the value passed here
            // is irrelevant (since it will not be used).
            super.setSeed(0L);
        }
    }

    @Override
    protected int next(int n)
    {
        synchronized (this)
        {
            return delegate.nextInt() >>> (32 - n);
        }
    }

    private void writeObject(ObjectOutputStream output) throws IOException
    {
        synchronized (this)
        {
            // Write non-transient fields.
            output.defaultWriteObject();
            // Save current state and size.
            // Avoid the use of ObjectOutputStream.writeObject(Object) to save the state.
            // This allows deserialization to avoid security issues in using readObject().
            final byte[] state = ((RandomProviderDefaultState) delegate.saveState()).getState();
            final int size = state.length;
            output.writeInt(size);
            output.write(state);
        }
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException
    {
        // Read non-transient fields.
        input.defaultReadObject();
        // Recreate the "delegate" from serialized info.
        delegate = source.create();
        // And restore its state.
        // Avoid the use of input.readObject() to deserialize by manually reading the byte[].
        // Note: ObjectInputStream.readObject() will execute the readObject() method of the named
        // class in the stream which may contain potentially malicious code.
        final int size = input.readInt();
        final byte[] state = new byte[size];
        input.readFully(state);
        delegate.restoreState(new RandomProviderDefaultState(state));
    }
}
