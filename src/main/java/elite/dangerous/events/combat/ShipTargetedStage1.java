/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.combat;

import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ShipTargetedStage1.
 */
@SuperBuilder
@Jacksonized
public class ShipTargetedStage1 extends ShipTargetedStage0 
{

    /**
     * The pilot name.
     */
    public String pilotName;
    /**
     * The pilot name localised.
     */
    public String pilotNameLocalised;
    /**
     * The pilot rank.
     */
    public String pilotRank;
}
