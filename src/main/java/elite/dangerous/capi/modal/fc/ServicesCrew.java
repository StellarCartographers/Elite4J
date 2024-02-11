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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@EliteObject
/* !formatter */
@JsonPropertyOrder({
  "refuel", "repair",
  "rearm", "outfitting",
  "shipyard", "blackmarket",
  "voucherredemption", "exploration",
  "bartender", "vistagenomics",
  "pioneersupplies"             
})
/* @formatter */
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
}
