/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.stationservices;

import lombok.*;

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.Modification;
import elite.dangerous.model.engineer.Ingredient;

@EliteObject 
public class EngineerCraft extends Event
{

    private String             engineer;

    private String             blueprintName;

    private String             slot;

    private String             module;

    private int                engineerID;

    private int                blueprintID;

    private int                level;

    private double             quality;

    private List<Ingredient>   ingredients;

    private List<Modification> modifiers;

}
