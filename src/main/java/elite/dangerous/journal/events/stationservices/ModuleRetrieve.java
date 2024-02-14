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

import elite.dangerous.journal.Event;

@EliteObject 
public class ModuleRetrieve extends Event
{

    private long    marketID;

    private String  slot;

    private String  retrievedItem;

    private String  ship;

    private String  swapOutItem;

    private int     shipID;

    private boolean hot;

}
