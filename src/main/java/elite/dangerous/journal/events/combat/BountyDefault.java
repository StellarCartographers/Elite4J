package elite.dangerous.journal.events.combat;

import java.util.List;

public class BountyDefault extends Bounty
{

    public long totalReward;

    public List<Reward> rewards;

    public int sharedWithOthers;

    public static class Reward
    {

        public String faction;

        public long reward;
    }

}
