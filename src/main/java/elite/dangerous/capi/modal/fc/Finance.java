/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import lombok.EliteObject;

import com.fasterxml.jackson.annotation.*;

@EliteObject
/* !formatter */
@JsonPropertyOrder({
    "bankBalance", "bankReservedBalance",
    "taxation", "service_taxation",
    "numServices", "numOptionalServices",
    "debtThreshold", "maintenance",
    "maintenanceToDate", "coreCost",
    "servicesCost", "servicesCostToDate",
    "jumpsCost", "numJumps", "bartender"               
})
/* @formatter */
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
