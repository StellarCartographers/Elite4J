package elite.dangerous.events.combat;

import elite.dangerous.Trigger;

/**
 * The Class ShipTargetedStage3.
 */
public class ShipTargetedStage3 extends ShipTargetedStage2 implements Trigger {

	/**
     * The faction.
     */
	public String faction;
	
	/**
     * The legal status.
     */
	public String legalStatus;
	
	/**
     * The subsystem.
     */
	public String subsystem;
	
	/**
     * The subsystem localised.
     */
	public String subsystemLocalised;
	
	/**
     * The subsystem health.
     */
	public Double subsystemHealth;
	
	/**
     * The power.
     */
	public String power;
	
	/**
     * The bounty.
     */
	public Long bounty;

}
