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

import java.util.List;

@EliteObject
public class Bartender
{
    private long       microresourcesTotalValue;
    private long       allTimeProfit;
    private long       microresourcesForSale;
    private long       microresourcesPurchaseOrders;
    private long       balanceAllocForPurchaseOrders;
    private List<Long> profitHistory;
}