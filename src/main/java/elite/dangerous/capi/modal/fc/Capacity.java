/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.EliteObject;

@EliteObject
public class Capacity
{
    private int shipPacks;
    private int modulePacks;
    private int cargoForSale;
    private int cargoNotForSale;
    private int cargoSpaceReserved;
    private int crew;
    private int freeSpace;
    private int microresourceCapacityTotal;
    private int microresourceCapacityFree;
    private int microresourceCapacityUsed;
    private int microresourceCapacityReserved;
}
