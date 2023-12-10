package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject public class Finance
{

    private int carrierBalance;

    private int reserveBalance;

    private int availableBalance;

    private int reservePercent;

    private int taxRate;
}
