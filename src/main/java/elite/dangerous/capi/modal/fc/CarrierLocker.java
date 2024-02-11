/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.EliteObject;

import java.util.List;

@EliteObject
public class CarrierLocker
{
    private List<LockerItem> assets;
    private List<LockerItem> goods;
    private List<LockerItem> data;
}
