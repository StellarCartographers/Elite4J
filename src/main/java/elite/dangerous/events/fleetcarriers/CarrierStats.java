package elite.dangerous.events.fleetcarriers;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.CrewItem;
import elite.dangerous.models.Finance;
import elite.dangerous.models.Pack;
import elite.dangerous.models.SpaceUsage;

/**
 * The Class CarrierStats.
 */
public class CarrierStats extends Event implements Trigger {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The callsign.
     */
	public String callsign;
	
	/**
     * The name.
     */
	public String name;
	
	/**
     * The docking access.
     */
	public String dockingAccess;
	
	/**
     * The allow notorious.
     */
	public boolean allowNotorious;
	
	/**
     * The fuel level.
     */
	public Integer fuelLevel;
	
	/**
     * The jump range curr.
     */
	public Float jumpRangeCurr;
	
	/**
     * The jump range max.
     */
	public Float jumpRangeMax;
	
	/**
     * The pending decommission.
     */
	public Boolean pendingDecommission;
	
	/**
     * The space usage.
     */
	public SpaceUsage spaceUsage;
	
	/**
     * The finance.
     */
	public Finance finance;
	
	/**
     * The crew.
     */
	public List<CrewItem> crew;
	
	/**
     * The ship packs.
     */
	public List<Pack> shipPacks;
	
	/**
     * The module packs.
     */
	public List<Pack> modulePacks;

}
