package elite.dangerous.journal.events.stationservices;

import java.util.Date;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class CommunityGoal extends Event
{

    private int     cgid;

    private int     playerContribution;

    private int     numContributors;

    private int     topRankSize;

    private int     playerPercentileBand;

    private int     bonus;

    private String  title;

    private String  systemName;

    private String  marketName;

    private String  tierReached;

    private Date    expiry;

    private boolean isComplete;

    private boolean playerInTopRank;

}
