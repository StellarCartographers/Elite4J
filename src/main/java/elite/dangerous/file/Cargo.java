/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.file;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.CargoItem;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Cargo.
 */
@SuperBuilder
@Jacksonized
public class Cargo extends Event
{
    /**
     * The vessel.
     */
    public String          vessel;
    /**
     * The count.
     */
    public Integer         count;
    /**
     * The inventory.
     */
    public List<CargoItem> inventory;
}
