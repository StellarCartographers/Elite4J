package elite.dangerous.journal.events.startup;

import elite.dangerous.journal.Event;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @return 
 */
@Getter
@Accessors(fluent = true)
public class Statistics extends Event
{

    private BankAccount bankAccount = new BankAccount();

    private Combat combat = new Combat();

    private Crime crime = new Crime();

    private Smuggling smuggling = new Smuggling();

    private Trading trading = new Trading();

    private Mining mining = new Mining();

    private Exploration exploration = new Exploration();

    private Passengers passengers = new Passengers();

    private SearchAndRescue searchAndRescue = new SearchAndRescue();

    private ThargoidEncounters thargoidEncounters = new ThargoidEncounters();

    private Crafting crafting = new Crafting();

    private Crew crew = new Crew();

    private Multicrew multicrew = new Multicrew();

    private MaterialTraderStats materialTraderStats = new MaterialTraderStats();

    private CQC closeQuartersCombat = new CQC();

    private FleetCarrier fleetCarrier = new FleetCarrier();

    private Exobiology exobiology = new Exobiology();

    public static class BankAccount
    {

        public long currentWealth = 0L;

        public long spentOnShips = 0L;

        public long spentOnOutfitting = 0L;

        public long spentOnRepairs = 0L;

        public long spentOnFuel = 0L;

        public long spentOnAmmoConsumables = 0L;

        public long insuranceClaims = 0L;

        public long spentOnInsurance = 0L;

        public long ownedShipCount = 0L;

        public long spentOnSuits = 0L;

        public long spentOnWeapons = 0L;

        public long spentOnSuitConsumables = 0L;

        public long suitsOwned = 0L;

        public long weaponsOwned = 0L;

        public long spentOnPremiumStock = 0L;

        public long premiumStockBought = 0L;
    }

    public static class Combat
    {

        public long bountiesClaimed = 0L;

        public long bountyHuntingProfit = 0L;

        public long combatBonds = 0L;

        public long combatBondProfits = 0L;

        public long assassinations = 0L;

        public long assassinationProfits = 0L;

        public long highestSingleReward = 0L;

        public long skimmersKilled = 0L;

        public long onFootCombatBonds = 0L;

        public long onFootCombatBondsProfits = 0L;

        public long onFootVehiclesDestroyed = 0L;

        public long onFootShipsDestroyed = 0L;

        public long dropshipsTaken = 0L;

        public long dropshipsBooked = 0L;

        public long dropshipsCancelled = 0L;

        public long conflictZoneHigh = 0L;

        public long conflictZoneMedium = 0L;

        public long conflictZoneLow = 0L;

        public long conflictZoneTotal = 0L;

        public long conflictZoneHighWins = 0L;

        public long conflictZoneMediumWins = 0L;

        public long conflictZoneLowWins = 0L;

        public long conflictZoneTotalWins = 0L;

        public long settlementDefended = 0L;

        public long settlementConquered = 0L;

        public long onFootSkimmersKilled = 0L;

        public long onFootScavsKilled = 0L;
    }

    public static class Crime
    {

        public long notoriety = 0L;

        public long fines = 0L;

        public long totalFines = 0L;

        public long bountiesReceived = 0L;

        public long totalBounties = 0L;

        public long highestBounty = 0L;

        public long malwareUploaded = 0L;

        public long settlementsStateShutdown = 0L;

        public long productionSabotage = 0L;

        public long productionTheft = 0L;

        public long totalMurders = 0L;

        public long citizensMurdered = 0L;

        public long omnipolMurdered = 0L;

        public long guardsMurdered = 0L;

        public long dataStolen = 0L;

        public long goodsStolen = 0L;

        public long sampleStolen = 0L;

        public long totalStolen = 0L;

        public long turretsDestroyed = 0L;

        public long turretsOverloaded = 0L;

        public long turretsTotal = 0L;

        public long valueStolenStateChange = 0L;

        public long profilesCloned = 0L;
    }

    public static class Smuggling
    {

        public long blackMarketsTradedWith = 0L;

        public long blackMarketsProfits = 0L;

        public long resourcesSmuggled = 0L;

        public long averageProfit = 0L;

        public long highestSingleTransaction = 0L;
    }

    public static class Trading
    {

        public long marketProfits = 0L;

        public long averageProfit = 0L;

        public long marketsTradedWith = 0L;

        public long resourcesTraded = 0L;

        public long highestSingleTransaction = 0L;
    }

    public static class Mining
    {

        public long miningProfits = 0L;

        public long quantityMined = 0L;

        public long materialsCollected = 0L;
    }

    public static class Exploration
    {

        public long systemsVisited = 0L;

        public long explorationProfits = 0L;

        public long planetsScannedToLevel2 = 0L;

        public long planetsScannedToLevel3 = 0L;

