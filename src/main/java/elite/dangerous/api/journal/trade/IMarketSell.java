/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.trade;

public interface IMarketSell
{
    public long marketID();

    public String type();

    public int count();

    public int sellPrice();

    public int totalSale();

    public int avgPricePaid();

    public boolean illegalGoods();

    public boolean stolenGoods();

    public boolean blackMarket();
}
