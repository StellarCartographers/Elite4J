/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import elite.dangerous.base.Event;
import elite.dangerous.models.TradeData;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MaterialTrade.
 */
@SuperBuilder
@Jacksonized
public class MaterialTrade extends Event 
{

    /**
     * The market ID.
     */
    public Long      marketID;
    /**
     * The trader type.
     */
    public String    traderType;
    /**
     * The paid.
     */
    public TradeData paid;
    /**
     * The received.
     */
    public TradeData received;
}
