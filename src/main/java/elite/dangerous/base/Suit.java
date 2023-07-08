/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.base;

import lombok.experimental.SuperBuilder;

/**
 * The Class Suit.
 */
@SuperBuilder
public abstract class Suit extends Event
{
    /**
     * The suit ID.
     */
    public Long   suitID;
    /**
     * The suit name.
     */
    public String suitName;
    /**
     * The suit name localized.
     */
    public String suitName_Localized;
    /**
     * The loadout ID.
     */
    public Long   loadoutID;
    /**
     * The loadout name.
     */
    public String loadoutName;
}
