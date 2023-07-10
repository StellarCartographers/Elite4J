package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.SAASignal;

/**
 * The Class FSSBodySignals.
 */
public class FSSBodySignals extends Event implements Trigger {

	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The body name.
     */
	public String bodyName;
	
	/**
     * The body ID.
     */
	public Integer bodyID;
	
	/**
     * The signals.
     */
	public List<SAASignal> signals;

}
