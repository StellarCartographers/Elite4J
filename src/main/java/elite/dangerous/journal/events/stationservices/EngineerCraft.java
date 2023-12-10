package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.Modification;
import elite.dangerous.model.engineer.Ingredient;
import lombok.EliteObject;

@EliteObject
public class EngineerCraft extends Event
{

    private String             engineer;

    private String             blueprintName;

    private String             slot;

    private String             module;

    private int                engineerID;

    private int                blueprintID;

    private int                level;

    private double             quality;

    private List<Ingredient>   ingredients;

    private List<Modification> modifiers;

}
