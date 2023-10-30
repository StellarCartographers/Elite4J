package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import elite.dangerous.journal.models.toreadable.CQCRank;
import elite.dangerous.journal.models.toreadable.CombatRank;
import elite.dangerous.journal.models.toreadable.EmpireRank;
import elite.dangerous.journal.models.toreadable.ExplorationRank;
import elite.dangerous.journal.models.toreadable.FederationRank;
import elite.dangerous.journal.models.toreadable.TradeRank;

public class Rank extends Event
{

    public int combat;

    public int trade;

    public int explore;

    public int soldier;

    public int exobiologist;

    public int empire;

    public int federation;

    public int cqc;

    public String getCombatRankName()
    {
        return CombatRank.getReadableName(this.combat);
    }

    public String getTradeRankName()
    {
        return TradeRank.getReadableName(this.trade);
    }

    public String getExplorerRankName()
    {
        return ExplorationRank.getReadableName(this.explore);
    }

    public String getEmpireRankName()
    {
        return EmpireRank.getReadableName(this.empire);
    }

    public String getFederationRankName()
    {
        return FederationRank.getReadableName(this.federation);
    }

    public String getCQCRankName()
    {
        return CQCRank.getReadableName(this.cqc);
    }

}
