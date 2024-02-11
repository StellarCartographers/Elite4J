/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.fleetcarriers;

public interface ICarrierFinance
{
    public double taxRate();

    public double reservePercent();

    public long carrierID();

    public long carrierBalance();

    public long reserveBalance();

    public long availableBalance();
}
