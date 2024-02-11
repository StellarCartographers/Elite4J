/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.FuelCapacity;
import elite.dangerous.model.Module;

@EliteObject 
public class Loadout extends Event
{

    private String       ship;

    private int          shipID;

    private String       shipName;

    private String       shipIdent;

    private int          hullValue;

    private int          modulesValue;

    private int          rebuy;

    public FuelCapacity  fuelCapacity;

    private int          cargoCapacity;

    private double       hullHealth;

    private double       maxJumpRange;

    private double       unladenMass;

    private String       hot;

    private List<Module> modules;

}
