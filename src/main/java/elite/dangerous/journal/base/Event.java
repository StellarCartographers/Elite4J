package elite.dangerous.journal.base;

import org.atteo.classindex.IndexSubclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import elite.dangerous.Elite4J;
import elite.dangerous.util.EliteType;
import elite.dangerous.util.EventTimestamp;
import lombok.EliteObject;
import lombok.ObjectType;
import space.tscg.api.JsonWrapper;

@IndexSubclasses
@EliteObject(ObjectType.PARENT)
public abstract class Event implements JsonWrapper, EliteType
{
    @JsonProperty("timestamp")
    private EventTimestamp timestamp;

    @Override
    public String toJson()
    {
        return Elite4J.ObjToString(this);
    }
}
