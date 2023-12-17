package elite.dangerous.model.statistics;

import lombok.EliteObject;

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
