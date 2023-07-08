/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.startup;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * The Class Statistics.
 */
@Getter
@Accessors(fluent = true)
@SuperBuilder
public class Statistics extends Event 
{

    @SerializedName("Bank_Account")
    @Builder.Default
    private BankAccount         bankAccount         = new BankAccount();
    @SerializedName("Combat")
    @Builder.Default
    private Combat              combat              = new Combat();
    @SerializedName("Crime")
    @Builder.Default
    private Crime               crime               = new Crime();
    @SerializedName("Smuggling")
    @Builder.Default
    private Smuggling           smuggling           = new Smuggling();
    @SerializedName("Trading")
    @Builder.Default
    private Trading             trading             = new Trading();
    @SerializedName("Mining")
    @Builder.Default
    private Mining              mining              = new Mining();
    @SerializedName("Exploration")
    @Builder.Default
    private Exploration         exploration         = new Exploration();
    @SerializedName("Passengers")
    @Builder.Default
    private Passengers          passengers          = new Passengers();
    @SerializedName("Search_And_Rescue")
    @Builder.Default
    private SearchAndRescue     searchAndRescue     = new SearchAndRescue();
    @SerializedName("TG_ENCOUNTERS")
    @Builder.Default
    private ThargoidEncounters  thargoidEncounters  = new ThargoidEncounters();
    @SerializedName("Crafting")
    @Builder.Default
    private Crafting            crafting            = new Crafting();
    @SerializedName("Crew")
    @Builder.Default
    private Crew                crew                = new Crew();
    @SerializedName("Multicrew")
    @Builder.Default
    private Multicrew           multicrew           = new Multicrew();
    @SerializedName("Material_Trader_Stats")
    @Builder.Default
    private MaterialTraderStats materialTraderStats = new MaterialTraderStats();
    @SerializedName("CQC")
    @Builder.Default
    private CQC                 closeQuartersCombat = new CQC();
    @SerializedName("FLEETCARRIER")
    @Builder.Default
    private FleetCarrier        fleetCarrier        = new FleetCarrier();
    @SerializedName("Exobiology")
    @Builder.Default
    private Exobiology          exobiology          = new Exobiology();

    /**
     * The Class BankAccount.
     */
    public static class BankAccount
    {

        /**
         * The current wealth.
         */
        @SerializedName("Current_Wealth")
        public long currentWealth          = 0L;
        /**
         * The spent on ships.
         */
        @SerializedName("Spent_On_Ships")
        public long spentOnShips           = 0L;
        /**
         * The spent on outfitting.
         */
        @SerializedName("Spent_On_Outfitting")
        public long spentOnOutfitting      = 0L;
        /**
         * The spent on repairs.
         */
        @SerializedName("Spent_On_Repairs")
        public long spentOnRepairs         = 0L;
        /**
         * The spent on fuel.
         */
        @SerializedName("Spent_On_Fuel")
        public long spentOnFuel            = 0L;
        /**
         * The spent on ammo consumables.
         */
        @SerializedName("Spent_On_Ammo_Consumables")
        public long spentOnAmmoConsumables = 0L;
        /**
         * The insurance claims.
         */
        @SerializedName("Insurance_Claims")
        public long insuranceClaims        = 0L;
        /**
         * The spent on insurance.
         */
        @SerializedName("Spent_On_Insurance")
        public long spentOnInsurance       = 0L;
        /**
         * The owned ship count.
         */
        @SerializedName("Owned_Ship_Count")
        public long ownedShipCount         = 0L;
        /**
         * The spent on suits.
         */
        @SerializedName("Spent_On_Suits")
        public long spentOnSuits           = 0L;
        /**
         * The spent on weapons.
         */
        @SerializedName("Spent_On_Weapons")
        public long spentOnWeapons         = 0L;
        /**
         * The spent on suit consumables.
         */
        @SerializedName("Spent_On_Suit_Consumables")
        public long spentOnSuitConsumables = 0L;
        /**
         * The suits owned.
         */
        @SerializedName("Suits_Owned")
        public long suitsOwned             = 0L;
        /**
         * The weapons owned.
         */
        @SerializedName("Weapons_Owned")
        public long weaponsOwned           = 0L;
        /**
         * The spent on premium stock.
         */
        @SerializedName("Spent_On_Premium_Stock")
        public long spentOnPremiumStock    = 0L;
        /**
         * The premium stock bought.
         */
        @SerializedName("Premium_Stock_Bought")
        public long premiumStockBought     = 0L;
    }

