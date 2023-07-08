/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.AsteroidMaterial;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ProspectedAsteroid.
 */
@SuperBuilder
@Jacksonized
public class ProspectedAsteroid extends Event 
{

    /**
     * The Constant CONTENTS.
     */
    public static final String[]  CONTENTS = {"High", "Medium", "Low"};
    /**
     * The materials.
     */
    public List<AsteroidMaterial> materials;
    /**
     * The content.
     */
    public String                 content;
    /**
     * The motherlode material.
     */
    public String                 motherlodeMaterial;
    /**
     * The remaining.
     */
    public Float                  remaining;
}
