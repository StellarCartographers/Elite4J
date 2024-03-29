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
public class Crafting
{
    private long countOfUsedEngineers;
    private long recipesGenerated;
    private long recipesGeneratedRank1;
    private long recipesGeneratedRank2;
    private long recipesGeneratedRank3;
    private long recipesGeneratedRank4;
    private long recipesGeneratedRank5;
    private long suitModsApplied;
    private long weaponModsApplied;
    private long suitsUpgraded;
    private long weaponsUpgraded;
    private long suitsUpgradedFull;
    private long weaponsUpgradedFull;
    private long suitModsAppliedFull;
    private long weaponModsAppliedFull;
}
