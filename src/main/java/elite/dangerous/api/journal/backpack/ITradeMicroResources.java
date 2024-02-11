/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.backpack;

import java.util.List;

import elite.dangerous.model.MicroResource;
import elite.dangerous.model.enums.ResourceCategory;

public interface ITradeMicroResources
{
    public List<MicroResource> offered();

    public String received();

    public int count();

    public long marketID();

    public ResourceCategory category();
}
