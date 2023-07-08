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
 * The Class ShipTargetedStage2.
 */
@SuperBuilder
@Jacksonized
public class ShipTargetedStage2 extends ShipTargetedStage1 
{

    /**
     * The shield health.
     */
    public Double shieldHealth;
    /**
     * The hull health.
     */
    public Double hullHealth;
}
