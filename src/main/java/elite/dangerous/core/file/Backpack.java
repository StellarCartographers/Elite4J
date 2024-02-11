/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.core.file;

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.backpack.BackpackItem;
import lombok.EliteObject;

@EliteObject
public class Backpack extends Event
{
    private List<BackpackItem> items;

    private List<BackpackItem> components;

    private List<BackpackItem> consumables;

    private List<BackpackItem> data;
}
