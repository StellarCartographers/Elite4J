/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import elite.dangerous.core.Event;
import elite.dangerous.model.statistics.*;
import elite.dangerous.model.statistics.Passengers;

@EliteObject 
public class Statistics extends Event
{
    private BankAccount         bankAccount;

    private Combat              combat;

    private Crime               crime;

    private Smuggling           smuggling;

    private Trading             trading;

    private Mining              mining;

    private Exploration         exploration;

    private Passengers          passengers;

    private SearchAndRescue     searchAndRescue;

    private ThargoidEncounters  thargoidEncounters;

    private Crafting            crafting;

    private Crew                crew;

    private Multicrew           multicrew;

    private MaterialTraderStats materialTraderStats;

    private CQC                 closeQuartersCombat;

    private FleetCarrier        fleetCarrier;

    private Exobiology          exobiology;
}
