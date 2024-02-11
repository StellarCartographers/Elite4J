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

import elite.dangerous.journal.NonDefinedEvent;

@EliteObject 
@NonDefinedEvent
public class ScanStar extends Scan
{
    private String  starType;
    private String  luminosity;
    private long    systemAddress;
    private double  stellarMass;
    private long    radius;
    private double  absoluteMagnitude;
    private long    ageMY;
    private boolean wasMapped;
    private boolean wasDiscovered;
}
