/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

public interface IModuleSwap
{
    public long marketID();

    public String fromSlot();

    public String toSlot();

    public String fromItem();

    public String toItem();

    public String ship();

    public int shipID();
}
