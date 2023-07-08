/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.backpack;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class TransferMicroResources.
 */
@SuperBuilder
@Jacksonized
public class TransferMicroResources extends Event 
{

    /**
     * The transfers.
     */
    public List<MicroResourceTransfer> transfers;

    /**
     * The Class MicroResourceTransfer.
     */
    public static class MicroResourceTransfer extends MicroResource
    {

        /**
         * The direction.
         */
        public String direction;
    }
}
