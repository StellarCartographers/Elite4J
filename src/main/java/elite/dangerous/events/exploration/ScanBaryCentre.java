/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ScanBaryCentre.
 */
@SuperBuilder
@Jacksonized
public class ScanBaryCentre extends Event 
{

    /**
     * The body ID.
     */
    public Integer bodyID;
    /**
     * The star system.
     */
    public String  starSystem;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The semi major axis.
     */
    public Double  semiMajorAxis;
    /**
     * The eccentricity.
     */
    public Double  eccentricity;
    /**
     * The orbital inclination.
     */
    public Double  orbitalInclination;
    /**
     * The periapsis.
     */
    public Double  periapsis;
    /**
     * The orbital period.
     */
    public Double  orbitalPeriod;
    /**
     * The ascending node.
     */
    public Double  ascendingNode;
    /**
     * The mean anomaly.
     */
    public Double  meanAnomaly;
}
