package elite.dangerous.capi.modal.fc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EliteObject;

@EliteObject
//!fr
@JsonPropertyOrder({
    "bankBalance", "bankReservedBalance",
    "taxation", "service_taxation",
    "numServices", "numOptionalServices",
    "debtThreshold", "maintenance",
    "maintenanceToDate", "coreCost",
    "servicesCost", "servicesCostToDate",
    "jumpsCost", "numJumps", "bartender"               
})
//@fr
public class Finance
{
    private long            balance;
    @JsonProperty("bankReservedBalance")
    private long            reservedBalance;
    private long            taxation;
    @JsonProperty("service_taxation")
    private ServiceTaxation serviceTaxation;
    private int             servicesCount;
    private long            optionalServicesCount;
    private long            debtThreshold;
    private long            maintenance;
    private long            maintenanceToDate;
    private long            coreCost;
    private long            servicesCost;
    private long            servicesCostToDate;
    private int             jumpsCost;
    private int             jumpCount;
    private Bartender       bartender;
}
