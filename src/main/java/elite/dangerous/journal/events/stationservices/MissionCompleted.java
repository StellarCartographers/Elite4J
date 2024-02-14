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
public class MissionCompleted extends Event
{

    private String faction;

    private String name;

    private String targetFaction;

    private String destinationSystem;

    private String destinationStation;

    private long   missionID;

    private long   reward;

}
