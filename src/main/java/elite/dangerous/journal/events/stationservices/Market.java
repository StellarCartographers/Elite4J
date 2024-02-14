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

import elite.dangerous.journal.Event;
import elite.dangerous.model.market.MarketItem;

@EliteObject 
public class Market extends Event
{

    private String           stationName;

    private String           starSystem;

    private String           stationType;

    private String           carrierDockingAccess;

    private int              marketID;

    private List<MarketItem> items;
}
