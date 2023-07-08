/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import lombok.experimental.SuperBuilder;

/**
 * The Class CarrierPack.
 */
@SuperBuilder
public abstract class CarrierPack extends Event
{
    /**
     * The carrier ID.
     */
    public Long    carrierID;
    /**
     * The operation.
     */
    public String  operation;
    /**
     * The pack theme.
     */
    public String  packTheme;
    /**
     * The pack tier.
     */
    public Integer packTier;
    /**
     * The cost.
     */
    public Integer cost;
}
