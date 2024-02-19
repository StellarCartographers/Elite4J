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
