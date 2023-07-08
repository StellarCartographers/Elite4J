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
 * The Class NpcCrewRank.
 */
@SuperBuilder
@Jacksonized
public class NpcCrewRank extends Event 
{

    /**
     * The npc crew id.
     */
    public Long    npcCrewId;
    /**
     * The npc crew name.
     */
    public String  npcCrewName;
    /**
     * The rank combat.
     */
    public Integer rankCombat;
}
