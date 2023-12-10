package elite.dangerous.journal.events.other;

import java.util.ArrayList;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.LockerItem;
import lombok.EliteObject;

@EliteObject
public class ShipLocker extends Event
{

    private ArrayList<LockerItem> items;

    private ArrayList<LockerItem> components;

    private ArrayList<LockerItem> consumables;

    private ArrayList<LockerItem> data;
}
