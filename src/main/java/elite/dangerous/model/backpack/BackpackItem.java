/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.backpack;

import lombok.*;

@EliteCreator
@EliteObject
public class BackpackItem
{
    private String name;
    private long   ownerID;
    private long   missionID;
    private int    count;
    private String type;
}
