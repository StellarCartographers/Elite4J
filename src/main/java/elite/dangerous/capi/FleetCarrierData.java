/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi;

import lombok.*;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

import elite.dangerous.capi.modal.fc.*;
import elite.dangerous.capi.modal.fc.orders.Orders;
import elite.dangerous.model.identity.ID;

@EliteObject
public class FleetCarrierData extends CAPIData
{
    @Getter(AccessLevel.PRIVATE)
    @JsonProperty(value = "name", index = 0)
    private Name             nameInfo;
    private String           currentStarSystem;
    private String           balance;
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

    @JsonIgnore
    public String callsign()
    {
        return nameInfo().callsign();
    }

    @JsonIgnore
    public String name()
    {
        return nameInfo().name();
    }

    @JsonIgnore
    public int fuel()
    {
        return Integer.valueOf(fuel);
    }

    @JsonIgnore
    public long balance()
    {
        return Integer.valueOf(balance);
    }

    /**
     * Gets the carrier id. Returns the value from {@code market().id()}
     *
     * @return Carrier ID
     */
    @JsonIgnore
    public ID carrierId()
    {
        return this.market.id();
    }

    /**
     * Returns the accumulated total of Tritium that is stored as cargo.
     * Since it's not possible to explicitly set cargo to be used for fuel,
     * the returned value should be taken as the MAX amount that can used for fuel
     *
     * @return Fuel Reserves amount
     */
    @JsonIgnore
    public int fuelReserves()
    {
        return cargo().stream().filter(Cargo.TritiumPredicate).mapToInt(Cargo::quantity).sum();
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRefuelSuspended()
    {
        return this.market.services().refuel().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRefuelInstalled()
    {
        return this.market.services().refuel().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRepairSuspended()
    {
        return this.market.services().repair().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRepairInstalled()
    {
        return this.market.services().repair().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRearmSuspended()
    {
        return this.market.services().rearm().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRearmInstalled()
    {
        return this.market.services().rearm().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isShipyardSuspended()
    {
        return this.market.services().shipyard().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isShipyardInstalled()
    {
        return this.market.services().shipyard().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isOutfittingSuspended()
    {
        return this.market.services().outfitting().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isOutfittingInstalled()
    {
        return this.market.services().outfitting().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isUniversalCartographicsSuspended()
    {
        return this.market.services().exploration().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isUniversalCartographicsInstalled()
    {
        return this.market.services().exploration().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRedemptionOfficeSuspended()
    {
        return this.market.services().voucherredemption().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRedemptionOfficeInstalled()
    {
        return this.market.services().voucherredemption().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isBlackmarketSuspended()
    {
        return this.market.services().blackmarket().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isBlackmarketInstalled()
    {
        return this.market.services().blackmarket().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isVistaGenomicsSuspended()
    {
        return this.market.services().vistagenomics().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isVistaGenomicsInstalled()
    {
        return this.market.services().vistagenomics().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isBartenderSuspended()
    {
        return this.market.services().bartender().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isBartenderInstalled()
    {
        return this.market.services().bartender().notEquals(State.UNAVAILABLE);
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isPioneerSuppliesSuspended()
    {
        return this.market.services().pioneersupplies().equals(State.UNMANNED);
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isPioneerSuppliesInstalled()
    {
        return this.market.services().pioneersupplies().notEquals(State.UNAVAILABLE);
    }
}
