package elite.dangerous.journal.events.combat;

import java.util.List;

import elite.dangerous.model.Reward;
import lombok.EliteObject;

@EliteObject
public class BountyDefault extends Bounty
{
    private long         totalReward;

    private List<Reward> rewards;

    private int          sharedWithOthers;

}
