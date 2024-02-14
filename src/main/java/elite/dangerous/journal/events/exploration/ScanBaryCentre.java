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

import elite.dangerous.journal.Event;

@EliteObject 
public class ScanBaryCentre extends Event
{

    private int    bodyID;

    private String starSystem;

    private long   systemAddress;

    private double semiMajorAxis;

    private double eccentricity;

    private double orbitalInclination;

    private double periapsis;

    private double orbitalPeriod;

    private double ascendingNode;

    private double meanAnomaly;

}
