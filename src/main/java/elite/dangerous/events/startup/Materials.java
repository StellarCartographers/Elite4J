/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.material.Encoded;
import elite.dangerous.models.material.Manufactured;
import elite.dangerous.models.material.Material;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Materials.
 */
@SuperBuilder
@Jacksonized
public class Materials extends Event 
{

    /**
     * The raw.
     */
    public List<Material>     raw;
    /**
     * The manufactured.
     */
    public List<Manufactured> manufactured;
    /**
     * The encoded.
     */
    public List<Encoded>      encoded;
}