        public long efficientScans = 0L;

        public long highestPayout = 0L;

        public long totalHyperspaceDistance = 0L;

        public long totalHyperspaceJumps = 0L;

        public double greatestDistanceFromStart = 0L;

        public long timePlayed = 0L;

        public long onFootDistanceTravelled = 0L;

        public long shuttleJourneys = 0L;

        public double shuttleDistanceTravelled = 0L;

        public long spentOnShuttles = 0L;

        public long firstFootfalls = 0L;

        public long planetFootfalls = 0L;

        public long settlementsVisited = 0L;
    }

    public static class Passengers
    {

        public long passengersMissionsAccepted = 0L;

        public long passengersMissionsBulk = 0L;

        public long passengersMissionsVIP = 0L;

        public long passengersMissionsDelivered = 0L;

        public long passengersMissionsEjected = 0L;
    }

    public static class SearchAndRescue
    {

        public long searchRescueTraded = 0L;

        public long searchRescueProfit = 0L;

        public long searchRescueCount = 0L;

        public long salvageLegalPOI = 0L;

        public long salvageLegalSettlements = 0L;

        public long salvageIllegalPOI = 0L;

        public long salvageIllegalSettlements = 0L;

        public long maglocksOpened = 0L;

        public long panelsOpened = 0L;

        public long settlementsStateFireOut = 0L;

        public long settlementsStateReboot = 0L;
    }

    public static class ThargoidEncounters
    {

        public long totalEncounters = 0L;

        public long scoutCount = 0L;

        public String lastSystemTotal = "";

        public String TotalLastTimestamp = "";

        public String TotalLastShip = "";
    }

    public static class Crafting
    {

        public long countOfUsedEngineers = 0L;

        public long recipesGenerated = 0L;

        public long recipesGeneratedRank1 = 0L;

        public long recipesGeneratedRank2 = 0L;

        public long recipesGeneratedRank3 = 0L;

        public long recipesGeneratedRank4 = 0L;

        public long recipesGeneratedRank5 = 0L;

        public long suitModsApplied = 0L;

        public long weaponModsApplied = 0L;

        public long suitsUpgraded = 0L;

        public long weaponsUpgraded = 0L;

        public long suitsUpgradedFull = 0L;

        public long weaponsUpgradedFull = 0L;

        public long suitModsAppliedFull = 0L;

        public long weaponModsAppliedFull = 0L;
    }

    public static class Crew
    {

        public long crewTotalWages = 0L;

        public long crewHired = 0L;

        public long crewFired = 0L;

        public long crewDied = 0L;
    }

    public static class Multicrew
    {

        public long timeTotal = 0L;

        public long gunnerTimeTotal = 0L;

        public long fighterTimeTotal = 0L;

        public long creditsTotal = 0L;

        public long finesTotal = 0L;
    }

    public static class MaterialTraderStats
    {

        public long tradesCompleted = 0L;

        public long materialsTraded = 0L;

        public long encodedMaterialsTraded = 0L;

        public long rawMaterialsTraded = 0L;

        public long grade1MaterialsTraded = 0L;

        public long grade2MaterialsTraded = 0L;

        public long grade3MaterialsTraded = 0L;

        public long grade4MaterialsTraded = 0L;

        public long grade5MaterialsTraded = 0L;

        public long assetsTradedIn = 0L;

        public long assetsTradedOut = 0L;
    }

    public static class FleetCarrier
    {

        public long exportTotal = 0L;

        public long importTotal = 0L;

        public long tradeprofitTotal = 0L;

        public long tradespendTotal = 0L;

        public long stolenprofitTotal = 0L;

        public long stolenspendTotal = 0L;

        public double distanceTravelled = 0L;

        public long totalJumps = 0L;

        public long shipyardSold = 0L;

        public long shipyardProfit = 0L;

        public long outfittingSold = 0L;

        public long outfittingProfit = 0L;

        public long rearmTotal = 0L;

        public long refuelTotal = 0L;

        public long refuelProfit = 0L;

        public long repairsTotal = 0L;

        public long vouchersRedeemed = 0L;

        public long vouchersProfit = 0L;
    }

    public static class Exobiology
    {

        public long organicGenusEncountered = 0L;

        public long organicSpeciesEncountered = 0L;

        public long organicVariantEncountered = 0L;

        public long organicDataProfits = 0L;

        public long organicData = 0L;

        public long firstLoggedProfits = 0L;

        public long firstLogged = 0L;

        public long organicSystems = 0L;

        public long organicPlanets = 0L;

        public long organicGenus = 0L;

        public long organicSpecies = 0L;
    }

    public static class CQC
    {

        public long creditsEarned = 0L;

        public long timePlayed = 0L;

        public double kd = 0L;

        public long kills = 0L;

        public double wl = 0L;
    }

}
