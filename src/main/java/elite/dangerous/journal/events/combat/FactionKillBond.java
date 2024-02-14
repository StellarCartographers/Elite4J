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

import elite.dangerous.journal.Event;

@EliteObject 
public class FactionKillBond extends Event
{
    private int    reward;

    private String awardingFaction;

    private String victimFaction;
}
