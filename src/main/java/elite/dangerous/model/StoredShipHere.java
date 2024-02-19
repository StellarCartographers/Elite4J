/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model;

import lombok.*;

@EliteCreator
@EliteObject
public class StoredShipHere
{
    private boolean hot;
    private String  name;
    private String  shipType;
    private long    value;
    private int     shipID;
}
