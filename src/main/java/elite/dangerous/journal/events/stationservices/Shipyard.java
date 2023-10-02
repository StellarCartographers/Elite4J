package elite.dangerous.journal.events.stationservices;

import java.util.List;

import elite.dangerous.journal.Event;

public class Shipyard extends Event
{

    public long marketID;

    public String stationName, starSystem;

    public boolean horizons;

    public boolean allowCobraMkIV;

    public List<PriceItem> priceList;

    public static class PriceItem
    {

        public int id;

        public String shipType;

        public String shipTypeLocalised;

        public long shipPrice;
    }
}
