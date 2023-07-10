package elite.dangerous.events.stationservices;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.TradeData;

/**
 * The Class MaterialTrade.
 */
public class MaterialTrade extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The trader type.
     */
	public String traderType;
	
	/**
     * The paid.
     */
	public TradeData paid;
	
	/**
     * The received.
     */
	public TradeData received;

}
