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
 * The Class FSDTarget.
 */
@SuperBuilder
@Jacksonized
public class FSDTarget extends Event 
{

    /**
     * The name.
     */
    public String  name;
    /**
     * The star class.
     */
    public String  starClass;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The remaining jumps in route.
     */
    public Integer remainingJumpsInRoute;
}
