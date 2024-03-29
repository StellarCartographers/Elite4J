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

import elite.dangerous.journal.Event;
import elite.dangerous.model.SAASignal;

@EliteObject 
public class FSSBodySignals extends Event
{

    private long            systemAddress;

    private String          bodyName;

    private int             bodyID;

    private List<SAASignal> signals;

}
