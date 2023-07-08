/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.fleetcarriers;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.CrewItem;
import elite.dangerous.models.Finance;
import elite.dangerous.models.Pack;
import elite.dangerous.models.SpaceUsage;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CarrierStats.
 */
@SuperBuilder
@Jacksonized
public class CarrierStats extends Event 
{

    /**
     * The carrier ID.
     */
    public Long           carrierID;
    /**
     * The callsign.
     */
    public String         callsign;
    /**
     * The name.
     */
    public String         name;
    /**
     * The docking access.
     */
    public String         dockingAccess;
    /**
     * The allow notorious.
     */
    public boolean        allowNotorious;
    /**
     * The fuel level.
     */
    public Integer        fuelLevel;
    /**
     * The jump range curr.
     */
    public Float          jumpRangeCurr;
    /**
     * The jump range max.
     */
    public Float          jumpRangeMax;
    /**
     * The pending decommission.
     */
    public Boolean        pendingDecommission;
    /**
     * The space usage.
     */
    public SpaceUsage     spaceUsage;
    /**
     * The finance.
     */
    public Finance        finance;
    /**
     * The crew.
     */
    public List<CrewItem> crew;
    /**
     * The ship packs.
     */
    public List<Pack>     shipPacks;
    /**
     * The module packs.
     */
    public List<Pack>     modulePacks;
}
