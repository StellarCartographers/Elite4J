package elite.dangerous.capi.modal.fc.orders;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CommodityLedger
{
    private List<CommoditySale>     sales;
    private List<CommodityPurchase> purchases;

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
