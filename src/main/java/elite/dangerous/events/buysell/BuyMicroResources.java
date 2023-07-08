/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.buysell;

import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class BuyMicroResources.
 */
@SuperBuilder
@Jacksonized
public class BuyMicroResources extends Event 
{

    /**
     * The name.
     */
    public String                 name;
    /**
     * The name localised.
     */
    public String                 nameLocalised;
    /**
     * The category.
     */
    public MicroResource.Category category;
    /**
     * The count.
     */
    public Integer                count;
    /**
     * The price.
     */
    public Long                   price;
    /**
     * The market ID.
     */
    public Long                   marketID;
}
