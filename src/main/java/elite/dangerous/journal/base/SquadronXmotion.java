package elite.dangerous.journal.base;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class SquadronXmotion extends Squadron
{
    private int oldRank;

    private int newRank;
}
