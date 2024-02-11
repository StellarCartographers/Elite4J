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

import elite.dangerous.core.Event;

@EliteObject 
public class CargoDepot extends Event
{
    private long   missionID;

    private long   startMarketID;

    private long   endMarketID;

    private int    count;

    private int    itemCollected;

    private int    itemsDelivered;

    private int    totalItemsToDeliver;

    private String updateType;

    private String cargoType;

    private double progress;

}
