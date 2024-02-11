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

@EliteObject 
public class ScanStageThree extends ScanStageTwo
{
    private String faction;
    private String legalStatus;
    private String subsystem;
    private double subsystemHealth;
    private String power;
    private long   bounty;
}
