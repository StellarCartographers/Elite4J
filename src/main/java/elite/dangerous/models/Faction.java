package elite.dangerous.models;

import java.util.List;

/**
 * The Class Faction.
 */
public class Faction {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The faction state.
     */
	public String factionState;
	
	/**
     * The government.
     */
	public String government;
	
	/**
     * The allegiance.
     */
	public String allegiance;
	
	/**
     * The happiness.
     */
	public String happiness;
	
	/**
     * The my reputation.
     */
	public Double myReputation;
	
	/**
     * The influence.
     */
	public Double influence;
	
	/**
     * The active states.
     */
	public List<FactionState> activeStates;
	
	/**
     * The pending states.
     */
	public List<FactionState> pendingStates;
	
	/**
     * The recovering states.
     */
	public List<FactionState> recoveringStates;
	
	/**
     * The squadron system.
     */
	public Boolean squadronSystem;
	
	/**
     * The happiest system.
     */
	public Boolean happiestSystem;
	
	/**
     * The home system.
     */
	public Boolean homeSystem;
}
