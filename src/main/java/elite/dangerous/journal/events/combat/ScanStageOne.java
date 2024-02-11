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

import elite.dangerous.journal.NonDefinedEvent;

@EliteObject (ObjectType.PARENT)
@NonDefinedEvent
public class ScanStageOne extends ShipTargetLocked
{
    private String pilotName;
    private String pilotRank;
}
