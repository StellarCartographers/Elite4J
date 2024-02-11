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

public interface LongJumpableUniformRandomProvider extends JumpableUniformRandomProvider
{
    JumpableUniformRandomProvider longJump();

    default Stream<JumpableUniformRandomProvider> longJumps()
    {
        return Stream.generate(this::longJump).sequential();
    }

    default Stream<JumpableUniformRandomProvider> longJumps(long streamSize)
    {
        UniformRandomProviderSupport.validateStreamSize(streamSize);
        return longJumps().limit(streamSize);
    }
}
