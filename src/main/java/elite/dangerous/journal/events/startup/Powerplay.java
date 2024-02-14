/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.startup;

import lombok.*;

import elite.dangerous.journal.Event;

@EliteObject 
public class Powerplay extends Event
{

    private String power;

    private int    rank;

    private int    merits;

    private int    votes;

    private int    timePledged;

}
