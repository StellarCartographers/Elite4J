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

import com.fasterxml.jackson.annotation.JsonProperty;

import space.tscg.misc.FDevID;

@EliteObject
public class LockerItem
{
    @JsonProperty("id")
    private FDevID id;
    private int    quantity;
    private String name;
    private String locName;
}
