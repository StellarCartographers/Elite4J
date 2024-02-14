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
public class Fileheader extends Event
{

    private int     part;

    private String  language;

    private boolean odyssey;

    private String  gameversion;

    private String  build;
}