    /**
     * The Class Combat.
     */
    public static class Combat
    {

        /**
         * The bounties claimed.
         */
        @SerializedName("Bounties_Claimed")
        public long bountiesClaimed          = 0L;
        /**
         * The bounty hunting profit.
         */
        @SerializedName("Bounty_Hunting_Profit")
        public long bountyHuntingProfit      = 0L;
        /**
         * The combat bonds.
         */
        @SerializedName("Combat_Bonds")
        public long combatBonds              = 0L;
        /**
         * The combat bond profits.
         */
        @SerializedName("Combat_Bond_Profits")
        public long combatBondProfits        = 0L;
        /**
         * The assassinations.
         */
        @SerializedName("Assassinations")
        public long assassinations           = 0L;
        /**
         * The assassination profits.
         */
        @SerializedName("Assassination_Profits")
        public long assassinationProfits     = 0L;
        /**
         * The highest single reward.
         */
        @SerializedName("Highest_Single_Reward")
        public long highestSingleReward      = 0L;
        /**
         * The skimmers killed.
         */
        @SerializedName("Skimmers_Killed")
        public long skimmersKilled           = 0L;
        /**
         * The on foot combat bonds.
         */
        @SerializedName("OnFoot_Combat_Bonds")
        public long onFootCombatBonds        = 0L;
        /**
         * The on foot combat bonds profits.
         */
        @SerializedName("OnFoot_Combat_Bonds_Profits")
        public long onFootCombatBondsProfits = 0L;
        /**
         * The on foot vehicles destroyed.
         */
        @SerializedName("OnFoot_Vehicles_Destroyed")
        public long onFootVehiclesDestroyed  = 0L;
        /**
         * The on foot ships destroyed.
         */
        @SerializedName("OnFoot_Ships_Destroyed")
        public long onFootShipsDestroyed     = 0L;
        /**
         * The dropships taken.
         */
        @SerializedName("Dropships_Taken")
        public long dropshipsTaken           = 0L;
        /**
         * The dropships booked.
         */
        @SerializedName("Dropships_Booked")
        public long dropshipsBooked          = 0L;
        /**
         * The dropships cancelled.
         */
        @SerializedName("Dropships_Cancelled")
        public long dropshipsCancelled       = 0L;
        /**
         * The conflict zone high.
         */
        @SerializedName("ConflictZone_High")
        public long conflictZoneHigh         = 0L;
        /**
         * The conflict zone medium.
         */
        @SerializedName("ConflictZone_Medium")
        public long conflictZoneMedium       = 0L;
        /**
         * The conflict zone low.
         */
        @SerializedName("ConflictZone_Low")
        public long conflictZoneLow          = 0L;
        /**
         * The conflict zone total.
         */
        @SerializedName("ConflictZone_Total")
        public long conflictZoneTotal        = 0L;
        /**
         * The conflict zone high wins.
         */
        @SerializedName("ConflictZone_High_Wins")
        public long conflictZoneHighWins     = 0L;
        /**
         * The conflict zone medium wins.
         */
        @SerializedName("ConflictZone_Medium_Wins")
        public long conflictZoneMediumWins   = 0L;
        /**
         * The conflict zone low wins.
         */
        @SerializedName("ConflictZone_Low_Wins")
        public long conflictZoneLowWins      = 0L;
        /**
         * The conflict zone total wins.
         */
        @SerializedName("ConflictZone_Total_Wins")
        public long conflictZoneTotalWins    = 0L;
        /**
         * The settlement defended.
         */
        @SerializedName("Settlement_Defended")
        public long settlementDefended       = 0L;
        /**
         * The settlement conquered.
         */
        @SerializedName("Settlement_Conquered")
        public long settlementConquered      = 0L;
        /**
         * The on foot skimmers killed.
         */
        @SerializedName("OnFoot_Skimmers_Killed")
        public long onFootSkimmersKilled     = 0L;
        /**
         * The on foot scavs killed.
         */
        @SerializedName("OnFoot_Scavs_Killed")
        public long onFootScavsKilled        = 0L;
    }

    /**
     * The Class Crime.
     */
    public static class Crime
    {

