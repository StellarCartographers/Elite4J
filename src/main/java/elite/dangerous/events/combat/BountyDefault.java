/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.combat;

import java.util.List;

import elite.dangerous.base.Bounty;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class BountyDefault.
 */
@SuperBuilder
@Jacksonized
public class BountyDefault extends Bounty 
{

    /**
     * The total reward.
     */
    public Long         totalReward;
    /**
     * The rewards.
     */
    public List<Reward> rewards;
    /**
     * The shared with others.
     */
    public Integer      sharedWithOthers;

    /**
     * The Class Reward.
     */
    public static class Reward
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
}
