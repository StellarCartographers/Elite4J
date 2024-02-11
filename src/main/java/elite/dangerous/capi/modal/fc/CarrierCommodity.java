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
public class CarrierCommodity
{
    @JsonProperty("id")
    private FDevID id;
    private String categoryname;
    private String name;
    private int    stock;
    private int    buyPrice;
    private int    sellPrice;
    private int    demand;
    private String legality;
    private int    meanPrice;
    private int    demandBracket;
    private int    stockBracket;
    private String locName;
}
