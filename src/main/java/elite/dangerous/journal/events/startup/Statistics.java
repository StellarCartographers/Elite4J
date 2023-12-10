package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.statistics.BankAccount;
import elite.dangerous.model.statistics.CQC;
import elite.dangerous.model.statistics.Combat;
import elite.dangerous.model.statistics.Crafting;
import elite.dangerous.model.statistics.Crew;
import elite.dangerous.model.statistics.Crime;
import elite.dangerous.model.statistics.Exobiology;
import elite.dangerous.model.statistics.Exploration;
import elite.dangerous.model.statistics.FleetCarrier;
import elite.dangerous.model.statistics.MaterialTraderStats;
import elite.dangerous.model.statistics.Mining;
import elite.dangerous.model.statistics.Multicrew;
import elite.dangerous.model.statistics.Passengers;
import elite.dangerous.model.statistics.SearchAndRescue;
import elite.dangerous.model.statistics.Smuggling;
import elite.dangerous.model.statistics.ThargoidEncounters;
import elite.dangerous.model.statistics.Trading;
import lombok.EliteObject;

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
