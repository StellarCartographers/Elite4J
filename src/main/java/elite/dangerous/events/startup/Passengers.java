/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.PassengerRecord;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Passengers.
 */
@SuperBuilder
@Jacksonized
public class Passengers extends Event 
{

    /**
     * The manifest.
     */
    public List<PassengerRecord> manifest;
}
