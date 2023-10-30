package elite.dangerous.journal.events.other;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.AsteroidMaterial;

public class ProspectedAsteroid extends Event
{

    public static final String[] CONTENTS = {"High", "Medium", "Low"};

    public List<AsteroidMaterial> materials;

    public String content;

    public String motherlodeMaterial;

    public float remaining;

}