        /**
         * The notoriety.
         */
        @SerializedName("Notoriety")
        public long notoriety                = 0L;
        /**
         * The fines.
         */
        @SerializedName("Fines")
        public long fines                    = 0L;
        /**
         * The total fines.
         */
        @SerializedName("Total_Fines")
        public long totalFines               = 0L;
        /**
         * The bounties received.
         */
        @SerializedName("Bounties_Received")
        public long bountiesReceived         = 0L;
        /**
         * The total bounties.
         */
        @SerializedName("Total_Bounties")
        public long totalBounties            = 0L;
        /**
         * The highest bounty.
         */
        @SerializedName("Highest_Bounty")
        public long highestBounty            = 0L;
        /**
         * The malware uploaded.
         */
        @SerializedName("Malware_Uploaded")
        public long malwareUploaded          = 0L;
        /**
         * The settlements state shutdown.
         */
        @SerializedName("Settlements_State_Shutdown")
        public long settlementsStateShutdown = 0L;
        /**
         * The production sabotage.
         */
        @SerializedName("Production_Sabotage")
        public long productionSabotage       = 0L;
        /**
         * The production theft.
         */
        @SerializedName("Production_Theft")
        public long productionTheft          = 0L;
        /**
         * The total murders.
         */
        @SerializedName("Total_Murders")
        public long totalMurders             = 0L;
        /**
         * The citizens murdered.
         */
        @SerializedName("Citizens_Murdered")
        public long citizensMurdered         = 0L;
        /**
         * The omnipol murdered.
         */
        @SerializedName("Omnipol_Murdered")
        public long omnipolMurdered          = 0L;
        /**
         * The guards murdered.
         */
        @SerializedName("Guards_Murdered")
        public long guardsMurdered           = 0L;
        /**
         * The data stolen.
         */
        @SerializedName("Data_Stolen")
        public long dataStolen               = 0L;
        /**
         * The goods stolen.
         */
        @SerializedName("Goods_Stolen")
        public long goodsStolen              = 0L;
        /**
         * The sample stolen.
         */
        @SerializedName("Sample_Stolen")
        public long sampleStolen             = 0L;
        /**
         * The total stolen.
         */
        @SerializedName("Total_Stolen")
        public long totalStolen              = 0L;
        /**
         * The turrets destroyed.
         */
        @SerializedName("Turrets_Destroyed")
        public long turretsDestroyed         = 0L;
        /**
         * The turrets overloaded.
         */
        @SerializedName("Turrets_Overloaded")
        public long turretsOverloaded        = 0L;
        /**
         * The turrets total.
         */
        @SerializedName("Turrets_Total")
        public long turretsTotal             = 0L;
        /**
         * The value stolen state change.
         */
        @SerializedName("Value_Stolen_StateChange")
        public long valueStolenStateChange   = 0L;
        /**
         * The profiles cloned.
         */
        @SerializedName("Profiles_Cloned")
        public long profilesCloned           = 0L;
    }

    /**
     * The Class Smuggling.
     */
    public static class Smuggling
    {

        /**
         * The black markets traded with.
         */
        @SerializedName("Black_Markets_Traded_With")
        public long blackMarketsTradedWith   = 0L;
        /**
         * The black markets profits.
         */
        @SerializedName("Black_Markets_Profits")
        public long blackMarketsProfits      = 0L;
        /**
         * The resources smuggled.
         */
        @SerializedName("Resources_Smuggled")
        public long resourcesSmuggled        = 0L;
        /**
         * The average profit.
         */
        @SerializedName("Average_Profit")
        public long averageProfit            = 0L;
        /**
         * The highest single transaction.
         */
        @SerializedName("Highest_Single_Transaction")
        public long highestSingleTransaction = 0L;
    }

    /**
     * The Class Trading.
     */
    public static class Trading
    {

        /**
         * The market profits.
         */
        @SerializedName("Market_Profits")
        public long marketProfits            = 0L;
        /**
         * The average profit.
         */
        @SerializedName("Average_Profit")
        public long averageProfit            = 0L;
        /**
         * The markets traded with.
         */
        @SerializedName("Markets_Traded_With")
        public long marketsTradedWith        = 0L;
        /**
         * The resources traded.
         */
        @SerializedName("Resources_Traded")
        public long resourcesTraded          = 0L;
        /**
         * The highest single transaction.
         */
        @SerializedName("Highest_Single_Transaction")
        public long highestSingleTransaction = 0L;
    }

