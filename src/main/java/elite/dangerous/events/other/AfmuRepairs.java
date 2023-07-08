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
 * The Class AfmuRepairs.
 */
@SuperBuilder
@Jacksonized
public class AfmuRepairs extends Event 
{

    /**
     * The module.
     */
    public String  module;
    /**
     * The module localised.
     */
    public String  moduleLocalised;
    /**
     * The fully repaired.
     */
    public Boolean fullyRepaired;
    /**
     * The health.
     */
    public Float   health;
}
