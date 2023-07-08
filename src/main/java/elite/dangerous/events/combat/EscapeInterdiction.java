/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.combat;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class EscapeInterdiction.
 */
@SuperBuilder
@Jacksonized
public class EscapeInterdiction extends Event 
{

    /**
     * The interdictor.
     */
    public String  interdictor;
    /**
     * The is player.
     */
    public Boolean isPlayer;
}