    /**
     * The Class Mining.
     */
    public static class Mining
    {

        /**
         * The mining profits.
         */
        @SerializedName("Mining_Profits")
        public long miningProfits      = 0L;
        /**
         * The quantity mined.
         */
        @SerializedName("Quantity_Mined")
        public long quantityMined      = 0L;
        /**
         * The materials collected.
         */
        @SerializedName("Materials_Collected")
        public long materialsCollected = 0L;
    }

    /**
     * The Class Exploration.
     */
    public static class Exploration
    {

        /**
         * The systems visited.
         */
        @SerializedName("Systems_Visited")
        public long   systemsVisited            = 0L;
        /**
         * The exploration profits.
         */
        @SerializedName("Exploration_Profits")
        public long   explorationProfits        = 0L;
        /**
         * The planets scanned to level 2.
         */
        @SerializedName("Planets_Scanned_To_Level_2")
        public long   planetsScannedToLevel2    = 0L;
        /**
         * The planets scanned to level 3.
         */
        @SerializedName("Planets_Scanned_To_Level_3")
        public long   planetsScannedToLevel3    = 0L;
        /**
         * The efficient scans.
         */
        @SerializedName("Efficient_Scans")
        public long   efficientScans            = 0L;
        /**
         * The highest payout.
         */
        @SerializedName("Highest_Payout")
        public long   highestPayout             = 0L;
        /**
         * The total hyperspace distance.
         */
        @SerializedName("Total_Hyperspace_Distance")
        public long   totalHyperspaceDistance   = 0L;
        /**
         * The total hyperspace jumps.
         */
        @SerializedName("Total_Hyperspace_Jumps")
        public long   totalHyperspaceJumps      = 0L;
        /**
         * The greatest distance from start.
         */
        @SerializedName("Greatest_Distance_From_Start")
        public double greatestDistanceFromStart = 0L;
        /**
         * The time played.
         */
        @SerializedName("Time_Played")
        public long   timePlayed                = 0L;
        /**
         * The on foot distance travelled.
         */
        @SerializedName("OnFoot_Distance_Travelled")
        public long   onFootDistanceTravelled   = 0L;
        /**
         * The shuttle journeys.
         */
        @SerializedName("Shuttle_Journeys")
        public long   shuttleJourneys           = 0L;
        /**
         * The shuttle distance travelled.
         */
        @SerializedName("Shuttle_Distance_Travelled")
        public double shuttleDistanceTravelled  = 0L;
        /**
         * The spent on shuttles.
         */
        @SerializedName("Spent_On_Shuttles")
        public long   spentOnShuttles           = 0L;
        /**
         * The first footfalls.
         */
        @SerializedName("First_Footfalls")
        public long   firstFootfalls            = 0L;
        /**
         * The planet footfalls.
         */
        @SerializedName("Planet_Footfalls")
        public long   planetFootfalls           = 0L;
        /**
         * The settlements visited.
         */
        @SerializedName("Settlements_Visited")
        public long   settlementsVisited        = 0L;
    }

    /**
     * The Class Passengers.
     */
    public static class Passengers
    {

        /**
         * The passengers missions accepted.
         */
        @SerializedName("Passengers_Missions_Accepted")
        public long passengersMissionsAccepted  = 0L;
        /**
         * The passengers missions bulk.
         */
        @SerializedName("Passengers_Missions_Bulk")
        public long passengersMissionsBulk      = 0L;
        /**
         * The passengers missions VIP.
         */
        @SerializedName("Passengers_Missions_VIP")
        public long passengersMissionsVIP       = 0L;
        /**
         * The passengers missions delivered.
         */
        @SerializedName("Passengers_Missions_Delivered")
        public long passengersMissionsDelivered = 0L;
        /**
         * The passengers missions ejected.
         */
        @SerializedName("Passengers_Missions_Ejected")
        public long passengersMissionsEjected   = 0L;
    }

    /**
     * The Class SearchAndRescue.
     */
    public static class SearchAndRescue
    {

