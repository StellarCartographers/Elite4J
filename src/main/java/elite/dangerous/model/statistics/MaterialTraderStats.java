package elite.dangerous.model.statistics;

import lombok.EliteObject;

@EliteObject
public class MaterialTraderStats
{

    private long tradesCompleted;

    private long materialsTraded;

    private long encodedMaterialsTraded;

    private long rawMaterialsTraded;

    private long grade1MaterialsTraded;

    private long grade2MaterialsTraded;

    private long grade3MaterialsTraded;

    private long grade4MaterialsTraded;

    private long grade5MaterialsTraded;

    private long assetsTradedIn;

    private long assetsTradedOut;
}