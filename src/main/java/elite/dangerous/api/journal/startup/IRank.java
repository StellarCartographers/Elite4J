/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

import elite.dangerous.model.toreadable.*;

public interface IRank
{
    public int combat();

    public int trade();

    public int explore();

    public int soldier();

    public int exobiologist();

    public int empire();

    public int federation();

    public int cqc();

    default String combatRankName()
    {
        return CombatRank.getReadableName(this.combat());
    }

    default String tradeRankName()
    {
        return TradeRank.getReadableName(this.trade());
    }

    default String explorerRankName()
    {
        return ExplorationRank.getReadableName(this.explore());
    }

    default String empireRankName()
    {
        return EmpireRank.getReadableName(this.empire());
    }

    default String federationRankName()
    {
        return FederationRank.getReadableName(this.federation());
    }

    default String cqcRankName()
    {
        return CQCRank.getReadableName(this.cqc());
    }
}
