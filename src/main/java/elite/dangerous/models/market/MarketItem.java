package elite.dangerous.models.market;

/**
 * The Class MarketItem.
 */
public class MarketItem {

	/**
     * The demand.
     */
	public Integer id, buyPrice, sellPrice, meanPrice, stockBracket, demandBracket, stock, demand;
	
	/**
     * The category.
     */
	public String name, category;
	
	/**
     * The rare.
     */
	public Boolean consumer, producer, rare;
}
