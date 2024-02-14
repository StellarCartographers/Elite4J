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

import java.util.Date;

import elite.dangerous.journal.Event;

@EliteObject 
public class MissionAccepted extends Event
{

    private String faction;

    private String name;

    private String localisedName;

    private String targetFaction;

    private String destinationSystem;

    private String destinationStation;

    private String influence;

    private String reputation;

    private long   reward;

    private long   missionID;

    public Date    expiry;

}
