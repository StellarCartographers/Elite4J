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

public interface IFSDJump
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

    public long population();

    public long systemAddress();

    public long boostUsed();

    public int bodyId();

    public double jumpDistance();

    public double fuelUsed();

    public double fuelLevel();

    public List<Faction> factions();

    public List<Conflict> conflicts();

    public double[] starPos();

    public List<String> powers();
}
