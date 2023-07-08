/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models;
/**
 * The Class StoredModule.
 */
public class StoredModule
{
    /**
     * The star system.
     */
    public String  name, nameLocalised, starSystem;
    /**
     * The storage slot.
     */
    public Integer storageSlot;
    /**
     * The buy price.
     */
    public Long    marketID, transferCost, transferTime, buyPrice;
    /**
     * The hot.
     */
    public Boolean hot;
}
