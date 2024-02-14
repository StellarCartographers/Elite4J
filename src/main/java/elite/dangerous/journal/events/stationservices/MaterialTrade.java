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
import elite.dangerous.model.TradeData;

@EliteObject 
public class MaterialTrade extends Event
{

    private long     marketID;

    private String   traderType;

    public TradeData paid;

    public TradeData received;

}
