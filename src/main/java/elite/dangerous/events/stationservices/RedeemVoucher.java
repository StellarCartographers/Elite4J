package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class RedeemVoucher.
 */
public class RedeemVoucher extends Event implements Trigger {

	/**
     * The type.
     */
	public String type;
	
	/**
     * The total amount.
     */
	public Long totalAmount;
	
	/**
     * The broker percentage.
     */
	public Integer brokerPercentage;
	
	/**
     * The factions.
     */
	public List<FactionBounty> factions;

	/**
     * The Class FactionBounty.
     */
	public static class FactionBounty {

		/**
         * The faction.
         */
		public String faction;
		
		/**
         * The amount.
         */
		public Long amount;
	}

}
