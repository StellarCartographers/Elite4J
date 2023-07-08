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
 * The Class Screenshot.
 */
@SuperBuilder
@Jacksonized
public class Screenshot extends Event 
{

    /**
     * The body.
     */
    public String  filename, system, body;
    /**
     * The heading.
     */
    public Integer width, height, heading;
    /**
     * The altitude.
     */
    public Double  latitude, longitude, altitude;
}
