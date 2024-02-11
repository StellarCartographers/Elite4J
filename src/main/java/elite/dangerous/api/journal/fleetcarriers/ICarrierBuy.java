/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.fleetcarriers;

public interface ICarrierBuy
{
    public long boughtAtMarket();

    public long carrierID();

    public String location();

    public long price();

    public String variant();

    public String callsign();
}
