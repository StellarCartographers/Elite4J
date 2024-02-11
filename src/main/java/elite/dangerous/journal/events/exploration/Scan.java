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

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.scan.Ring;

@EliteObject (ObjectType.PARENT)
public class Scan extends Event
{

    private String     scanType;

    private String     bodyName;

    private int        bodyID;

    private String     starSystem;

    private double     distanceFromArrivalLS;

    private double     rotationPeriod;

    private double     surfaceTemperature;

    private List<Ring> rings;

    private long       semiMajorAxis;

    private double     eccentricity;

    private double     orbitalInclination;

    private double     periapsis;

    private long       orbitalPeriod;

    private boolean    wasDiscovered;

    private boolean    wasMapped;

}
