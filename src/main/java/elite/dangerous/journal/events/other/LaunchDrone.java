package elite.dangerous.journal.events.other;

import elite.dangerous.journal.base.Event;

public class LaunchDrone extends Event
{

    public static final String[] TYPES = {"Hatchbreaker", "FuelTransfer", "Collection", "Prospector", "Repair", "Research", "Decontamination"};

    public String type;

}
