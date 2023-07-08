/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.combat;

import elite.dangerous.base.Bounty;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class BountySkimmer.
 */
@SuperBuilder
@Jacksonized
public class BountySkimmer extends Bounty 
{

    /**
     * The faction.
     */
    public String faction;
    /**
     * The reward.
     */
    public Long   reward;
}
