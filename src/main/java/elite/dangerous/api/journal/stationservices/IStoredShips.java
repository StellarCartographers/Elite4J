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

import elite.dangerous.model.*;

public interface IStoredShips
{
    public String stationName();

    public String starSystem();

    public long marketID();

    public List<StoredShipHere> shipsHere();

    public List<StoredShipRemote> shipsRemote();
}
