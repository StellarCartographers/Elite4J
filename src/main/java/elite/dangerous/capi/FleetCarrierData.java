/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.capi.FleetCarrierData.ServicesCrew.CrewMember.ServiceAvailability;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class FleetCarrierData
{
    private Name             name;
    private String           currentStarSystem;
    private String           balance;
    private String           fuel;
    private String           state;
    private String           theme;
    private String           dockingAccess;
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

    public UUID getUUID()
    {
        var namespace = this.name.callsign + this.market.id;
        return UUID.nameUUIDFromBytes(namespace.getBytes(Charset.forName("UTF-8")));
    }

    /**
     * Gets the carrier id. Returns the value from {@code market.id}
     *
     * @return Carrier ID
     */
    public String getCarrierId()
    {
        return market.id;
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.refuel != null
     * <br>
     * ● servicesCrew.refuel.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Refuel is enabled
     */
    public boolean isRefuelEnabled()
    {
        return (servicesCrew.refuel != null) && (servicesCrew.refuel.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.repair != null
     * <br>
     * ● servicesCrew.repair.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Repair is enabled
     */
    public boolean isRepairEnabled()
    {
        return (servicesCrew.repair != null) && (servicesCrew.repair.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.rearm != null
     * <br>
     * ● servicesCrew.rearm.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Rearm is enabled
     */
    public boolean isRearmEnabled()
    {
        return (servicesCrew.rearm != null) && (servicesCrew.rearm.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.shipyard != null
     * <br>
     * ● servicesCrew.shipyard.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Shipyard is enabled
     */
    public boolean isShipyardEnabled()
    {
        return (servicesCrew.shipyard != null) && (servicesCrew.shipyard.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.outfitting != null
     * <br>
     * ● servicesCrew.outfitting.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Outfitting is enabled
     */
    public boolean isOutfittingEnabled()
    {
        return (servicesCrew.outfitting != null) && (servicesCrew.outfitting.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.exploration != null
     * <br>
     * ● servicesCrew.exploration.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if UniversalCartographics is enabled
     */
    public boolean isUniversalCartographicsEnabled()
    {
        return (servicesCrew.exploration != null) && (servicesCrew.exploration.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.voucherredemption != null
     * <br>
     * ● servicesCrew.voucherredemption.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if RedemptionOffice is enabled
     */
    public boolean isRedemptionOfficeEnabled()
    {
        return (servicesCrew.voucherredemption != null) && (servicesCrew.voucherredemption.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.blackmarket != null
     * <br>
     * ● servicesCrew.blackmarket.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Blackmarket is enabled
     */
    public boolean isBlackmarketEnabled()
    {
        return (servicesCrew.blackmarket != null) && (servicesCrew.blackmarket.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.vistagenomics != null
     * <br>
     * ● servicesCrew.vistagenomics.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if VistaGenomics is enabled
     */
    public boolean isVistaGenomicsEnabled()
    {
        return (servicesCrew.vistagenomics != null) && (servicesCrew.vistagenomics.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.bartender != null
     * <br>
     * ● servicesCrew.bartender.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if Concourse is enabled
     */
    public boolean isConcourseEnabled()
    {
        return (servicesCrew.bartender != null) && (servicesCrew.bartender.crewMember.enabled == ServiceAvailability.YES);
    }

    /**
     * Returns true if, and only if, the following conditions are met:
     * <br>
     * ● servicesCrew.pioneersupplies != null
     * <br>
     * ● servicesCrew.pioneersupplies.crewMember.enabled == ServiceAvailability.YES
     *
     * @return true, if PioneerSupplies is enabled
     */
    public boolean isPioneerSuppliesEnabled()
    {
        return (servicesCrew.pioneersupplies != null) && (servicesCrew.pioneersupplies.crewMember.enabled == ServiceAvailability.YES);
    }

    @Value
    @Builder
    @Jacksonized
    public static class Name
    {
        private String callsign;
        private String vanityName;
        private String filteredVanityName;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Capacity
    {
        private String shipPacks;
        private String modulePacks;
        private String cargoForSale;
        private String cargoNotForSale;
        private String cargoSpaceReserved;
        private String crew;
        private String freeSpace;
        private String microresourceCapacityTotal;
        private String microresourceCapacityFree;
        private String microresourceCapacityUsed;
        private String microresourceCapacityReserved;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Itinerary
    {
        @SerializedName("completed")
        private List<Itinerary.Completed> completedJumps;
        @SerializedName("totalDistanceJumpedLY")
        private String                    totalDistance;
        private String                    currentJump;

        @Value
        @Builder
        @Jacksonized
        public static class Completed
        {
            private Date departureTime;
            private Date arrivalTime;
            private String state;
            private String visitDurationSeconds;
            private String starsystem;
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Finances
    {
        private String cargoTotalValue;
        private String allTimeProfit;
        private String numCommodsForSale;
        private String numCommodsPurchaseOrders;
        private String balanceAllocForPurchaseOrders;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Finance
    {
        private String                  bankBalance, bankReservedBalance, taxation;
        @SerializedName("service_taxation")
        private Finance.ServiceTaxation serviceTaxation;
        @SerializedName("numServices")
        private String                  servicesCount;
        @SerializedName("numOptionalServices")
        private String                  optionalServicesCount;
        private String                  debtThreshold, maintenance, maintenanceToDate, coreCost, servicesCost, servicesCostToDate, jumpsCost;
        @SerializedName("numJumps")
        private String                  jumpCount;
        private Finance.Bartender       bartender;

        @Value
        @Builder
        @Jacksonized
        public static class ServiceTaxation
        {
            public int bartender, pioneersupplies, rearm, refuel, repair, shipyard, outfitting;
        }

        @Value
        @Builder
        @Jacksonized
        public static class Bartender
        {
            private String     microresourcesTotalValue;
            private String     allTimeProfit;
            private String     microresourcesForSale;
            private String     microresourcesPurchaseOrders;
            private String     balanceAllocForPurchaseOrders;
            private List<Long> profitHistory;
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Cargo
    {
        private String  commodity;
        private String  originSystem;
        private boolean mission;
        private String  qty;
        private String  value;
        private boolean stolen;
        private String  locName;
    }

    @Value
    @Builder
    @Jacksonized
    public static class ServicesCrew
    {
        private Service refuel, repair, rearm, outfitting, shipyard, blackmarket, voucherredemption, exploration, bartender, vistagenomics, pioneersupplies;

        @Value
        @Builder
        @Jacksonized
        public static class Service
        {
            private CrewMember     crewMember;
            @SerializedName("invoicesWeekToDate")
            private List<Invoices> invoices;
            private String         status;
        }

        @Value
        @Builder
        @Jacksonized
        public static class CrewMember
        {
            private String              name;
            private String              gender;
            private ServiceAvailability enabled;
            private String              faction;
            private String              salary;
            private String              hiringPrice;
            private String              lastEdit;

            public enum ServiceAvailability
            {
                YES,
                NO;
            }
        }

        @Value
        @Builder
        @Jacksonized
        public static class Invoices
        {
            private String wages;
            private String from;
            private String until;
            private String type;
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Orders
    {
        private Commodities    commodities;
        private MicroResources microResources;

        @Value
        @Builder
        @Jacksonized
        public static class Commodities
        {
            private List<Sales>    sales;
            private List<Purchase> purchases;
        }

        @Value
        @Builder
        @Jacksonized
        public static class MicroResources
        {
            private List<Sales>    sales;
            private List<Purchase> purchases;
        }

        @Value
        @Builder
        @Jacksonized
        public static class Sales
        {
            private String  name;
            private String  stock;
            private String  price;
            private boolean blackmarket;
        }

        @Value
        @Builder
        @Jacksonized
        public static class Purchase
        {
            private String name;
            private String locName;
            private String total;
            private String outstanding;
            private String price;
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class CarrierLocker
    {
        private List<LockerItem> assets;
        private List<LockerItem> goods;
        private List<LockerItem> data;

        @Value
        @Builder
        @Jacksonized
        public static class LockerItem
        {
            private String id;
            private String quantity;
            private String name;
            private String locName;
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Reputation
    {
        private String faction;
        private String score;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Market
    {
        private String                 id;
        private String                 name;
        private final String           outpostType = "fleetcarrier";
        private List<Object>           imported;
        private List<Object>           exported;
        private Market.Services        services;
        private final Market.Economies economies   = new Economies();
        private List<Object>           prohibited;
        private List<Commodity>        commodities;

        @Getter
        public static class Economies
        {
            private _136 _136 = new _136();

            @Getter
            public static class _136
            {
                private String name       = "Carrier";
                private String proportion = "1";
            }
        }

        @Value
        @Builder
        @Jacksonized
        public static class Commodity
        {
            private String id;
            private String categoryname;
            private String name;
            private String stock;
            private String buyPrice;
            private String sellPrice;
            private String demand;
            private String legality;
            private String meanPrice;
            private String demandBracket;
            private String stockBracket;
            private String locName;
        }

        @Value
        @Builder
        @Jacksonized
        public static class Services
        {
            private ServiceState commodities;
            private ServiceState carrierfuel;
            private ServiceState socialspace;
            private ServiceState refuel;
            private ServiceState repair;
            private ServiceState rearm;
            private ServiceState shipyard;
            private ServiceState outfitting;
            private ServiceState blackmarket;
            private ServiceState voucherredemption;
            private ServiceState exploration;
            private ServiceState bartender;
            private ServiceState vistagenomics;
            private ServiceState pioneersupplies;
            private ServiceState carriermanagement;
            private ServiceState stationmenu;
            private ServiceState dock;
            private ServiceState crewlounge;
            private ServiceState engineer;
            private ServiceState contacts;
            private ServiceState livery;

            public List<String> getServicesByState(ServiceState state)
            {
                List<String> services = new ArrayList<>();
                for (Field f : Services.class.getDeclaredFields())
                {
                    ServiceState s;
                    try
                    {
                        s = (ServiceState) f.get(this);
                        if (s.equals(state))
                        {
                            services.add(f.getName());
                        }
                    } catch (IllegalArgumentException | IllegalAccessException e)
                    {
                    }
                }
                return services;
            }
        }

        public enum ServiceState
        {
            @SerializedName("ok")
            AVAILABLE,
            @SerializedName("unavailable")
            UNAVAILABLE,
            @SerializedName("private")
            PRIVATE
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Modules
    {
        private List<Module> list;

        @Value
        @Builder
        @Jacksonized
        public static class Module
        {
            private String id;
            private String category;
            private String name;
            private String cost;
            private String sku;
            private String stock;
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Ships
    {
        @SerializedName("shipyard_list")
        private List<Ship> shipyard;

        @Value
        @Builder
        @Jacksonized
        public static class Ship
        {
            private String id;
            private String name;
            private String baseValue;
            private String sku;
            private String stock;
        }
    }
}
