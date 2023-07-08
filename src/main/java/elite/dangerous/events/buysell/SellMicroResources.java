/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.buysell;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SellMicroResources.
 */
@SuperBuilder
@Jacksonized
public class SellMicroResources extends Event 
{

    /**
     * The micro resources.
     */
    public List<MicroResource> microResources;
    /**
     * The price.
     */
    public Long                price;
    /**
     * The market ID.
     */
    public Long                marketID;
}
