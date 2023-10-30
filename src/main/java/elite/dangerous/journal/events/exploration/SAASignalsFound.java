package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;

public class SAASignalsFound extends Event
{
    public String bodyName;

    public long systemAddress;

    public long bodyID;

    public List<Signal> signals;

    public List<Genus> genuses;

    public List<String> getGenuses()
    {
        return genuses.stream().map(Genus::getName).toList();
    }

    public static class Signal
    {
        public String type;

        public long count;
    }

    public static class Genus
    {
        public String genus;

        public String getName()
        {
            return genus;
        }
    }
}
