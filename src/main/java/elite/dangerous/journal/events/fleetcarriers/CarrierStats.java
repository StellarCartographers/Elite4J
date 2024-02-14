/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.fleetcarriers;

import lombok.*;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.model.*;

@EliteObject 
public class CarrierStats extends Event
{

    private long           carrierID;

    private String         callsign;

    private String         name;

    private String         dockingAccess;

    private boolean        allowNotorious;

    private int            fuelLevel;

    public float           jumpRangeCurr;

    public float           jumpRangeMax;

    private boolean        pendingDecommission;

    public SpaceUsage      spaceUsage;

    public Finance         finance;

    private List<CrewItem> crew;

    private List<Pack>     shipPacks;

    private List<Pack>     modulePacks;

}
