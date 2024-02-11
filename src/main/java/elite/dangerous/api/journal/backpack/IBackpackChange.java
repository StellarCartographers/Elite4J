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

import elite.dangerous.model.backpack.BackpackItem;

/**
 * This is written when there is any change to the contents of the suit backpack
 * 
 * @apiNote note this can be written at the same time as other events like
 *          {@link elite.dangerous.journal.backpack.UseConsumable UseConsumable}
 */
public interface IBackpackChange
{
    public List<BackpackItem> added();

    public List<BackpackItem> removed();
}
