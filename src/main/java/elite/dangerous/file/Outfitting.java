/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.file;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Outfitting.
 */
@SuperBuilder
@Jacksonized
public class Outfitting extends Event
{
    /**
     * The market ID.
     */
    public Long   marketID;
    /**
     * The star system.
     */
    public String stationName, starSystem;
}
