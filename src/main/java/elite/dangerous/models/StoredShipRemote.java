/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models;
/**
 * The Class StoredShipRemote.
 */
public class StoredShipRemote extends StoredShipHere
{
    /**
     * The star system.
     */
    public String starSystem;
    /**
     * The transfer price.
     */
    public Long   shipMarketID, transferTime, transferPrice;
}
