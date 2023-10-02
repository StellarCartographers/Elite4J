package elite.dangerous.journal;

import java.util.Date;

import org.atteo.classindex.IndexSubclasses;

import space.tscg.common.json.Json;

@IndexSubclasses
public abstract class Event
{

    public Date timestamp;

    public String type;

    @Override
    public String toString()
    {
        return Json.prettyString(this);
    }
}
