package elite.dangerous.models;

/**
 * The Class MicroResource.
 */
public class MicroResource {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The name localised.
     */
	public String nameLocalised;
	
	/**
     * The category.
     */
	public Category category;
	
	/**
     * The count.
     */
	public int count;

	/**
     * The Enum Category.
     */
	public enum Category {
		Encoded, Raw, Manufactured, Item, Component, Data, Consumable,
	}
}