/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.stationservices;

import lombok.*;

import java.util.Date;

import elite.dangerous.journal.Event;

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
