package elite.dangerous.journal.events.onfoot;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class DropShipDeploy extends Event
{

    private String  starSystem;

    private long    systemAddress;

    private String  body;

    private long    bodyID;

    private boolean onStation;

    private boolean onPlanet;

}
