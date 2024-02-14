/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.travel;

import lombok.*;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.model.*;

@EliteObject 
public class Docked extends Event
{

    private String               stationName;

    private String               stationType;

    private String               starSystem;

    public Faction               stationFaction;

    private String               stationGovernment;

    private String               stationAllegiance;

    private String               stationEconomy;

    private List<StationEconomy> stationEconomies;

    private long                 systemAddress;

    private long                 marketID;

    private double               distFromStarLS;

    private boolean              cockpitBreach;

    private List<String>         stationServices;

    private boolean              activeFine;

    private boolean              wanted;

    private boolean              taxi;

    private boolean              multicrew;

}
