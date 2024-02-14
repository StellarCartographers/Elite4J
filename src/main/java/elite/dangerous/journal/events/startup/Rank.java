/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import elite.dangerous.journal.Event;
import elite.dangerous.model.toreadable.*;

@EliteObject 
public class Rank extends Event
{

    private int combat;

    private int trade;

    private int explore;

    private int soldier;

    private int exobiologist;

    private int empire;

    private int federation;

    private int cqc;

    public String combatRankName()
    {
        return CombatRank.getReadableName(this.combat);
    }

    public String tradeRankName()
    {
        return TradeRank.getReadableName(this.trade);
    }

    public String explorerRankName()
    {
        return ExplorationRank.getReadableName(this.explore);
    }

    public String empireRankName()
    {
        return EmpireRank.getReadableName(this.empire);
    }

    public String federationRankName()
    {
        return FederationRank.getReadableName(this.federation);
    }

    public String cqcRankName()
    {
        return CQCRank.getReadableName(this.cqc);
    }

}
