/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.Mission;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Missions.
 */
@SuperBuilder
@Jacksonized
public class Missions extends Event 
{

    /**
     * The active.
     */
    public List<Mission> active;
    /**
     * The failed.
     */
    public List<Mission> failed;
    /**
     * The complete.
     */
    public List<Mission> complete;
}
