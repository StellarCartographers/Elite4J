package elite.dangerous.model.statistics;

import lombok.EliteObject;

@EliteObject
public class Trading
{
    private long marketProfits;
    private long averageProfit;
    private long marketsTradedWith;
    private long resourcesTraded;
    private long highestSingleTransaction;
}
