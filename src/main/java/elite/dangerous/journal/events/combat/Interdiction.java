/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.combat;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class Interdiction extends Event
{
    private boolean success, isPlayer;

    private String  interdicted, faction, power;

    private int     combatRank;

}
