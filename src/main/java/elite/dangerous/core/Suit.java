/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.core;

import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class Suit extends Event
{
    private long   suitID;

    private String suitName;

    private String suitName_Localized;

    private long   loadoutID;

    private String loadoutName;
}
