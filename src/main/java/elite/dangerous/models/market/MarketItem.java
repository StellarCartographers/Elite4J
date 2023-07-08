/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
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
