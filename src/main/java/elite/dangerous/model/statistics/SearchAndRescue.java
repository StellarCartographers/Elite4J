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
public class SearchAndRescue
{
    private long searchRescueTraded;
    private long searchRescueProfit;
    private long searchRescueCount;
    private long salvageLegalPOI;
    private long salvageLegalSettlements;
    private long salvageIllegalPOI;
    private long salvageIllegalSettlements;
    private long maglocksOpened;
    private long panelsOpened;
    private long settlementsStateFireOut;
    private long settlementsStateReboot;
}
