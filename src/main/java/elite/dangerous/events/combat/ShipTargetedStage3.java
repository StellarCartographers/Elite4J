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
 * The Class ShipTargetedStage3.
 */
@SuperBuilder
@Jacksonized
public class ShipTargetedStage3 extends ShipTargetedStage2 
{

    /**
     * The faction.
     */
    public String faction;
    /**
     * The legal status.
     */
    public String legalStatus;
    /**
     * The subsystem.
     */
    public String subsystem;
    /**
     * The subsystem localised.
     */
    public String subsystemLocalised;
    /**
     * The subsystem health.
     */
    public Double subsystemHealth;
    /**
     * The power.
     */
    public String power;
    /**
     * The bounty.
     */
    public Long   bounty;
}
