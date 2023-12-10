package elite.dangerous.capi.modal.fc.orders;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EliteObject;

@EliteObject
public class MicroResourceLedger
{
    private List<MicroResourceSale>    sales;
    private List<MicroResourcePurchase> purchases;
    
    @JsonIgnore
    public boolean isSelling()
    {
        return !sales.isEmpty();
    }
    
    @JsonIgnore
    public boolean isBuying()
    {
        return !purchases.isEmpty();
    }
}