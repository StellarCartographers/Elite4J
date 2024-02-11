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

@EliteObject
public class Finances
{
    private long cargoTotalValue;
    private long allTimeProfit;
    private int  numCommodsForSale;
    private int  numCommodsPurchaseOrders;
    private long balanceAllocForPurchaseOrders;
}
