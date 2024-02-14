/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.onfoot;

import lombok.*;

import elite.dangerous.journal.Event;

@EliteObject 
public class DropShipDeploy extends Event
{

    private String  starSystem;

    private long    systemAddress;

    private String  body;

    private long    bodyID;

    private boolean onStation;

    private boolean onPlanet;

}
