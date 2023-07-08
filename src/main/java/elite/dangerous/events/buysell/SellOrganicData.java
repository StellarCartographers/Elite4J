/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.buysell;

import java.util.ArrayList;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SellOrganicData.
 */
@SuperBuilder
@Jacksonized
public class SellOrganicData extends Event 
{

    /**
     * The market ID.
     */
    public Integer                marketID;
    /**
     * The bio data.
     */
    public ArrayList<BioDataItem> bioData;

    /**
     * The Class BioDataItem.
     */
    public static class BioDataItem
    {

        /**
         * The genus.
         */
        public String genus;
        /**
         * The species.
         */
        public String species;
        /**
         * The value.
         */
        public Long   value;
        /**
         * The bonus.
         */
        public Long   bonus;
    }
}
