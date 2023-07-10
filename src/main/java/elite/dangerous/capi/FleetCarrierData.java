/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.capi.meta.Capacity;
import elite.dangerous.capi.meta.Cargo;
import elite.dangerous.capi.meta.CarrierLocker;
import elite.dangerous.capi.meta.Finance;
import elite.dangerous.capi.meta.Finances;
import elite.dangerous.capi.meta.Itinerary;
import elite.dangerous.capi.meta.Market;
import elite.dangerous.capi.meta.Modules;
import elite.dangerous.capi.meta.Name;
import elite.dangerous.capi.meta.Orders;
import elite.dangerous.capi.meta.Reputation;
import elite.dangerous.capi.meta.ServicesCrew;
import elite.dangerous.capi.meta.Ships;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FleetCarrierData {
    @SerializedName("name")
    private Name name;

    @SerializedName("currentStarSystem")
    private String currentStarSystem;

    @SerializedName("balance")
    private String balance;

    @SerializedName("fuel")
    private String fuel;

    @SerializedName("state")
    private String state;

    @SerializedName("theme")
    private String theme;

    @SerializedName("dockingAccess")
    private String dockingAccess;

    @SerializedName("notoriousAccess")
    private boolean notoriousAccess;

    @SerializedName("capacity")
    private Capacity capacity;

    @SerializedName("itinerary")
    private Itinerary itinerary;

    @SerializedName("marketFinances")
    private Finances marketFinances;

    @SerializedName("blackmarketFinances")
    private Finances blackmarketFinances;

    @SerializedName("finance")
    private Finance finance;

    @SerializedName("servicesCrew")
    private ServicesCrew servicesCrew;

    @SerializedName("cargo")
    private List<Cargo> cargo;

    @SerializedName("orders")
    private Orders orders;

    @SerializedName("carrierLocker")
    private CarrierLocker carrierLocker;

    @SerializedName("reputation")
    private List<Reputation> reputation;

    @SerializedName("market")
    private Market market;

    @SerializedName("ships")
    private Ships ships;

    @SerializedName("modules")
    private Modules modules;

    @SerializedName("timestamp")
    private Date timestamp;

    /**
     * Creates and returns a UUID for this FleetCarrier instnace
     * 
     * @return The unique UUID for this FleetCarrier
     * @apiNote The {@link java.util.UUID UUID} is created by combining the FleetCarrier's Callsign & Market ID to a single String,
     * converting the String to a byte array and passing the result to {@link java.util.UUID#nameUUIDFromBytes(byte[]) UUID.nameUUIDFromBytes(byte[])}
     */
    public UUID getUUID() {
        var namespace = this.name.getCallsign() + this.getCarrierId();
        return UUID.nameUUIDFromBytes(namespace.getBytes(Charset.forName("UTF-8")));
    }

    /**
     * Gets the carrier id. Returns the value from {@code market().id()}
     *
     * @return Carrier ID
     */
    public String getCarrierId() {
        return this.market.getId();
    }
}
