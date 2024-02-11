/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.buysell;

import java.util.ArrayList;

import elite.dangerous.model.BioDataItem;

public interface ISellOrganicData
{
    public int marketID();

    public ArrayList<BioDataItem> bioData();
}
