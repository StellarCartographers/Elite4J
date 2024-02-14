/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal;

import elite.dangerous.model.carrier.Operation;
import lombok.EliteObject;
import lombok.ObjectType;

@EliteObject(ObjectType.PARENT)
public abstract class CarrierPack extends Event
{
    private int       carrierID;

    private Operation operation;

    private String    packTheme;

    private int       packTier;

    private int       cost;
}
