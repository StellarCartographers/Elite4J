/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

public interface IModuleStore
{
    public String slot();

    public String storedItem();

    public String ship();

    public int shipID();

    public boolean hot();

    public long marketID();
}
