/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.fleetcarriers;

import java.util.List;

import elite.dangerous.model.*;

public interface ICarrierStats
{
    public long carrierID();

    public String callsign();

    public String name();

    public String dockingAccess();

    public boolean allowNotorious();

    public int fuelLevel();

    public float jumpRangeCurr();

    public float jumpRangeMax();

    public boolean pendingDecommission();

    public SpaceUsage spaceUsage();

    public Finance finance();

    public List<CrewItem> crew();

    public List<Pack> shipPacks();

    public List<Pack> modulePacks();
}
