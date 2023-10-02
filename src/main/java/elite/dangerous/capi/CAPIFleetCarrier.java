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
    private Name             name;
    private String           currentStarSystem;
    private long             balance;
    private String           fuel;
    private String           state;
    private Theme            theme;
    private DockingAccess    dockingAccess;
    private boolean          notoriousAccess;
    private Capacity         capacity;
    private Itinerary        itinerary;
    private Finances         marketFinances;
    private Finances         blackmarketFinances;
    private Finance          finance;
    private ServicesCrew     servicesCrew;
    private List<Cargo>      cargo;
    private Orders           orders;
    private CarrierLocker    carrierLocker;
    private List<Reputation> reputation;
    private Market           market;
    private Ships            ships;
    private Modules          modules;
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
