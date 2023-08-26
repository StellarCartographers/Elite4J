package elite.dangerous.events.backpack;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.MicroResource;

/**
 * Written when transferreing items between backpack and ship locker
 */
public class TransferMicroResources extends Event implements Trigger {

	/**
     * The transfers.
     */
	public List<MicroResourceTransfer> transfers;

	/**
     * The Class MicroResourceTransfer.
     */
	public static class MicroResourceTransfer extends MicroResource {

		/**
         * The direction.
         */
		public String direction;
	}
}
