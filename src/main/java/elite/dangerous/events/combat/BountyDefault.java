package elite.dangerous.events.combat;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Bounty;

/**
 * The Class BountyDefault.
 */
public class BountyDefault extends Bounty implements Trigger {

	/**
     * The total reward.
     */
	public Long totalReward;
	
	/**
     * The rewards.
     */
	public List<Reward> rewards;
	
	/**
     * The shared with others.
     */
	public Integer sharedWithOthers;

	/**
     * The Class Reward.
     */
	public static class Reward {

		/**
         * The faction.
         */
		public String faction;
		
		/**
         * The reward.
         */
		public Long reward;
	}

}
