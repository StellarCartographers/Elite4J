/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

import elite.dangerous.model.statistics.*;

public interface IStatistics
{
    public BankAccount bankAccount();

    public Combat combat();

    public Crime crime();

    public Smuggling smuggling();

    public Trading trading();

    public Mining mining();

    public Exploration exploration();

    public Passengers passengers();

    public SearchAndRescue searchAndRescue();

    public ThargoidEncounters thargoidEncounters();

    public Crafting crafting();

    public Crew crew();

    public Multicrew multicrew();

    public MaterialTraderStats materialTraderStats();

    public CQC closeQuartersCombat();

    public FleetCarrier fleetCarrier();

    public Exobiology exobiology();
}
