package elite.dangerous.capi.modal.fleetcarrier;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ServicesCrew
{
    private Service refuel;
    private Service repair;
    private Service rearm;
    private Service outfitting;
    private Service shipyard;
    private Service blackmarket;
    private Service voucherredemption;
    private Service exploration;
    private Service bartender;
    private Service vistagenomics;
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
        private CrewMember     crewMember;
        private List<Invoices> invoices;
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
        private String              name;
        private String              gender;
        private ServiceAvailability enabled;
        private String              faction;
        private String              salary;
        private String              hiringPrice;
        private String              lastEdit;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Invoices
    {
        private int    wages;
        private Date   from;
        private Date   until;
        private String type;
    }
}
