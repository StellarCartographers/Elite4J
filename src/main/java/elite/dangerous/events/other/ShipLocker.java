package elite.dangerous.events.other;

import java.util.ArrayList;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.material.Item;

/**
 * The Class ShipLocker.
 */
public class ShipLocker extends Event implements Trigger {

	/**
     * The items.
     */
	public ArrayList<LockerItem> items;
	
	/**
     * The components.
     */
	public ArrayList<LockerItem> components;
	
	/**
     * The consumables.
     */
	public ArrayList<LockerItem> consumables;
	
	/**
     * The data.
     */
	public ArrayList<LockerItem> data;

	/**
     * The Class LockerItem.
     */
	public static class LockerItem extends Item {

		/**
         * The owner ID.
         */
		public Long ownerID;
		
		/**
         * The mission ID.
         */
		public Long missionID;
	}
}
