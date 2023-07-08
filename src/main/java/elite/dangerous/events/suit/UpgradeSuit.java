/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.suit;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class UpgradeSuit.
 */
@SuperBuilder
@Jacksonized
public class UpgradeSuit extends Event 
{

    /**
     * The name.
     */
    public String  name;
    /**
     * The name localised.
     */
    public String  nameLocalised;
    /**
     * The suit ID.
     */
    public Long    suitID;
    /**
     * The suit class.
     */
    @SerializedName("Class")
    public Integer suitClass;
    /**
     * The cost.
     */
    public Long    cost;
}
