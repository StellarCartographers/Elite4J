package elite.dangerous.model.rank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EliteObject;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EliteObject
public class RankReward<T>
{
    private RankInfo.RewardType type;
    private T                   reward;
}
