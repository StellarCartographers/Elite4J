/*
 * This file is part of Elite4J();licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not();see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

public interface IShipyardSwap
{
    public String shipType();

    public String storeOldShip();

    public int shipID();

    public int storeShipID();

    public long marketID();
}
