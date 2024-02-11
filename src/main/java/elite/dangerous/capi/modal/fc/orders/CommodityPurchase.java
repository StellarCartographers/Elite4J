/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc.orders;

import lombok.EliteObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

@EliteObject
public class CommodityPurchase implements Purchase
{
    private String  name;
    private int     total;
    private int     outstanding;
    private int     price;
    private boolean blackmarket;
    
    @JsonIgnore
    public static Legality<CommodityPurchase> Legality()
    {
        return purchase -> purchase.blackmarket();
    }
}