/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.material;

import lombok.*;

@EliteObject(ObjectType.PARENT)
public abstract class Item
{
    private String name;
    private int    count;
}
