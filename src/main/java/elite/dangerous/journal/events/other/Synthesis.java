package elite.dangerous.journal.events.other;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.material.Material;
import lombok.EliteObject;

@EliteObject
public class Synthesis extends Event
{
    private String         name;

    private List<Material> materials;
}
