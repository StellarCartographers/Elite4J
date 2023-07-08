/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.Conflict;
import elite.dangerous.models.Faction;
import elite.dangerous.models.StationEconomy;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Location.
 */
@SuperBuilder
@Jacksonized
public class Location extends Event 
{

    /**
     * The star system.
     */
    public String               starSystem;
    /**
     * The system allegiance.
     */
    public String               systemAllegiance;
    /**
     * The system economy.
     */
    public String               systemEconomy;
    /**
     * The system economy localised.
     */
    public String               systemEconomyLocalised;
    /**
     * The system second economy.
     */
    public String               systemSecondEconomy;
    /**
     * The system second economy localised.
     */
    public String               systemSecondEconomyLocalised;
    /**
     * The system government.
     */
    public String               systemGovernment;
    /**
     * The system government localised.
     */
    public String               systemGovernmentLocalised;
    /**
     * The system security.
     */
    public String               systemSecurity;
    /**
     * The system security localised.
     */
    public String               systemSecurityLocalised;
    /**
     * The body.
     */
    public String               body;
    /**
     * The body type.
     */
    public String               bodyType;
    /**
     * The system faction.
     */
    public Faction              systemFaction;
    /**
     * The powerplay state.
     */
    public String               powerplayState;
    /**
     * The station name.
     */
    public String               stationName;
    /**
     * The station type.
     */
    public String               stationType;
    /**
     * The station economy.
     */
    public String               stationEconomy;
    /**
     * The station faction.
     */
    public Faction              stationFaction;
    /**
     * The station allegiance.
     */
    public String               stationAllegiance;
    /**
     * The station government.
     */
    public String               stationGovernment;
    /**
     * The station economy localised.
     */
    public String               stationEconomyLocalised;
    /**
     * The station government localised.
     */
    public String               stationGovernmentLocalised;
    /**
     * The star pos.
     */
    public Double[]             starPos;
    /**
     * The market ID.
     */
    public Long                 systemAddress, population, marketID;
    /**
     * The body ID.
     */
    public Integer              bodyID;
    /**
     * The docked.
     */
    public Boolean              docked;
    /**
     * The factions.
     */
    public List<Faction>        factions;
    /**
     * The conflicts.
     */
    public List<Conflict>       conflicts;
    /**
     * The station services.
     */
    public List<String>         powers, stationServices;
    /**
     * The station economies.
     */
    public List<StationEconomy> stationEconomies;
}
