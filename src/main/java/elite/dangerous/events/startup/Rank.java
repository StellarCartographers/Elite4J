package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.toreadable.CQCRank;
import elite.dangerous.models.toreadable.CombatRank;
import elite.dangerous.models.toreadable.EmpireRank;
import elite.dangerous.models.toreadable.ExplorationRank;
import elite.dangerous.models.toreadable.FederationRank;
import elite.dangerous.models.toreadable.TradeRank;

/**
 * The Class Rank.
 */
public class Rank extends Event implements Trigger {

	/**
     * The combat.
     */
	public Integer combat;
	
	/**
     * The trade.
     */
	public Integer trade;
	
	/**
     * The explore.
     */
	public Integer explore;
	
	/**
     * The soldier.
     */
	public Integer soldier;
	
	/**
     * The exobiologist.
     */
	public Integer exobiologist;
	
	/**
     * The empire.
     */
	public Integer empire;
	
	/**
     * The federation.
     */
	public Integer federation;
	
	/**
     * The cqc.
     */
	@SerializedName("CQC")
	public Integer cqc;

	public String getCombatRankName() {
		return CombatRank.getReadableName(this.combat);
	}

	public String getTradeRankName() {
		return TradeRank.getReadableName(this.trade);
	}

	public String getExplorerRankName() {
		return ExplorationRank.getReadableName(this.explore);
	}

	public String getEmpireRankName() {
		return EmpireRank.getReadableName(this.empire);
	}

	public String getFederationRankName() {
		return FederationRank.getReadableName(this.federation);
	}

	public String getCQCRankName() {
		return CQCRank.getReadableName(this.cqc);
	}

}
