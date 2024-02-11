/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.other;

import lombok.*;

import elite.dangerous.core.Event;

@EliteObject 
public class Promotion extends Event
{

    private int combat;

    private int trade;

    private int explore;

    private int cqc;

    private int federation;

    private int empire;

}
