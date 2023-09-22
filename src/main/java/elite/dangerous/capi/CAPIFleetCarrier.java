/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import elite.dangerous.capi.modal.fleetcarrier.Capacity;
import elite.dangerous.capi.modal.fleetcarrier.Cargo;
import elite.dangerous.capi.modal.fleetcarrier.CarrierLocker;
import elite.dangerous.capi.modal.fleetcarrier.DockingAccess;
import elite.dangerous.capi.modal.fleetcarrier.Finance;
import elite.dangerous.capi.modal.fleetcarrier.Finances;
import elite.dangerous.capi.modal.fleetcarrier.Itinerary;
import elite.dangerous.capi.modal.fleetcarrier.Market;
import elite.dangerous.capi.modal.fleetcarrier.Modules;
import elite.dangerous.capi.modal.fleetcarrier.Name;
import elite.dangerous.capi.modal.fleetcarrier.Orders;
import elite.dangerous.capi.modal.fleetcarrier.Reputation;
import elite.dangerous.capi.modal.fleetcarrier.ServicesCrew;
import elite.dangerous.capi.modal.fleetcarrier.Ships;
import elite.dangerous.capi.modal.fleetcarrier.Theme;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CAPIFleetCarrier
{
    @SerializedName("name")
    private Name             name;
    @SerializedName("currentStarSystem")
    private String           currentStarSystem;
    @SerializedName("balance")
    private long             balance;
    @SerializedName("fuel")
    private String           fuel;
    @SerializedName("state")
    private String           state;
    @SerializedName("theme")
    private Theme            theme;
    @SerializedName("dockingAccess")
    private DockingAccess    dockingAccess;
    @SerializedName("notoriousAccess")
    private boolean          notoriousAccess;
    @SerializedName("capacity")
    private Capacity         capacity;
    @SerializedName("itinerary")
    private Itinerary        itinerary;
    @SerializedName("marketFinances")
    private Finances         marketFinances;
    @SerializedName("blackmarketFinances")
    private Finances         blackmarketFinances;
    @SerializedName("finance")
    private Finance          finance;
    @SerializedName("servicesCrew")
    private ServicesCrew     servicesCrew;
    @SerializedName("cargo")
    private List<Cargo>      cargo;
    @SerializedName("orders")
    private Orders           orders;
    @SerializedName("carrierLocker")
    private CarrierLocker    carrierLocker;
    @SerializedName("reputation")
    private List<Reputation> reputation;
    @SerializedName("market")
    private Market           market;
    @SerializedName("ships")
    private Ships            ships;
    @SerializedName("modules")
    private Modules          modules;
    @SerializedName("timestamp")
    private Date             timestamp;

    /**
     * Gets the carrier id. Returns the value from {@code market().id()}
     *
     * @return Carrier ID
     */
    @JsonIgnore
    public String getCarrierId()
    {
        return this.market.getId();
    }
}
