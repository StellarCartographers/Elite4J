package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.Modification;
import elite.dangerous.journal.models.engineer.Ingredient;

public class EngineerCraft extends Event
{

    public String engineer;

    public String blueprintName;

    public String slot;

    public String module;

    public int engineerID;

    public int blueprintID;

    public int level;

    public double quality;

    public List<Ingredient> ingredients;

    public List<Modification> modifiers;

}
