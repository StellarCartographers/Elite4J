/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc.orders;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

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
