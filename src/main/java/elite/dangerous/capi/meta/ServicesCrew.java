package elite.dangerous.capi.meta;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ServicesCrew {
    private Service refuel, repair, rearm, outfitting, shipyard, blackmarket,
        voucherredemption, exploration, bartender, vistagenomics, pioneersupplies;

    /**
     * Returns true if, and only if:
     * <br>
     * ● refuel() is non-null
     * <br>
     * ● refuel.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isRefuelAvailable() {
        return (this.refuel != null) && this.refuel.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● repair() is non-null
     * <br>
     * ● repair.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isRepairEnabled() {
        return (this.repair != null) && this.repair.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● rearm() is non-null
     * <br>
     * ● rearm.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isRearmEnabled() {
        return (this.rearm != null) && this.rearm.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● shipyard() is non-null
     * <br>
     * ● shipyard.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isShipyardEnabled() {
        return (this.shipyard != null) && this.shipyard.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● outfitting() is non-null
     * <br>
     * ● outfitting.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isOutfittingEnabled() {
        return (this.outfitting != null) && this.outfitting.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● exploration() is non-null
     * <br>
     * ● exploration.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isUniversalCartographicsEnabled() {
        return (this.exploration != null) && this.exploration.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● voucherredemption() is non-null
     * <br>
     * ● voucherredemption.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isRedemptionOfficeEnabled() {
        return (this.voucherredemption != null) && this.voucherredemption.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● blackmarket() is non-null
     * <br>
     * ● blackmarket.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isBlackmarketEnabled() {
        return (this.blackmarket != null) && this.blackmarket.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● vistagenomics() is non-null
     * <br>
     * ● vistagenomics.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isVistaGenomicsEnabled() {
        return (this.vistagenomics != null) && this.vistagenomics.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● bartender() is non-null
     * <br>
     * ● bartender.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isConcourseEnabled() {
        return (this.bartender != null) && this.bartender.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * ● pioneersupplies() is non-null
     * <br>
     * ● pioneersupplies.isAvailable() returns true
     * @return true, if both conditions are met, false if not
     */
    public boolean isPioneerSuppliesEnabled() {
        return (this.pioneersupplies != null) && this.pioneersupplies.isAvailable();
    }

    @Value
    @Builder
    public static class Service {
        @SerializedName("crewMember")
        private CrewMember crewMember;

        @SerializedName("invoicesWeekToDate")
        private List<Invoices> invoices;

        @SerializedName("status")
        private String status;

        boolean isAvailable() {
            return crewMember.enabled.equals(ServiceAvailability.YES);
        }
    }

    @Value
    @Builder
    public static class CrewMember {
        @SerializedName("name")
        private String name;

        @SerializedName("gender")
        private String gender;

        @SerializedName("enabled")
        private ServiceAvailability enabled;

        @SerializedName("faction")
        private String faction;

        @SerializedName("salary")
        private String salary;

        @SerializedName("hiringPrice")
        private String hiringPrice;

        @SerializedName("lastEdit")
        private String lastEdit;
    }

    @Value
    @Builder
    public static class Invoices {
        private String wages, from, until, type;
    }
}
