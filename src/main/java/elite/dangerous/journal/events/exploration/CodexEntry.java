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

import elite.dangerous.journal.Event;

@EliteObject 
public class CodexEntry extends Event
{
    private String   name;

    private String   subCategory;

    private String   category;

    private String   region;

    private String   system;

    private int      entryID;

    private long     systemAddress;

    private boolean  isNewEntry;

    private boolean  newTraitsDiscovered;

    private String[] traits;

    private String   nearestDestination;
}
