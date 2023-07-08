/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.powerplay;

import java.util.List;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class PowerplayVoucher.
 */
@SuperBuilder
@Jacksonized
public class PowerplayVoucher extends Event 
{

    /**
     * The power.
     */
    public String       power;
    /**
     * The systems.
     */
    public List<String> systems;
}
