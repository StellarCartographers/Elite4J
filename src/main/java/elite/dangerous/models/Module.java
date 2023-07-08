/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models;
/**
 * The Class Module.
 */
public class Module
{
    /**
     * The item.
     */
    public String      slot, item;
    /**
     * The on.
     */
    public Boolean     on;
    /**
     * The ammo in hopper.
     */
    public Integer     priority, ammoInClip, ammoInHopper;
    /**
     * The power.
     */
    public Double      health, power;
    /**
     * The engineering.
     */
    public Engineering engineering;
}
