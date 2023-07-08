/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import com.google.gson.annotations.SerializedName;

import lombok.experimental.SuperBuilder;

/**
 * The Class Dock.
 */
@SuperBuilder
public abstract class Dock extends Event
{
    /**
     * The id.
     */
    @SerializedName("ID")
    public String id;
}
