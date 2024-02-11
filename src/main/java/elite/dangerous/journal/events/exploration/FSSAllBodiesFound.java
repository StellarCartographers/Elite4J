/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.exploration;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class FSSAllBodiesFound extends Event
{

    private String systemName;

    private long   systemAddress;

    private int    count;

}
