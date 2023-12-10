package elite.dangerous.model.backpack;

import lombok.EliteObject;

@EliteObject public class BackpackItem
{

    private String name;

    private long ownerID;

    private long missionID;

    private int count;

    private String type;
}
