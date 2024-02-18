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

import java.util.List;

import elite.dangerous.model.identity.ID;

@EliteObject
public class Market
{
    @JsonProperty("id")
    private ID                 id;
    private String                 name;
    private final String           outpostType = "fleetcarrier";
    private List<Object>           imported;
    private List<Object>           exported;
    private ServiceStates          services;
    private final Economies        economies   = new Economies();
    private Object                 prohibited;
    private List<CarrierCommodity> commodities;
}
