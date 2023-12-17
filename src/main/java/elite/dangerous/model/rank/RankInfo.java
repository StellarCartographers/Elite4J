package elite.dangerous.model.rank;

public interface RankInfo
{
    long getExperienceRequired();

    default String getExperienceRequiredAsString()
    {
        return String.valueOf(getExperienceRequired());
    }

    public enum RewardType
    {
        COSMETIC,
        ENGINEER_INVITE,
        SYSTEM_PERMIT,
        SHIP_UNLOCK;
    }
}
