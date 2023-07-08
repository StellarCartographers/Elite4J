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
 * The Class ShipTargetedStage0.
 */
@SuperBuilder
@Jacksonized
public class ShipTargetedStage0 extends ShipTargeted 
{

    /**
     * The ship.
     */
    public String  ship;
    /**
     * The ship localised.
     */
    public String  shipLocalised;
    /**
     * The scan stage.
     */
    public Integer scanStage;
}
