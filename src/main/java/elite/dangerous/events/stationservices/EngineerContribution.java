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
 * The Class EngineerContribution.
 */
@SuperBuilder
@Jacksonized
public class EngineerContribution extends Event 
{

    /**
     * The engineer.
     */
    public String  engineer;
    /**
     * The type.
     */
    public String  type;
    /**
     * The commodity.
     */
    public String  commodity;
    /**
     * The faction.
     */
    public String  faction;
    /**
     * The material.
     */
    public String  material;
    /**
     * The engineer ID.
     */
    public Integer engineerID;
    /**
     * The quantity.
     */
    public Integer quantity;
    /**
     * The total quantity.
     */
    public Integer totalQuantity;
}
