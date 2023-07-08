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
 * The Class Progress.
 */
@SuperBuilder
@Jacksonized
public class Progress extends Event 
{

    /**
     * The combat.
     */
    public Integer combat;
    /**
     * The trade.
     */
    public Integer trade;
    /**
     * The explore.
     */
    public Integer explore;
    /**
     * The soldier.
     */
    public Integer soldier;
    /**
     * The exobiologist.
     */
    public Integer exobiologist;
    /**
     * The empire.
     */
    public Integer empire;
    /**
     * The federation.
     */
    public Integer federation;
    /**
     * The cqc.
     */
    @SerializedName("CQC")
    public Integer cqc;
}
