/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

import java.util.List;

import elite.dangerous.model.market.MarketItem;

public interface IMarket
{
    public String stationName();

    public String starSystem();

    public String stationType();

    public String carrierDockingAccess();

    public int marketID();

    public List<MarketItem> items();
}
