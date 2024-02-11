/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc.orders;

import lombok.EliteObject;

import com.fasterxml.jackson.annotation.JsonProperty;

@EliteObject
public class Orders
{
    private CommodityLedger commodities;
    @JsonProperty("onfootmicroresources")
    private MicroResourceLedger microResources;
}
