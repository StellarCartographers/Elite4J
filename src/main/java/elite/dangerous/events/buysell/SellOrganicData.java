package elite.dangerous.events.buysell;

import java.util.ArrayList;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class SellOrganicData.
 */
public class SellOrganicData extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Integer marketID;
	
	/**
     * The bio data.
     */
	public ArrayList<BioDataItem> bioData;

	/**
     * The Class BioDataItem.
     */
	public static class BioDataItem {

		/**
         * The genus.
         */
		public String genus;
		
		/**
         * The species.
         */
		public String species;
		
		/**
         * The value.
         */
		public Long value;
		
		/**
         * The bonus.
         */
		public Long bonus;
	}
}
