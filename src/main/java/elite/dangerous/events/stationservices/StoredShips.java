package elite.dangerous.events.stationservices;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.StoredShipHere;
import elite.dangerous.models.StoredShipRemote;

/**
 * The Class StoredShips.
 */
public class StoredShips extends Event implements Trigger {

	/**
     * The star system.
     */
	public String stationName, starSystem;
	
	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The ships here.
     */
	public List<StoredShipHere> shipsHere;
	
	/**
     * The ships remote.
     */
	public List<StoredShipRemote> shipsRemote;

}
