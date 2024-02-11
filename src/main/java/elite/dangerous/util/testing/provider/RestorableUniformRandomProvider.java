/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.provider;

import elite.dangerous.util.testing.rng.RandomProviderState;

public interface RestorableUniformRandomProvider extends UniformRandomProvider
{
    RandomProviderState saveState();

    void restoreState(RandomProviderState state);
}
