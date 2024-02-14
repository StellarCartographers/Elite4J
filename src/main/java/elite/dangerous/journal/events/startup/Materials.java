/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.model.material.*;

@EliteObject 
public class Materials extends Event
{

    private List<Material>     raw;

    private List<Manufactured> manufactured;

    private List<Encoded>      encoded;

}
