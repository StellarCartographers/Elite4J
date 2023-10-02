package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.Event;

public class SAAScanComplete extends Event
{

    public String bodyName;

    public int bodyID, probesUsed, efficiencyTarget;

    public long systemAddress;

    public List<String> descoverers;

    public List<String> mappers;

}
