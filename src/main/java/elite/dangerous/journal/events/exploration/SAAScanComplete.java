package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class SAAScanComplete extends Event
{

    private String       bodyName;

    private int          bodyID, probesUsed, efficiencyTarget;

    private long         systemAddress;

    private List<String> descoverers;

    private List<String> mappers;

}
