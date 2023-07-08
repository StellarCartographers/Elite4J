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
 * The Class Promotion.
 */
@SuperBuilder
@Jacksonized
public class Promotion extends Event 
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
     * The cqc.
     */
    @SerializedName("CQC")
    public Integer cqc;
    /**
     * The federation.
     */
    public Integer federation;
    /**
     * The empire.
     */
    public Integer empire;
}
