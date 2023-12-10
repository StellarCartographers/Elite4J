package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.FuelCapacity;
import elite.dangerous.model.Module;
import lombok.EliteObject;

@EliteObject
public class Loadout extends Event
{

    private String       ship;

    private int          shipID;

    private String       shipName;

    private String       shipIdent;

    private int          hullValue;

    private int          modulesValue;

    private int          rebuy;

    public FuelCapacity  fuelCapacity;

    private int          cargoCapacity;

    private double       hullHealth;

    private double       maxJumpRange;

    private double       unladenMass;

    private String       hot;

    private List<Module> modules;

}
