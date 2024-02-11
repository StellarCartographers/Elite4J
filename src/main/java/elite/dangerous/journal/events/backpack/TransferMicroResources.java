/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.backpack;

import lombok.*;

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.MicroResourceTransfer;

@EliteObject 
public class TransferMicroResources extends Event
{
    private List<MicroResourceTransfer> transfers;
}
