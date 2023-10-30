package elite.dangerous.journal.events.buysell;

import java.util.ArrayList;

import elite.dangerous.journal.base.Event;

public class SellOrganicData extends Event
{

    public int marketID;

    public ArrayList<BioDataItem> bioData;

    public static class BioDataItem
    {

        public String genus;

        public String species;

        public long value;

        public long bonus;
    }
}
