package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.material.Encoded;
import elite.dangerous.model.material.Manufactured;
import elite.dangerous.model.material.Material;
import lombok.EliteObject;

@EliteObject
public class Materials extends Event
{

    private List<Material>     raw;

    private List<Manufactured> manufactured;

    private List<Encoded>      encoded;

}
