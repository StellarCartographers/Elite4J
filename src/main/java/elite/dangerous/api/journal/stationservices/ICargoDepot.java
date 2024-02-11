/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

public interface ICargoDepot
{
    public long missionID();

    public long startMarketID();

    public long endMarketID();

    public int count();

    public int itemCollected();

    public int itemsDelivered();

    public int totalItemsToDeliver();

    public String updateType();

    public String cargoType();

    public double progress();
}
