package elite.dangerous.journal.events.onfoot;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.scan.ScanType;
import lombok.EliteObject;

@EliteObject
public class ScanOrganic extends Event
{

    public ScanType scanType;

    private String  genus;

    private String  species;

    private long    systemAddress;

    private long    body;
}
