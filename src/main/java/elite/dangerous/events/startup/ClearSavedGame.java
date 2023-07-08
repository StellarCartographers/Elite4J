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
 * The Class ClearSavedGame.
 */
@SuperBuilder
@Jacksonized
public class ClearSavedGame extends Event 
{

    /**
     * The name.
     */
    public String name;
    /**
     * The fid.
     */
    @SerializedName("FID")
    public String fid;
}
