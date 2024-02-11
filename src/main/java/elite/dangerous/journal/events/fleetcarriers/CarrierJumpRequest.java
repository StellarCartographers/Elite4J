/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.fleetcarriers;

import lombok.EliteObject;

import elite.dangerous.api.journal.fleetcarriers.ICarrierJumpRequest;
import elite.dangerous.core.Event;

@EliteObject
public class CarrierJumpRequest extends Event implements ICarrierJumpRequest
{
    private long   carrierID;
    private String systemName;
    private String body;
    private long   systemAddress;
    private int    bodyID;
    private String departureTime;
}
