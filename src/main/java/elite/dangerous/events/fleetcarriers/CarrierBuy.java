package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierBuy.
 */
public class CarrierBuy extends Event implements Trigger {

	/**
     * The bought at market.
     */
	public Long boughtAtMarket;
	
	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The location.
     */
	public String location;
	
	/**
     * The price.
     */
	public Long price;
	
	/**
     * The variant.
     */
	public String variant;
	
	/**
     * The callsign.
     */
	public String callsign;

}
