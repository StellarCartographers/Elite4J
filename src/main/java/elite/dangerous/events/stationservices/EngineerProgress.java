/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.engineer.Engineer;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class EngineerProgress.
 */
@SuperBuilder
@Jacksonized
public class EngineerProgress extends Event 
{

    /**
     * The engineers.
     */
    public List<Engineer> engineers;
    /**
     * The rank.
     */
    public Integer        rank;
    /**
     * The rank progress.
     */
    public Double         rankProgress;
}
