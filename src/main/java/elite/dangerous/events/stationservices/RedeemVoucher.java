/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class RedeemVoucher.
 */
@SuperBuilder
@Jacksonized
public class RedeemVoucher extends Event 
{

    /**
     * The type.
     */
    public String              type;
    /**
     * The total amount.
     */
    public Long                totalAmount;
    /**
     * The broker percentage.
     */
    public Integer             brokerPercentage;
    /**
     * The factions.
     */
    public List<FactionBounty> factions;

    /**
     * The Class FactionBounty.
     */
    public static class FactionBounty
    {

        /**
         * The faction.
         */
        public String faction;
        /**
         * The amount.
         */
        public Long   amount;
    }
}
