/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import elite.dangerous.journal.Event;

@EliteObject 
public class LoadGame extends Event
{
    private String  commander;

    private String  fid;

    private String  ship;

    private String  shipName;

    private String  shipIdent;

    private String  gameMode;

    private String  group;

    private int     shipID;

    private double  fuelLevel;

    private double  fuelCapacity;

    private long    credits;

    private long    loan;

    private boolean horizons;

    private boolean startLanded;

    private boolean startDead;

}
