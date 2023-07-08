/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import com.google.gson.annotations.SerializedName;

import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ScanStar.
 */
@SuperBuilder
@Jacksonized
public class ScanStar extends Scan 
{

    /**
     * The star type.
     */
    public String  starType;
    /**
     * The luminosity.
     */
    public String  luminosity;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The stellar mass.
     */
    public Double  stellarMass;
    /**
     * The radius.
     */
    public Long    radius;
    /**
     * The absolute magnitude.
     */
    public Double  absoluteMagnitude;
    /**
     * The age MY.
     */
    @SerializedName("Age_MY")
    public Long    ageMY;
    /**
     * The was mapped.
     */
    public Boolean wasMapped;
    /**
     * The was discovered.
     */
    public Boolean wasDiscovered;
}
