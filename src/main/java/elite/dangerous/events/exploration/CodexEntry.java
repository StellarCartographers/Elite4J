/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CodexEntry.
 */
@SuperBuilder
@Jacksonized
public class CodexEntry extends Event 
{

    /**
     * The name.
     */
    public String   name;
    /**
     * The name localised.
     */
    public String   nameLocalised;
    /**
     * The sub category.
     */
    public String   subCategory;
    /**
     * The sub category localised.
     */
    public String   subCategoryLocalised;
    /**
     * The category.
     */
    public String   category;
    /**
     * The category localised.
     */
    public String   categoryLocalised;
    /**
     * The region.
     */
    public String   region;
    /**
     * The system.
     */
    public String   system;
    /**
     * The entry ID.
     */
    public Integer  entryID;
    /**
     * The system address.
     */
    public Long     systemAddress;
    /**
     * The is new entry.
     */
    public Boolean  isNewEntry;
    /**
     * The new traits discovered.
     */
    public Boolean  newTraitsDiscovered;
    /**
     * The traits.
     */
    public String[] traits;
    /**
     * The nearest destination.
     */
    public String   nearestDestination;
    /**
     * The nearest destination localised.
     */
    public String   nearestDestinationLocalised;
}
