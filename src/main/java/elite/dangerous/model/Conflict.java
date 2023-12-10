package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject public class Conflict
{

    private String status;

    private String warType;

    public ConflictFaction faction1;

    public ConflictFaction faction2;
}
