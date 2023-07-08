/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.backpack;

import java.util.ArrayList;

import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class TradeMicroResources.
 */
@SuperBuilder
@Jacksonized
public class TradeMicroResources extends Event 
{

    /**
     * The offered.
     */
    public ArrayList<MicroResource> offered;
    /**
     * The received.
     */
    public String                   received;
    /**
     * The count.
     */
    public Integer                  count;
    /**
     * The market ID.
     */
    public Long                     marketID;
    /**
     * The category.
     */
    public MicroResource.Category   category;
}
