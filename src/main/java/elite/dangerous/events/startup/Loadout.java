/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.FuelCapacity;
import elite.dangerous.models.Module;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Loadout.
 */
@SuperBuilder
@Jacksonized
public class Loadout extends Event 
{

    /**
     * The ship.
     */
    public String       ship;
    /**
     * The ship ID.
     */
    public Integer      shipID;
    /**
     * The ship name.
     */
    public String       shipName;
    /**
     * The ship ident.
     */
    public String       shipIdent;
    /**
     * The hull value.
     */
    public Integer      hullValue;
    /**
     * The modules value.
     */
    public Integer      modulesValue;
    /**
     * The rebuy.
     */
    public Integer      rebuy;
    /**
     * The fuel capacity.
     */
    public FuelCapacity fuelCapacity;
    /**
     * The cargo capacity.
     */
    public Integer      cargoCapacity;
    /**
     * The hull health.
     */
    public Double       hullHealth;
    /**
     * The max jump range.
     */
    public Double       maxJumpRange;
    /**
     * The unladen mass.
     */
    public Double       unladenMass;
    /**
     * The hot.
     */
    public String       hot;
    /**
     * The modules.
     */
    public List<Module> modules;
}
