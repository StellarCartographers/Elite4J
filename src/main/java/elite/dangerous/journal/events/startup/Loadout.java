package elite.dangerous.journal.events.startup;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.FuelCapacity;
import elite.dangerous.journal.models.Module;

public class Loadout extends Event
{

    public String ship;

    public int shipID;

    public String shipName;

    public String shipIdent;

    public int hullValue;

    public int modulesValue;

    public int rebuy;

    public FuelCapacity fuelCapacity;

    public int cargoCapacity;

    public double hullHealth;

    public double maxJumpRange;

    public double unladenMass;

    public String hot;

    public List<Module> modules;

}
