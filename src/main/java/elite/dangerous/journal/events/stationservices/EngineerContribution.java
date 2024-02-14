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
public class EngineerContribution extends Event
{

    private String engineer;

    private String type;

    private String commodity;

    private String faction;

    private String material;

    private int    engineerID;

    private int    quantity;

    private int    totalQuantity;

}
