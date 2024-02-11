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

@EliteCreator @EliteObject
public class SpaceUsage
{
    private int totalCapacity;
    private int crew;
    private int cargo;
    private int cargoSpaceReserved;
    private int shipPacks;
    private int modulePacks;
    private int freeSpace;
}
