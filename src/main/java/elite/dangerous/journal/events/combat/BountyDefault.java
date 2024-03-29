/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.combat;

import lombok.*;

import java.util.List;

import elite.dangerous.journal.annotation.NonDefinedEvent;
import elite.dangerous.model.Reward;

@EliteObject 
@NonDefinedEvent
public class BountyDefault extends Bounty
{
    private long         totalReward;

    private List<Reward> rewards;

    private int          sharedWithOthers;

}
