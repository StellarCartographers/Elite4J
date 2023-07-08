/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class DataScanned.
 */
@SuperBuilder
@Jacksonized
public class DataScanned extends Event 
{

    /**
     * The Constant TYPES.
     */
    public static final String[] TYPES = {"DataLink", "DataPoint", "ListeningPost", "AbandonedDatalog", "WreckedShip"};
    /**
     * The type.
     */
    public String                type;
}
