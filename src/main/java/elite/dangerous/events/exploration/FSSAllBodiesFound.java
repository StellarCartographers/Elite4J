/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class FSSAllBodiesFound.
 */
@SuperBuilder
@Jacksonized
public class FSSAllBodiesFound extends Event 
{

    /**
     * The system name.
     */
    public String  systemName;
    /**
     * The system address.
     */
    public Long    systemAddress;
    /**
     * The count.
     */
    public Integer count;
}
