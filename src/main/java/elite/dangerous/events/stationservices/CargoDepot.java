/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CargoDepot.
 */
@SuperBuilder
@Jacksonized
public class CargoDepot extends Event 
{

    /**
     * The mission ID.
     */
    public Long    missionID;
    /**
     * The start market ID.
     */
    public Long    startMarketID;
    /**
     * The end market ID.
     */
    public Long    endMarketID;
    /**
     * The count.
     */
    public Integer count;
    /**
     * The item collected.
     */
    public Integer itemCollected;
    /**
     * The items delivered.
     */
    public Integer itemsDelivered;
    /**
     * The total items to deliver.
     */
    public Integer totalItemsToDeliver;
    /**
     * The update type.
     */
    public String  updateType;
    /**
     * The cargo type.
     */
    public String  cargoType;
    /**
     * The progress.
     */
    public Double  progress;
}
