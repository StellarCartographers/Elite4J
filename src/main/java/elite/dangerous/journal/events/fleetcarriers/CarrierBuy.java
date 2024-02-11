/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.fleetcarriers;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class CarrierBuy extends Event
{

    private long   boughtAtMarket;

    private long   carrierID;

    private String location;

    private long   price;

    private String variant;

    private String callsign;

}