        /**
         * The search rescue traded.
         */
        @SerializedName("SearchRescue_Traded")
        public long searchRescueTraded        = 0L;
        /**
         * The search rescue profit.
         */
        @SerializedName("SearchRescue_Profit")
        public long searchRescueProfit        = 0L;
        /**
         * The search rescue count.
         */
        @SerializedName("SearchRescue_Count")
        public long searchRescueCount         = 0L;
        /**
         * The salvage legal POI.
         */
        @SerializedName("Salvage_Legal_POI")
        public long salvageLegalPOI           = 0L;
        /**
         * The salvage legal settlements.
         */
        @SerializedName("Salvage_Legal_Settlements")
        public long salvageLegalSettlements   = 0L;
        /**
         * The salvage illegal POI.
         */
        @SerializedName("Salvage_Illegal_POI")
        public long salvageIllegalPOI         = 0L;
        /**
         * The salvage illegal settlements.
         */
        @SerializedName("Salvage_Illegal_Settlements")
        public long salvageIllegalSettlements = 0L;
        /**
         * The maglocks opened.
         */
        @SerializedName("Maglocks_Opened")
        public long maglocksOpened            = 0L;
        /**
         * The panels opened.
         */
        @SerializedName("Panels_Opened")
        public long panelsOpened              = 0L;
        /**
         * The settlements state fire out.
         */
        @SerializedName("Settlements_State_FireOut")
        public long settlementsStateFireOut   = 0L;
        /**
         * The settlements state reboot.
         */
        @SerializedName("Settlements_State_Reboot")
        public long settlementsStateReboot    = 0L;
    }

    /**
     * The Class ThargoidEncounters.
     */
    public static class ThargoidEncounters
    {

        /**
         * The total encounters.
         */
        @SerializedName("TG_ENCOUNTER_TOTAL")
        public long   totalEncounters    = 0L;
        /**
         * The scout count.
         */
        @SerializedName("TG_SCOUT_COUNT")
        public long   scoutCount         = 0L;
        /**
         * The last system total.
         */
        @SerializedName("TG_ENCOUNTER_TOTAL_LAST_SYSTEM")
        public String lastSystemTotal    = "";
        /**
         * The Total last timestamp.
         */
        @SerializedName("TG_ENCOUNTER_TOTAL_LAST_TIMESTAMP")
        public String TotalLastTimestamp = "";
        /**
         * The Total last ship.
         */
        @SerializedName("TG_ENCOUNTER_TOTAL_LAST_SHIP")
        public String TotalLastShip      = "";
    }

    /**
     * The Class Crafting.
     */
    public static class Crafting
    {

        /**
         * The count of used engineers.
         */
        @SerializedName("Count_Of_Used_Engineers")
        public long countOfUsedEngineers  = 0L;
        /**
         * The recipes generated.
         */
        @SerializedName("Recipes_Generated")
        public long recipesGenerated      = 0L;
        /**
         * The recipes generated rank 1.
         */
        @SerializedName("Recipes_Generated_Rank_1")
        public long recipesGeneratedRank1 = 0L;
        /**
         * The recipes generated rank 2.
         */
        @SerializedName("Recipes_Generated_Rank_2")
        public long recipesGeneratedRank2 = 0L;
        /**
         * The recipes generated rank 3.
         */
        @SerializedName("Recipes_Generated_Rank_3")
        public long recipesGeneratedRank3 = 0L;
        /**
         * The recipes generated rank 4.
         */
        @SerializedName("Recipes_Generated_Rank_4")
        public long recipesGeneratedRank4 = 0L;
        /**
         * The recipes generated rank 5.
         */
        @SerializedName("Recipes_Generated_Rank_5")
        public long recipesGeneratedRank5 = 0L;
        /**
         * The suit mods applied.
         */
        @SerializedName("Suit_Mods_Applied")
        public long suitModsApplied       = 0L;
        /**
         * The weapon mods applied.
         */
        @SerializedName("Weapon_Mods_Applied")
        public long weaponModsApplied     = 0L;
        /**
         * The suits upgraded.
         */
        @SerializedName("Suits_Upgraded")
        public long suitsUpgraded         = 0L;
        /**
         * The weapons upgraded.
         */
        @SerializedName("Weapons_Upgraded")
        public long weaponsUpgraded       = 0L;
        /**
         * The suits upgraded full.
         */
        @SerializedName("Suits_Upgraded_Full")
        public long suitsUpgradedFull     = 0L;
        /**
         * The weapons upgraded full.
         */
        @SerializedName("Weapons_Upgraded_Full")
        public long weaponsUpgradedFull   = 0L;
        /**
         * The suit mods applied full.
         */
        @SerializedName("Suit_Mods_Applied_Full")
        public long suitModsAppliedFull   = 0L;
        /**
         * The weapon mods applied full.
         */
        @SerializedName("Weapon_Mods_Applied_Full")
        public long weaponModsAppliedFull = 0L;
    }

