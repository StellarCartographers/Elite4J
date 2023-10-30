package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.material.Encoded;
import elite.dangerous.journal.models.material.Manufactured;
import elite.dangerous.journal.models.material.Material;

public class Materials extends Event
{

    public List<Material> raw;

    public List<Manufactured> manufactured;

    public List<Encoded> encoded;

}
