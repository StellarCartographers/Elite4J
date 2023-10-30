package elite.dangerous.journal.base;

import java.util.Date;

import org.atteo.classindex.IndexSubclasses;

import space.tscg.api.JsonWrapper;
import space.tscg.misc.json.StellarMapper;

@IndexSubclasses
public abstract class Event implements JsonWrapper
{

    public Date timestamp;

    public String type;

    @Override
    public String toJson()
    {
        return StellarMapper.get().asOptionalToString(this).orElseThrow();
    }
}
