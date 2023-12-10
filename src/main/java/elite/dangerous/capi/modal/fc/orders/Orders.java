package elite.dangerous.capi.modal.fc.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EliteObject;

@EliteObject
public class Orders
{
    private CommodityLedger commodities;
    @JsonProperty("onfootmicroresources")
    private MicroResourceLedger microResources;
}
