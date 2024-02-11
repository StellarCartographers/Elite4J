/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.exploration;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class FSSSignalDiscovered extends Event
{

    private String  signalName;

    private String  ussType;

    private String  spawningState;

    private String  spawningFaction;

    private int     threatLevel;

    private long    systemAddress;

    private double  timeRemaining;

    private boolean isStation;

}
