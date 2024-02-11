/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.core.file;

import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.model.PriceItem;
import lombok.EliteObject;

@EliteObject
public class Shipyard extends Event
{

    private long            marketID;

    private String          stationName, starSystem;

    private boolean         horizons;

    private boolean         allowCobraMkIV;

    private List<PriceItem> priceList;
}
