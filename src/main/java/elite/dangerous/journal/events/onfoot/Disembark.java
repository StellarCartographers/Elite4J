package elite.dangerous.journal.events.onfoot;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class Disembark extends Event
{

    private boolean srv;

    private boolean taxi;

    private boolean multicrew;

    private int     id;

    private String  starSystem;

    private long    systemAddress;

    private String  body;

    private long    bodyID;

    private boolean onStation;

    private boolean onPlanet;

    private String  stationName;

    private String  stationType;

    private long    marketID;

}
