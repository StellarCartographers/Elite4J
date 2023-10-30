package elite.dangerous.journal.events.other;

import java.util.ArrayList;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.material.Item;

public class ShipLocker extends Event
{

    public ArrayList<LockerItem> items;

    public ArrayList<LockerItem> components;

    public ArrayList<LockerItem> consumables;

    public ArrayList<LockerItem> data;

    public static class LockerItem extends Item
    {

        public long ownerID;

        public long missionID;
    }
}