    /**
     * The Class Crew.
     */
    public static class Crew
    {

        /**
         * The crew total wages.
         */
        @SerializedName("NpcCrew_TotalWages")
        public long crewTotalWages = 0L;
        /**
         * The crew hired.
         */
        @SerializedName("NpcCrew_Hired")
        public long crewHired      = 0L;
        /**
         * The crew fired.
         */
        @SerializedName("NpcCrew_Fired")
        public long crewFired      = 0L;
        /**
         * The crew died.
         */
        @SerializedName("NpcCrew_Died")
        public long crewDied       = 0L;
    }

    /**
     * The Class Multicrew.
     */
    public static class Multicrew
    {

        /**
         * The time total.
         */
        @SerializedName("Multicrew_Time_Total")
        public long timeTotal        = 0L;
        /**
         * The gunner time total.
         */
        @SerializedName("Multicrew_Gunner_Time_Total")
        public long gunnerTimeTotal  = 0L;
        /**
         * The fighter time total.
         */
        @SerializedName("Multicrew_Fighter_Time_Total")
        public long fighterTimeTotal = 0L;
        /**
         * The credits total.
         */
        @SerializedName("Multicrew_Credits_Total")
        public long creditsTotal     = 0L;
        /**
         * The fines total.
         */
        @SerializedName("Multicrew_Fines_Total")
        public long finesTotal       = 0L;
    }

    /**
     * The Class MaterialTraderStats.
     */
    public static class MaterialTraderStats
    {

        /**
         * The trades completed.
         */
        @SerializedName("Trades_Completed")
        public long tradesCompleted        = 0L;
        /**
         * The materials traded.
         */
        @SerializedName("Materials_Traded")
        public long materialsTraded        = 0L;
        /**
         * The encoded materials traded.
         */
        @SerializedName("Encoded_Materials_Traded")
        public long encodedMaterialsTraded = 0L;
        /**
         * The raw materials traded.
         */
        @SerializedName("Raw_Materials_Traded")
        public long rawMaterialsTraded     = 0L;
        /**
         * The grade 1 materials traded.
         */
        @SerializedName("Grade_1_Materials_Traded")
        public long grade1MaterialsTraded  = 0L;
        /**
         * The grade 2 materials traded.
         */
        @SerializedName("Grade_2_Materials_Traded")
        public long grade2MaterialsTraded  = 0L;
        /**
         * The grade 3 materials traded.
         */
        @SerializedName("Grade_3_Materials_Traded")
        public long grade3MaterialsTraded  = 0L;
        /**
         * The grade 4 materials traded.
         */
        @SerializedName("Grade_4_Materials_Traded")
        public long grade4MaterialsTraded  = 0L;
        /**
         * The grade 5 materials traded.
         */
        @SerializedName("Grade_5_Materials_Traded")
        public long grade5MaterialsTraded  = 0L;
        /**
         * The assets traded in.
         */
        @SerializedName("Assets_Traded_In")
        public long assetsTradedIn         = 0L;
        /**
         * The assets traded out.
         */
        @SerializedName("Assets_Traded_Out")
        public long assetsTradedOut        = 0L;
    }

    /**
     * The Class FleetCarrier.
     */
    public static class FleetCarrier
    {

