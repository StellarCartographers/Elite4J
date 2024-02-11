/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.combat;

import java.util.List;

import elite.dangerous.model.Reward;

public interface IBountyDefault extends IBounty
{
    public long totalReward();

    public List<Reward> rewards();

    public int sharedWithOthers();
}
