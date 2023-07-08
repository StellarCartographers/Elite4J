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
 * The Class DatalinkVoucher.
 */
@SuperBuilder
@Jacksonized
public class DatalinkVoucher extends Event 
{

    /**
     * The reward.
     */
    public Long   reward;
    /**
     * The victim faction.
     */
    public String victimFaction;
    /**
     * The payee faction.
     */
    public String payeeFaction;
}
