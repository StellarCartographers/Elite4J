/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.exploration;

import lombok.*;

import java.util.List;

import elite.dangerous.core.Event;

@EliteObject 
public class SAAScanComplete extends Event
{

    private String       bodyName;

    private int          bodyID, probesUsed, efficiencyTarget;

    private long         systemAddress;

    private List<String> descoverers;

    private List<String> mappers;

}
