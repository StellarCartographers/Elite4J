/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.travel;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.Faction;
import elite.dangerous.models.StationEconomy;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Docked.
 */
@SuperBuilder
@Jacksonized
public class Docked extends Event 
{

    /**
     * The station name.
     */
    public String               stationName;
    /**
     * The station type.
     */
    public String               stationType;
    /**
     * The star system.
     */
    public String               starSystem;
    /**
     * The station faction.
     */
    public Faction              stationFaction;
    /**
     * The station government.
     */
    public String               stationGovernment;
    /**
     * The station government localised.
     */
    public String               stationGovernmentLocalised;
    /**
     * The station allegiance.
     */
    public String               stationAllegiance;
    /**
     * The station economy.
     */
    public String               stationEconomy;
    /**
     * The station economy localised.
     */
    public String               stationEconomyLocalised;
    /**
     * The station economies.
     */
    public List<StationEconomy> stationEconomies;
    /**
     * The system address.
     */
    public Long                 systemAddress;
    /**
     * The market ID.
     */
    public Long                 marketID;
    /**
     * The dist from star LS.
     */
    public Double               distFromStarLS;
    /**
     * The cockpit breach.
     */
    public Boolean              cockpitBreach;
    /**
     * The station services.
     */
    public List<String>         stationServices;
    /**
     * The active fine.
     */
    public Boolean              activeFine;
    /**
     * The wanted.
     */
    public Boolean              wanted;
    /**
     * The taxi.
     */
    public Boolean              taxi;
    /**
     * The multicrew.
     */
    public Boolean              multicrew;
}
