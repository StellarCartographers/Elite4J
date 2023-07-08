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
 * The Class USSDrop.
 */
@SuperBuilder
@Jacksonized
public class USSDrop extends Event 
{

    /**
     * The uss type.
     */
    @SerializedName("USSType")
    public String  ussType;
    /**
     * The uss type localised.
     */
    @SerializedName("USSType_Localised")
    public String  ussTypeLocalised;
    /**
     * The uss threat.
     */
    @SerializedName("USSThreat")
    public Integer ussThreat;
}
