package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.toreadable.CQCRank;
import elite.dangerous.model.toreadable.CombatRank;
import elite.dangerous.model.toreadable.EmpireRank;
import elite.dangerous.model.toreadable.ExplorationRank;
import elite.dangerous.model.toreadable.FederationRank;
import elite.dangerous.model.toreadable.TradeRank;
import lombok.EliteObject;

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
