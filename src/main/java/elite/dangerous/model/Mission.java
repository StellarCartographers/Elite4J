package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject public class Mission
{

    private int missionID;

    private long expires;

    private String name;

    private boolean passengerMission;
}
