/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.onfoot;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Embark.
 */
@SuperBuilder
@Jacksonized
public class Embark extends Event 
{

    /**
     * The srv.
     */
    @SerializedName("SRV")
    public Boolean srv;
    /**
     * The taxi.
     */
    public Boolean taxi;
    /**
     * The multicrew.
     */
    public Boolean multicrew;
    /**
     * The id.
     */
    @SerializedName("ID")
    public Long    id;
    /**
     * The star system.
     */
    public String  starSystem;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The body.
     */
    public String  body;
    /**
     * The body ID.
     */
    public Long    bodyID;
    /**
     * The on station.
     */
    public Boolean onStation;
    /**
     * The on planet.
     */
    public Boolean onPlanet;
    /**
     * The station name.
     */
    public String  stationName;
    /**
     * The station type.
     */
    public String  stationType;
    /**
     * The market ID.
     */
    public Long    marketID;
}
