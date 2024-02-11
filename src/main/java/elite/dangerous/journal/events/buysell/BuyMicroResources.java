/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.buysell;

import lombok.*;

import elite.dangerous.core.Event;
import elite.dangerous.model.enums.ResourceCategory;

@EliteObject 
public class BuyMicroResources extends Event
{
    private String                name;

    private ResourceCategory category;

    private int                   count;

    private long                  price;

    private long                  marketID;
}
