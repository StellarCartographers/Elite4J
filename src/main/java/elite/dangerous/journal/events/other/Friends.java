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

import elite.dangerous.journal.Event;

@EliteObject 
public class Friends extends Event
{

    public static final String[] STATUS = {"Requested", "Declined", "Added", "Lost", "Offline", "Online"};

    private String               status;

    private String               name;

}