        /**
         * The export total.
         */
        @SerializedName("FLEETCARRIER_EXPORT_TOTAL")
        public long   exportTotal       = 0L;
        /**
         * The import total.
         */
        @SerializedName("FLEETCARRIER_IMPORT_TOTAL")
        public long   importTotal       = 0L;
        /**
         * The tradeprofit total.
         */
        @SerializedName("FLEETCARRIER_TRADEPROFIT_TOTAL")
        public long   tradeprofitTotal  = 0L;
        /**
         * The tradespend total.
         */
        @SerializedName("FLEETCARRIER_TRADESPEND_TOTAL")
        public long   tradespendTotal   = 0L;
        /**
         * The stolenprofit total.
         */
        @SerializedName("FLEETCARRIER_STOLENPROFIT_TOTAL")
        public long   stolenprofitTotal = 0L;
        /**
         * The stolenspend total.
         */
        @SerializedName("FLEETCARRIER_STOLENSPEND_TOTAL")
        public long   stolenspendTotal  = 0L;
        /**
         * The distance travelled.
         */
        @SerializedName("FLEETCARRIER_DISTANCE_TRAVELLED")
        public double distanceTravelled = 0L;
        /**
         * The total jumps.
         */
        @SerializedName("FLEETCARRIER_TOTAL_JUMPS")
        public long   totalJumps        = 0L;
        /**
         * The shipyard sold.
         */
        @SerializedName("FLEETCARRIER_SHIPYARD_SOLD")
        public long   shipyardSold      = 0L;
        /**
         * The shipyard profit.
         */
        @SerializedName("FLEETCARRIER_SHIPYARD_PROFIT")
        public long   shipyardProfit    = 0L;
        /**
         * The outfitting sold.
         */
        @SerializedName("FLEETCARRIER_OUTFITTING_SOLD")
        public long   outfittingSold    = 0L;
        /**
         * The outfitting profit.
         */
        @SerializedName("FLEETCARRIER_OUTFITTING_PROFIT")
        public long   outfittingProfit  = 0L;
        /**
         * The rearm total.
         */
        @SerializedName("FLEETCARRIER_REARM_TOTAL")
        public long   rearmTotal        = 0L;
        /**
         * The refuel total.
         */
        @SerializedName("FLEETCARRIER_REFUEL_TOTAL")
        public long   refuelTotal       = 0L;
        /**
         * The refuel profit.
         */
        @SerializedName("FLEETCARRIER_REFUEL_PROFIT")
        public long   refuelProfit      = 0L;
        /**
         * The repairs total.
         */
        @SerializedName("FLEETCARRIER_REPAIRS_TOTAL")
        public long   repairsTotal      = 0L;
        /**
         * The vouchers redeemed.
         */
        @SerializedName("FLEETCARRIER_VOUCHERS_REDEEMED")
        public long   vouchersRedeemed  = 0L;
        /**
         * The vouchers profit.
         */
        @SerializedName("FLEETCARRIER_VOUCHERS_PROFIT")
        public long   vouchersProfit    = 0L;
    }

    /**
     * The Class Exobiology.
     */
    public static class Exobiology
    {

        /**
         * The organic genus encountered.
         */
        @SerializedName("Organic_Genus_Encountered")
        public long organicGenusEncountered   = 0L;
        /**
         * The organic species encountered.
         */
        @SerializedName("Organic_Species_Encountered")
        public long organicSpeciesEncountered = 0L;
        /**
         * The organic variant encountered.
         */
        @SerializedName("Organic_Variant_Encountered")
        public long organicVariantEncountered = 0L;
        /**
         * The organic data profits.
         */
        @SerializedName("Organic_Data_Profits")
        public long organicDataProfits        = 0L;
        /**
         * The organic data.
         */
        @SerializedName("Organic_Data")
        public long organicData               = 0L;
        /**
         * The first logged profits.
         */
        @SerializedName("First_Logged_Profits")
        public long firstLoggedProfits        = 0L;
        /**
         * The first logged.
         */
        @SerializedName("First_Logged")
        public long firstLogged               = 0L;
        /**
         * The organic systems.
         */
        @SerializedName("Organic_Systems")
        public long organicSystems            = 0L;
        /**
         * The organic planets.
         */
        @SerializedName("Organic_Planets")
        public long organicPlanets            = 0L;
        /**
         * The organic genus.
         */
        @SerializedName("Organic_Genus")
        public long organicGenus              = 0L;
        /**
         * The organic species.
         */
        @SerializedName("Organic_Species")
        public long organicSpecies            = 0L;
    }

    /**
     * The Class CQC.
     */
    public static class CQC
    {

        /**
         * The credits earned.
         */
        @SerializedName("CQC_Credits_Earned")
        public long   creditsEarned = 0L;
        /**
         * The time played.
         */
        @SerializedName("CQC_Time_Played")
        public long   timePlayed    = 0L;
        /**
         * The kd.
         */
        @SerializedName("CQC_KD")
        public double kd            = 0L;
        /**
         * The kills.
         */
        @SerializedName("CQC_Kills")
        public long   kills         = 0L;
        /**
         * The wl.
         */
        @SerializedName("CQC_WL")
        public double wl            = 0L;
    }
}
