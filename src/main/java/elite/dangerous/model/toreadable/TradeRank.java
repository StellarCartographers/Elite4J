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
public class TradeRank
{
    private static final String[] LOCALISED_NAMES = {"Penniless", "Mostly Pennliess", "Peddler", "Dealer", "Merchant", "Broker", "Entrepreneur", "Tycoon", "Elite"};

    /**
     * Gets the readable name.
     *
     * @param  rank
     *                  the rank
     * 
     * @return      the readable name
     */
    public static String getReadableName(int rank)
    {
        return LOCALISED_NAMES[rank];
    }

    /**
     * Gets the rank.
     *
     * @param  rankName
     *                      the rank name
     * 
     * @return          the rank
     */
    public static int getRank(String rankName)
    {
        int rank = 0;
        for (int i = 0; i < LOCALISED_NAMES.length; i++)
        {
            if (LOCALISED_NAMES[i].equals(rankName))
            {
                rank = i;
            }
        }
        return rank;
    }
}
