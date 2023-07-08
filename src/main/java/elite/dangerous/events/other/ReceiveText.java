/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ReceiveText.
 */
@SuperBuilder
@Jacksonized
public class ReceiveText extends Event 
{

    /**
     * The from.
     */
    public String from;
    /**
     * The from localised.
     */
    public String fromLocalised;
    /**
     * The message.
     */
    public String message;
    /**
     * The message localised.
     */
    public String messageLocalised;
    /**
     * The channel.
     */
    public String channel;
}
