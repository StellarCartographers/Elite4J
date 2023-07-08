/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CommitCrime.
 */
@SuperBuilder
@Jacksonized
public class CommitCrime extends Event 
{

    /**
     * The crime type.
     */
    public String  crimeType;
    /**
     * The faction.
     */
    public String  faction;
    /**
     * The victim.
     */
    public String  victim;
    /**
     * The bounty.
     */
    public Integer bounty;
    /**
     * The fine.
     */
    public Integer fine;
}
