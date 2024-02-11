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

@EliteObject
public class MicroResourcePurchase implements Purchase
{
    private String  name;
    private String  locName;
    private int     total;
    private int     outstanding;
    private int     price;
}