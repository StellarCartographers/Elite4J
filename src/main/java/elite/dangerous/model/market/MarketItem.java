/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.market;

import lombok.*;

@EliteCreator @EliteObject
public class MarketItem
{
    private int     id, buyPrice, sellPrice, meanPrice, stockBracket, demandBracket, stock, demand;
    private String  name, category;
    private boolean consumer, producer, rare;
}
