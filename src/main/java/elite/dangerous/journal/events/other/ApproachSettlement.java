/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.other;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class ApproachSettlement extends Event
{

    private String name;

    private String bodyName;

    private int    bodyID;

    private double latitude;

    private double longitude;

    private long   marketID;

    private long   systemAddress;

}
