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
import elite.dangerous.model.CargoItem;

@EliteObject 
public class Cargo extends Event
{

    private String          vessel;

    private int             count;

    private List<CargoItem> inventory;
}
