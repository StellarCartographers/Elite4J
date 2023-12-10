package elite.dangerous.journal.events.other;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.AsteroidMaterial;
import lombok.EliteObject;

@EliteObject
public class ProspectedAsteroid extends Event
{

    public static final String[]   CONTENTS = {"High", "Medium", "Low"};

    private List<AsteroidMaterial> materials;

    private String                 content;

    private String                 motherlodeMaterial;

    public float                   remaining;

}
