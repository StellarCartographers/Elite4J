/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.suit;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Suit;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class LoadoutEquipModule.
 */
@SuperBuilder
@Jacksonized
public class LoadoutEquipModule extends Suit 
{

    /**
     * The slot name.
     */
    public String            slotName;
    /**
     * The module name.
     */
    public String            moduleName;
    /**
     * The module name localised.
     */
    public String            moduleNameLocalised;
    /**
     * The tier.
     */
    @SerializedName("Class")
    public Integer           tier;
    /**
     * The weapon mods.
     */
    public ArrayList<String> weaponMods;
    /**
     * The suit module ID.
     */
    public Long              suitModuleID;
}
