package elite.dangerous.journal.base;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class Suit extends Event
{
    private long   suitID;

    private String suitName;

    private String suitName_Localized;

    private long   loadoutID;

    private String loadoutName;
}
