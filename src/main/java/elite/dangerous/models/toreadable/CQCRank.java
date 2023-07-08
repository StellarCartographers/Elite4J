/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models.toreadable;

/**
 * The Class CQCRank.
 */
public class CQCRank {

	private static final String[] LOCALISED_NAMES = { "Helpless", "Mostly Helpless", "Amateur", "Semi Professional",
			"Professional", "Champion", "Hero", "Legend", "Elite" };

	/**
     * Gets the readable name.
     *
     * @param rank the rank
     * @return the readable name
     */
	public static String getReadableName(int rank) {
		return LOCALISED_NAMES[rank];
	}

	/**
     * Gets the rank.
     *
     * @param rankName the rank name
     * @return the rank
     */
	public static int getRank(String rankName) {
		int rank = 0;

		for (int i = 0; i < LOCALISED_NAMES.length; i++) {
			if (LOCALISED_NAMES[i].equals(rankName)) {
				rank = i;
			}
		}

		return rank;
	}
}
