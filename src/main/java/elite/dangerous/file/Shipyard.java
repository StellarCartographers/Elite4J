/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.file;

import java.util.List;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Shipyard.
 */
@SuperBuilder
@Jacksonized
public class Shipyard extends Event
{
    /**
     * The market ID.
     */
    public Long            marketID;
    /**
     * The star system.
     */
    public String          stationName, starSystem;
    /**
     * The horizons.
     */
    public Boolean         horizons;
    /**
     * The allow cobra mk IV.
     */
    public Boolean         allowCobraMkIV;
    /**
     * The price list.
     */
    public List<PriceItem> priceList;

    /**
     * The Class PriceItem.
     */
    public static class PriceItem
    {
        /**
         * The id.
         */
        public Long   id;
        /**
         * The ship type.
         */
        public String shipType;
        /**
         * The ship type localised.
         */
        public String shipTypeLocalised;
        /**
         * The ship price.
         */
        public Long   shipPrice;
    }
}
