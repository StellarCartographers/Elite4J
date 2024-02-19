/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model;

import lombok.*;

import java.util.List;

@EliteCreator
@EliteObject
public class ConflictFaction
{
    private String             name;
    private String             factionState;
    private String             government;
    private String             allegiance;
    private String             happiness;
    private double             myReputation;
    private double             influence;
    private List<FactionState> activeStates;
    private List<FactionState> pendingStates;
    private List<FactionState> recoveringStates;
    private boolean            squadronSystem;
    private boolean            happiestSystem;
    private boolean            homeSystem;
    private String             stake;
    private int                daysWon;
}
