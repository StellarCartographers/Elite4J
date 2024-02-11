/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.*;

@EliteObject 
public class Location extends Event
{

    private String               starSystem;

    private String               systemAllegiance;

    private String               systemEconomy;

    private String               systemSecondEconomy;

    private String               systemGovernment;

    private String               systemSecurity;

    private String               body;

    private String               bodyType;

    public Faction               systemFaction;

    private String               powerplayState;

    private String               stationName;

    private String               stationType;

    private String               stationEconomy;

    public Faction               stationFaction;

    private String               stationAllegiance;

    private String               stationGovernment;

    private double[]             starPos;

    private long                 systemAddress, population, marketID;

    private int                  bodyID;

    private boolean              docked;

    private List<Faction>        factions;

    private List<Conflict>       conflicts;

    private List<String>         powers, stationServices;

    private List<StationEconomy> stationEconomies;

}
