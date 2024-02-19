/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
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
