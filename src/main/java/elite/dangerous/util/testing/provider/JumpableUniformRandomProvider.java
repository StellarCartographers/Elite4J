/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.util.testing.provider;

import java.util.stream.Stream;

public interface JumpableUniformRandomProvider extends UniformRandomProvider
{
    UniformRandomProvider jump();

    default Stream<UniformRandomProvider> jumps()
    {
        return Stream.generate(this::jump).sequential();
    }

    default Stream<UniformRandomProvider> jumps(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return jumps().limit(streamSize);
    }
}
