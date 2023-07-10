package elite.dangerous.events.fleetcarriers;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class CarrierTradeOrder.
 */
public class CarrierTradeOrder extends Event implements Trigger {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The black market.
     */
	public Boolean blackMarket;
	
	/**
     * The commodity.
     */
	public String commodity;
	
	/**
     * The purchase order.
     */
	public Integer purchaseOrder;
	
	/**
     * The sale order.
     */
	public Integer saleOrder;
	
	/**
     * The cancel trade.
     */
	public Boolean cancelTrade;
	
	/**
     * The price.
     */
	public Integer price;

}
