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
public class FetchRemoteModule extends Event
{

    private int    storageSlots;

    private int    serverId;

    private int    transferCost;

    private int    transferTime;

    private int    shipId;

    private String storedItem;

    private String ship;

}
