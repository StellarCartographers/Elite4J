package elite.dangerous.capi.modal.fleetcarrier;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import elite.dangerous.utils.deserializer.UTCDateDeserializer;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ServicesCrew
{
    private Service refuel;
    @SerializedName("repair")
    private Service repair;
    @SerializedName("rearm")
    private Service rearm;
    @SerializedName("outfitting")
    private Service outfitting;
    @SerializedName("shipyard")
    private Service shipyard;
    @SerializedName("blackmarket")
    private Service blackmarket;
    @SerializedName("voucherredemption")
    private Service voucherredemption;
    @SerializedName("exploration")
    private Service exploration;
    @SerializedName("bartender")
    private Service bartender;
    @SerializedName("vistagenomics")
    private Service vistagenomics;
    @SerializedName("pioneersupplies")
    private Service pioneersupplies;

    /**
     * Returns true if, and only if:
     * <br>
     * {@code refuel()} is non-null
     * <br>
     * {@code refuel.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isRefuelEnabled()
    {
        return (this.refuel != null) && this.refuel.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code repair()} is non-null
     * <br>
     * {@code repair.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isRepairEnabled()
    {
        return (this.repair != null) && this.repair.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code rearm()} is non-null
     * <br>
     * {@code rearm.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isRearmEnabled()
    {
        return (this.rearm != null) && this.rearm.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code shipyard()} is non-null
     * <br>
     * {@code shipyard.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isShipyardEnabled()
    {
        return (this.shipyard != null) && this.shipyard.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code outfitting()} is non-null
     * <br>
     * {@code outfitting.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isOutfittingEnabled()
    {
        return (this.outfitting != null) && this.outfitting.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code exploration()} is non-null
     * <br>
     * {@code exploration.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isUniversalCartographicsEnabled()
    {
        return (this.exploration != null) && this.exploration.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code voucherredemption()} is non-null
     * <br>
     * {@code voucherredemption.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isRedemptionOfficeEnabled()
    {
        return (this.voucherredemption != null) && this.voucherredemption.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code blackmarket()} is non-null
     * <br>
     * {@code blackmarket.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isBlackmarketEnabled()
    {
        return (this.blackmarket != null) && this.blackmarket.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code vistagenomics()} is non-null
     * <br>
     * {@code vistagenomics.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isVistaGenomicsEnabled()
    {
        return (this.vistagenomics != null) && this.vistagenomics.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code bartender()} is non-null
     * <br>
     * {@code bartender.isAvailable()} returns true
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isConcourseEnabled()
    {
        return (this.bartender != null) && this.bartender.isAvailable();
    }

    /**
     * Returns true if, and only if:
     * <br>
     * {@code pioneersupplies()} is non-null
     * <br>
     * {@code pioneersupplies.isAvailable()} returns true
     * 
     * @return true, if both conditions are met, false if not
     */
    @JsonIgnore
    public boolean isPioneerSuppliesEnabled()
    {
        return (this.pioneersupplies != null) && this.pioneersupplies.isAvailable();
    }

    @Value
    @Builder
    @Jacksonized
    public static class Service
    {
        @SerializedName("crewMember")
        private CrewMember     crewMember;
        @SerializedName("invoicesWeekToDate")
        private List<Invoices> invoices;
        @SerializedName("status")
        private String         status;

        @JsonIgnore
        boolean isAvailable()
        {
            return crewMember.enabled.equals(ServiceAvailability.YES);
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class CrewMember
    {
        @SerializedName("name")
        private String              name;
        @SerializedName("gender")
        private String              gender;
        @SerializedName("enabled")
        private ServiceAvailability enabled;
        @SerializedName("faction")
        private String              faction;
        @SerializedName("salary")
        private String              salary;
        @SerializedName("hiringPrice")
        private String              hiringPrice;
        @SerializedName("lastEdit")
        private String              lastEdit;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Invoices
    {
        @SerializedName("wages")
        private int    wages;
        @SerializedName("from") @JsonAdapter(UTCDateDeserializer.class)
        private Date   from;
        @SerializedName("until") @JsonAdapter(UTCDateDeserializer.class)
        private Date   until;
        @SerializedName("type")
        private String type;
    }
}
