package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.Modification;
import elite.dangerous.models.engineer.Ingredient;

/**
 * The Class EngineerCraft.
 */
public class EngineerCraft extends Event implements Trigger {

	/**
     * The engineer.
     */
	public String engineer;
	
	/**
     * The blueprint name.
     */
	public String blueprintName;
	
	/**
     * The slot.
     */
	public String slot;
	
	/**
     * The module.
     */
	public String module;
	
	/**
     * The engineer ID.
     */
	public Integer engineerID;
	
	/**
     * The blueprint ID.
     */
	public Integer blueprintID;
	
	/**
     * The level.
     */
	public Integer level;
	
	/**
     * The quality.
     */
	public Double quality;
	
	/**
     * The ingredients.
     */
	public List<Ingredient> ingredients;
	
	/**
     * The modifiers.
     */
	public List<Modification> modifiers;

}
