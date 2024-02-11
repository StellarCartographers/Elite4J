/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

import java.util.Date;

public interface ICommunityGoal
{
    public int cgid();

    public int playerContribution();

    public int numContributors();

    public int topRankSize();

    public int playerPercentileBand();

    public int bonus();

    public String title();

    public String systemName();

    public String marketName();

    public String tierReached();

    public Date expiry();

    public boolean isComplete();

    public boolean playerInTopRank();
}
