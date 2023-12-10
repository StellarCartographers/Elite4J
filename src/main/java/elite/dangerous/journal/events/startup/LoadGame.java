package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class LoadGame extends Event
{
    private String  commander;

    private String  fid;

    private String  ship;

    private String  shipName;

    private String  shipIdent;

    private String  gameMode;

    private String  group;

    private int     shipID;

    private double  fuelLevel;

    private double  fuelCapacity;

    private long    credits;

    private long    loan;

    private boolean horizons;

    private boolean startLanded;

    private boolean startDead;

}
