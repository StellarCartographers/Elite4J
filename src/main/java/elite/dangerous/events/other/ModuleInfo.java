/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.other;

import java.util.List;

import elite.dangerous.base.Event;
import elite.dangerous.models.Module;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ModuleInfo.
 */
@SuperBuilder
@Jacksonized
public class ModuleInfo extends Event 
{

    /**
     * The modules.
     */
    public List<Module> modules;
}
