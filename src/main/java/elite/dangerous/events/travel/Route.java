/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.travel;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.RouteItem;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class Route.
 */
@SuperBuilder
@Jacksonized
public class Route extends Event 
{

    /**
     * The route.
     */
    public List<RouteItem> route;
}
