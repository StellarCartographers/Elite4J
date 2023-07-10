package elite.dangerous.events.exploration;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CodexEntry.
 */
public class CodexEntry extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The sub category.
     */
	public String subCategory;
	
	/**
     * The sub category localised.
     */
	public String subCategoryLocalised;
	
	/**
     * The category.
     */
	public String category;
	
	/**
     * The category localised.
     */
	public String categoryLocalised;
	
	/**
     * The region.
     */
	public String region;
	
	/**
     * The system.
     */
	public String system;
	
	/**
     * The entry ID.
     */
	public Integer entryID;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The is new entry.
     */
	public Boolean isNewEntry;
	
	/**
     * The new traits discovered.
     */
	public Boolean newTraitsDiscovered;
	
	/**
     * The traits.
     */
	public String[] traits;
	
	/**
     * The nearest destination.
     */
	public String nearestDestination;
	
	/**
     * The nearest destination localised.
     */
	public String nearestDestinationLocalised;

}
