/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.rng;

import java.util.Arrays;

public class RandomProviderDefaultState implements RandomProviderState
{
    private final byte[] state;

    public RandomProviderDefaultState(byte[] state)
    {
        this.state = Arrays.copyOf(state, state.length);
    }

    public byte[] getState()
    {
        return Arrays.copyOf(state, state.length);
    }
}
