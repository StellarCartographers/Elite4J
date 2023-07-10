package elite.dangerous.events.other;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ReceiveText.
 */
public class ReceiveText extends Event implements Trigger {

	/**
     * The from.
     */
	public String from;
	
	/**
     * The from localised.
     */
	public String fromLocalised;
	
	/**
     * The message.
     */
	public String message;
	
	/**
     * The message localised.
     */
	public String messageLocalised;
	
	/**
     * The channel.
     */
	public String channel;

}
