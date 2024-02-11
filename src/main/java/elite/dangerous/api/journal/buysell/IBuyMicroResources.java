/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.buysell;

import elite.dangerous.model.enums.ResourceCategory;

public interface IBuyMicroResources
{
    public String name();

    public ResourceCategory category();

    public int count();

    public long price();

    public long marketID();
}
