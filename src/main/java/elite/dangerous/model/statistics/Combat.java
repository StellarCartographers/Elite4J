/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.statistics;

import lombok.*;

@EliteCreator
@EliteObject
public class Combat
{
    private long bountiesClaimed;
    private long bountyHuntingProfit;
    private long combatBonds;
    private long combatBondProfits;
    private long assassinations;
    private long assassinationProfits;
    private long highestSingleReward;
    private long skimmersKilled;
    private long onFootCombatBonds;
    private long onFootCombatBondsProfits;
    private long onFootVehiclesDestroyed;
    private long onFootShipsDestroyed;
    private long dropshipsTaken;
    private long dropshipsBooked;
    private long dropshipsCancelled;
    private long conflictZoneHigh;
    private long conflictZoneMedium;
    private long conflictZoneLow;
    private long conflictZoneTotal;
    private long conflictZoneHighWins;
    private long conflictZoneMediumWins;
    private long conflictZoneLowWins;
    private long conflictZoneTotalWins;
    private long settlementDefended;
    private long settlementConquered;
    private long onFootSkimmersKilled;
    private long onFootScavsKilled;
}
