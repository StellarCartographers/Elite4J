/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.powerplay;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject(ObjectType.PARENT)
public abstract class PowerplayDistribution extends Event
{
    private String power;
    private String type;
    private int    count;
}
