/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.statistics;

import lombok.*;

@EliteCreator
@EliteObject
public class Trading
{
    private long marketProfits;
    private long averageProfit;
    private long marketsTradedWith;
    private long resourcesTraded;
    private long highestSingleTransaction;
}
