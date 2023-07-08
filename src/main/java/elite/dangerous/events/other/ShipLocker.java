/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import java.util.ArrayList;

import elite.dangerous.base.Event;
import elite.dangerous.models.material.Item;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ShipLocker.
 */
@SuperBuilder
@Jacksonized
public class ShipLocker extends Event 
{

    /**
     * The items.
     */
    public ArrayList<LockerItem> items;
    /**
     * The components.
     */
    public ArrayList<LockerItem> components;
    /**
     * The consumables.
     */
    public ArrayList<LockerItem> consumables;
    /**
     * The data.
     */
    public ArrayList<LockerItem> data;

    /**
     * The Class LockerItem.
     */
    public static class LockerItem extends Item
    {

        /**
         * The owner ID.
         */
        public Long ownerID;
        /**
         * The mission ID.
         */
        public Long missionID;
    }
}
