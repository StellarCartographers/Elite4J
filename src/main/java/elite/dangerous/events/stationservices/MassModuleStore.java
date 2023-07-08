/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.ModuleItem;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MassModuleStore.
 */
@SuperBuilder
@Jacksonized
public class MassModuleStore extends Event 
{

    /**
     * The market ID.
     */
    public Long             marketID;
    /**
     * The ship.
     */
    public String           ship;
    /**
     * The ship ID.
     */
    public Integer          shipID;
    /**
     * The items.
     */
    public List<ModuleItem> items;
}
