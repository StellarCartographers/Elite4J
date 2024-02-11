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
public class MissionRedirected extends Event
{

    private String name;

    private String newDestinationStation;

    private String newDestinationSystem;

    private String oldDestinationStation;

    private String oldDestinationSystem;

    private long   missionID;

}
