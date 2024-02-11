/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.travel;

import java.util.List;

import elite.dangerous.model.*;

public interface IDocked
{
    public String stationName();

    public String stationType();

    public String starSystem();

    public Faction stationFaction();

    public String stationGovernment();

    public String stationAllegiance();

    public String stationEconomy();

    public List<StationEconomy> stationEconomies();

    public long systemAddress();

    public long marketID();

    public double distFromStarLS();

    public boolean cockpitBreach();

    public List<String> stationServices();

    public boolean activeFine();

    public boolean wanted();

    public boolean taxi();

    public boolean multicrew();
}
