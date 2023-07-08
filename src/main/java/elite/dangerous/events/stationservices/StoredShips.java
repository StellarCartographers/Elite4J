/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.StoredShipHere;
import elite.dangerous.models.StoredShipRemote;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class StoredShips.
 */
@SuperBuilder
@Jacksonized
public class StoredShips extends Event 
{

    /**
     * The star system.
     */
    public String                 stationName, starSystem;
    /**
     * The market ID.
     */
    public Long                   marketID;
    /**
     * The ships here.
     */
    public List<StoredShipHere>   shipsHere;
    /**
     * The ships remote.
     */
    public List<StoredShipRemote> shipsRemote;
}
