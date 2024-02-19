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
public class Module
{
    private String     slot, item;
    private boolean    on;
    private int        priority, ammoInClip, ammoInHopper;
    private double     health, power;
    public Engineering engineering;
}
