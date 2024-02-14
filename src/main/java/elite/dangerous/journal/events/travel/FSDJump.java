/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.travel;

import lombok.*;

import java.util.List;

import elite.dangerous.journal.Event;
import elite.dangerous.model.*;

@EliteObject 
public class FSDJump extends Event
{
    private String         starSystem;

    private String         systemAllegiance;

    private String         systemEconomy;

    private String         systemSecondEconomy;

    private String         systemGovernment;

    private String         systemSecurity;

    private String         body;

    private String         bodyType;

    public Faction         systemFaction;

    private String         powerplayState;

    private long           population;

    private long           systemAddress;

    private long           boostUsed;

    private int            bodyId;

    private double         jumpDistance;

    private double         fuelUsed;

    private double         fuelLevel;

    private List<Faction>  factions;

    private List<Conflict> conflicts;

    private double[]       starPos;

    private List<String>   powers;

}
