/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.toreadable;

import lombok.*;

@EliteObject
public class ReputationName
{
    /**
     * Gets the readable name.
     *
     * @param  reputation
     *                        the reputation
     * 
     * @return            the readable name
     */
    public static String getReadableName(Double reputation)
    {
        String repName = "Neutral";
        if (reputation >= 90)
        {
            repName = "Allied";
        } else if (reputation >= 35)
        {
            repName = "Friendly";
        } else if (reputation >= 4)
        {
            repName = "Cordinal";
        } else if (reputation <= -90)
        {
            repName = "Hostile";
        } else if (reputation <= -35)
        {
            repName = "Unfriendly";
        }
        return repName;
    }
}
