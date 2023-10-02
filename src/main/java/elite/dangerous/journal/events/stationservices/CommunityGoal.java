package elite.dangerous.journal.events.stationservices;

import java.util.Date;

import elite.dangerous.journal.Event;

public class CommunityGoal extends Event
{

    public int cgid;

    public int playerContribution;

    public int numContributors;

    public int topRankSize;

    public int playerPercentileBand;

    public int bonus;

    public String title;

    public String systemName;

    public String marketName;

    public String tierReached;

    public Date expiry;

    public boolean isComplete;

    public boolean playerInTopRank;

}
