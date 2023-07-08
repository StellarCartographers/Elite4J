/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class CrimeVictim.
 */
@SuperBuilder
@Jacksonized
public class CrimeVictim extends Event 
{

    /**
     * The offender.
     */
    public String offender;
    /**
     * The crime type.
     */
    public String crimeType;
    /**
     * The fine or bounty.
     */
    @SerializedName("Fine_or_Bounty")
    public String fineOrBounty;
}
