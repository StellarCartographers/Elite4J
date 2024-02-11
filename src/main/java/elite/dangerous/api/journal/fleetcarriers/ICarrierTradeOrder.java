/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.fleetcarriers;

public interface ICarrierTradeOrder
{
    public long carrierID();

    public boolean blackMarket();

    public String commodity();

    public int purchaseOrder();

    public int saleOrder();

    public boolean cancelTrade();

    public int price();
}
