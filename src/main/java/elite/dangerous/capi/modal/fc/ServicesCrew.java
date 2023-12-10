package elite.dangerous.capi.modal.fc;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EliteObject;

@EliteObject
//!fr
@JsonPropertyOrder({
  "refuel", "repair",
  "rearm", "outfitting",
  "shipyard", "blackmarket",
  "voucherredemption", "exploration",
  "bartender", "vistagenomics",
  "pioneersupplies"             
})
//@fr
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
