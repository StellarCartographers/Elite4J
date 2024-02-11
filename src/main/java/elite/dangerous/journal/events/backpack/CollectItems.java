/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.backpack;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class CollectItems extends Event
{
    private String  name;

    private String  type;

    private long    ownerID;

    private int     count;

    private boolean stolen;

}
