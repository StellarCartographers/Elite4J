/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import elite.dangerous.base.Squadron;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SquadronStartup.
 */
@SuperBuilder
@Jacksonized
public class SquadronStartup extends Squadron 
{

    /**
     * The current rank.
     */
    public Integer currentRank;
}
