package elite.dangerous.model.statistics;

import lombok.EliteObject;

@EliteObject
public class Smuggling
{
    private long blackMarketsTradedWith;
    private long blackMarketsProfits;
    private long resourcesSmuggled;
    private long averageProfit;
    private long highestSingleTransaction;
}
