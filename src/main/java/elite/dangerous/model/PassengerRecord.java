package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class PassengerRecord
{
    private String  type;
    private int     count;
    private boolean vip;
    private boolean wanted;
    private long    missionID;
}
