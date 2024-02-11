/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

import java.util.List;

import elite.dangerous.model.*;

public interface ILocation
{
    public String starSystem();

    public String systemAllegiance();

    public String systemEconomy();

    public String systemSecondEconomy();

    public String systemGovernment();

    public String systemSecurity();

    public String body();

    public String bodyType();

    public Faction systemFaction();

    public String powerplayState();

    public String stationName();

    public String stationType();

    public String stationEconomy();

    public Faction stationFaction();

    public String stationAllegiance();

    public String stationGovernment();

    public double[] starPos();

    public long systemAddress();

    public long population();

    public long marketID();

    public int bodyID();

    public boolean docked();

    public List<Faction> factions();

    public List<Conflict> conflicts();

    public List<String> powers();

    public List<String> stationServices();

    public List<StationEconomy> stationEconomies();
}
