package elite.dangerous.events.other;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.inventory.Transfer;

/**
 * The Class CargoTransfer.
 */
public class CargoTransfer extends Event implements Trigger {

	/**
     * The transfers.
     */
	public List<Transfer> transfers;

}
