package elite.dangerous.events.trade;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class MarketSell.
 */
public class MarketSell extends Event implements Trigger {

	/**
     * The market ID.
     */
	public Long marketID;
	
	/**
     * The type.
     */
	public String type;
	
	/**
     * The type localised.
     */
	public String typeLocalised;
	
	/**
     * The count.
     */
	public Integer count;
	
	/**
     * The sell price.
     */
	public Integer sellPrice;
	
	/**
     * The total sale.
     */
	public Integer totalSale;
	
	/**
     * The avg price paid.
     */
	public Integer avgPricePaid;
	
	/**
     * The illegal goods.
     */
	public Boolean illegalGoods;
	
	/**
     * The stolen goods.
     */
	public Boolean stolenGoods;
	
	/**
     * The black market.
     */
	public Boolean blackMarket;

}
