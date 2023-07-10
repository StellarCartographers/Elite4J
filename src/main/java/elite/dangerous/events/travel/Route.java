package elite.dangerous.events.travel;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.RouteItem;

/**
 * The Class Route.
 */
public class Route extends Event implements Trigger {

	/**
     * The route.
     */
	public List<RouteItem> route;

}
