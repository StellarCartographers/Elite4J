/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.Modification;
import elite.dangerous.models.engineer.Ingredient;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class EngineerCraft.
 */
@SuperBuilder
@Jacksonized
public class EngineerCraft extends Event 
{

    /**
     * The engineer.
     */
    public String             engineer;
    /**
     * The blueprint name.
     */
    public String             blueprintName;
    /**
     * The slot.
     */
    public String             slot;
    /**
     * The module.
     */
    public String             module;
    /**
     * The engineer ID.
     */
    public Integer            engineerID;
    /**
     * The blueprint ID.
     */
    public Integer            blueprintID;
    /**
     * The level.
     */
    public Integer            level;
    /**
     * The quality.
     */
    public Double             quality;
    /**
     * The ingredients.
     */
    public List<Ingredient>   ingredients;
    /**
     * The modifiers.
     */
    public List<Modification> modifiers;
}
