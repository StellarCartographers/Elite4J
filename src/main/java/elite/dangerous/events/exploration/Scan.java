/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.scan.Ring;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Scan.
 */
@SuperBuilder
@Jacksonized
public class Scan extends Event 
{

    /**
     * The scan type.
     */
    public String     scanType;
    /**
     * The body name.
     */
    public String     bodyName;
    /**
     * The body ID.
     */
    public Integer    bodyID;
    /**
     * The star system.
     */
    public String     starSystem;
    /**
     * The distance from arrival LS.
     */
    public Double     distanceFromArrivalLS;
    /**
     * The rotation period.
     */
    public Double     rotationPeriod;
    /**
     * The surface temperature.
     */
    public Double     surfaceTemperature;
    /**
     * The rings.
     */
    public List<Ring> rings;
    /**
     * The semi major axis.
     */
    public Long       semiMajorAxis;
    /**
     * The eccentricity.
     */
    public Double     eccentricity;
    /**
     * The orbital inclination.
     */
    public Double     orbitalInclination;
    /**
     * The periapsis.
     */
    public Double     periapsis;
    /**
     * The orbital period.
     */
    public Long       orbitalPeriod;
}
