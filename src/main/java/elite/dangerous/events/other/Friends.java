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
 * The Class Friends.
 */
@SuperBuilder
@Jacksonized
public class Friends extends Event 
{

    /**
     * The Constant STATUS.
     */
    public static final String[] STATUS = {"Requested", "Declined", "Added", "Lost", "Offline", "Online"};
    /**
     * The status.
     */
    public String                status;
    /**
     * The name.
     */
    public String                name;
}
