package elite.dangerous.events.travel;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.Conflict;
import elite.dangerous.models.Faction;

/**
 * The Class FSDJump.
 */
public class FSDJump extends Event implements Trigger {

	/**
     * The star system.
     */
	public String starSystem;
	
	/**
     * The system allegiance.
     */
	public String systemAllegiance;
	
	/**
     * The system economy.
     */
	public String systemEconomy;
	
	/**
     * The system economy localised.
     */
	public String systemEconomyLocalised;
	
	/**
     * The system second economy.
     */
	public String systemSecondEconomy;
	
	/**
     * The system second economy localised.
     */
	public String systemSecondEconomyLocalised;
	
	/**
     * The system government.
     */
	public String systemGovernment;
	
	/**
     * The system government localised.
     */
	public String systemGovernmentLocalised;
	
	/**
     * The system security.
     */
	public String systemSecurity;
	
	/**
     * The system security localised.
     */
	public String systemSecurityLocalised;
	
	/**
     * The body.
     */
	public String body;
	
	/**
     * The body type.
     */
	public String bodyType;
	
	/**
     * The system faction.
     */
	public Faction systemFaction;
	
	/**
     * The powerplay state.
     */
	public String powerplayState;
	
	/**
     * The population.
     */
	public Long population;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The boost used.
     */
	public Long boostUsed;
	
	/**
     * The body id.
     */
	public Integer bodyId;
	
	/**
     * The jump distance.
     */
	public Double jumpDistance;
	
	/**
     * The fuel used.
     */
	public Double fuelUsed;
	
	/**
     * The fuel level.
     */
	public Double fuelLevel;
	
	/**
     * The factions.
     */
	public List<Faction> factions;
	
	/**
     * The conflicts.
     */
	public List<Conflict> conflicts;
	
	/**
     * The star pos.
     */
	public Double[] starPos;
	
	/**
     * The powers.
     */
	public List<String> powers;

}
