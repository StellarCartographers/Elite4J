/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Powerplay.
 */
@SuperBuilder
@Jacksonized
public class Powerplay extends Event 
{

    /**
     * The power.
     */
    public String  power;
    /**
     * The rank.
     */
    public Integer rank;
    /**
     * The merits.
     */
    public Integer merits;
    /**
     * The votes.
     */
    public Integer votes;
    /**
     * The time pledged.
     */
    public Integer timePledged;
}
