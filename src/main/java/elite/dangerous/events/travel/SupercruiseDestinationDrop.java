/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.travel;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SupercruiseDestinationDrop.
 */
@SuperBuilder
@Jacksonized
public class SupercruiseDestinationDrop extends Event 
{

    /**
     * The type.
     */
    public String  type;
    /**
     * The threat.
     */
    public Integer threat;
    /**
     * The market ID.
     */
    public Long    marketID;
}
