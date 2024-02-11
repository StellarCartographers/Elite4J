/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

public interface IFetchRemoteModule
{
    public int storageSlots();

    public int serverId();

    public int transferCost();

    public int transferTime();

    public int shipId();

    public String storedItem();

    public String ship();
}
