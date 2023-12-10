package elite.dangerous.journal.events.travel;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.RouteItem;
import lombok.EliteObject;

@EliteObject
public class Route extends Event
{

    private List<RouteItem> route;

}
