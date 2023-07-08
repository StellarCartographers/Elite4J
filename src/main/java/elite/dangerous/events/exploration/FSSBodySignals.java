/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.SAASignal;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class FSSBodySignals.
 */
@SuperBuilder
@Jacksonized
public class FSSBodySignals extends Event 
{

    /**
     * The system address.
     */
    public Long            systemAddress;
    /**
     * The body name.
     */
    public String          bodyName;
    /**
     * The body ID.
     */
    public Integer         bodyID;
    /**
     * The signals.
     */
    public List<SAASignal> signals;
}
