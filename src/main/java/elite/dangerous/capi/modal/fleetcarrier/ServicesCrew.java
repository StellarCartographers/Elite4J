package elite.dangerous.capi.modal.fleetcarrier;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
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
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRefuelSuspended()
    {
        return (this.refuel != null) && this.refuel.unavailable();
    }
    
    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRefuelInstalled()
    {
        return this.refuel != null;
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRepairSuspended()
    {
        return (this.repair != null) && this.repair.unavailable();
    }
    
    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRepairInstalled()
    {
        return this.repair != null;
    }

    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRearmSuspended()
    {
        return (this.rearm != null) && this.rearm.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRearmInstalled()
    {
        return this.rearm != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isShipyardSuspended()
    {
        return (this.shipyard != null) && this.shipyard.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isShipyardInstalled()
    {
        return this.shipyard != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isOutfittingSuspended()
    {
        return (this.outfitting != null) && this.outfitting.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isOutfittingInstalled()
    {
        return this.outfitting != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isUniversalCartographicsSuspended()
    {
        return (this.exploration != null) && this.exploration.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isUniversalCartographicsInstalled()
    {
        return this.exploration != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isRedemptionOfficeSuspended()
    {
        return (this.voucherredemption != null) && this.voucherredemption.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isRedemptionOfficeInstalled()
    {
        return this.voucherredemption != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isBlackmarketSuspended()
    {
        return (this.blackmarket != null) && this.blackmarket.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isBlackmarketInstalled()
    {
        return this.blackmarket != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isVistaGenomicsSuspended()
    {
        return (this.vistagenomics != null) && this.vistagenomics.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isVistaGenomicsInstalled()
    {
        return this.vistagenomics != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isBartenderSuspended()
    {
        return (this.bartender != null) && this.bartender.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isBartenderInstalled()
    {
        return this.bartender != null;
    }
    
    /**
     * If this service is installed but suspended by the owner
     * 
     * @return true if installed and suspended, false if not
     */
    @JsonIgnore
    public boolean isPioneerSuppliesSuspended()
    {
        return (this.pioneersupplies != null) && this.pioneersupplies.unavailable();
    }

    /**
     * If this service is installed
     * 
     * @return true if installed, false if not
     */
    @JsonIgnore
    public boolean isPioneerSuppliesInstalled()
    {
        return this.pioneersupplies != null;
    }
    
    @Data
    @Builder
    @Jacksonized
    public static class Service
    {
        private CrewMember     crewMember;
        @JsonProperty("invoicesWeekToDate")
        private List<Invoices> invoices;
        private String         status;

        @JsonIgnore
        boolean available()
        {
            return crewMember.enabled.equals(ServiceAvailability.YES);
        }
        
        @JsonIgnore
        boolean unavailable()
        {
            return crewMember.enabled.equals(ServiceAvailability.NO);
        }
    }

    @Data
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

    @Data
    @Builder
    @Jacksonized
    public static class Invoices
    {
        private int    wages;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date   from;
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date   until;
        private String type;
    }
}
