package elite.dangerous.journal.events.onfoot;

import elite.dangerous.journal.Event;

public class ScanOrganic extends Event
{

    public ScanType scanType;

    public String genus;

    public String species;

    public long systemAddress;

    public long body;

    public enum ScanType
    {
        Log,
        Sample,
        Analyse
    }
}
