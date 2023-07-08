/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Fileheader.
 */
@SuperBuilder
@Jacksonized
public class Fileheader extends Event 
{

    /**
     * The part.
     */
    public Integer part;
    /**
     * The language.
     */
    public String  language;
    /**
     * The odyssey.
     */
    @SerializedName("Odyssey")
    public Boolean odyssey;
    /**
     * The gameversion.
     */
    public String  gameversion;
    /**
     * The build.
     */
    public String  build;
}
