/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.trade;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class MiningRefined.
 */
@SuperBuilder
@Jacksonized
public class MiningRefined extends Event 
{

    /**
     * The type.
     */
    public String type;
    /**
     * The type localised.
     */
    public String typeLocalised;
}
