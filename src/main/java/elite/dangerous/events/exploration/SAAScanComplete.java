/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import java.util.List;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SAAScanComplete.
 */
@SuperBuilder
@Jacksonized
public class SAAScanComplete extends Event 
{

    /**
     * The body name.
     */
    public String       bodyName;
    /**
     * The efficiency target.
     */
    public Integer      bodyID, probesUsed, efficiencyTarget;
    /**
     * The system address.
     */
    public Long         systemAddress;
    /**
     * The descoverers.
     */
    public List<String> descoverers;
    /**
     * The mappers.
     */
    public List<String> mappers;
}
