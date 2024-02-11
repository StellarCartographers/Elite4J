/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.suit;

import java.util.ArrayList;

public interface ILoadoutEquipModule extends ISuit
{
    public String slotName();

    public String moduleName();

    public int tier();

    public ArrayList<String> weaponMods();

    public long suitModuleID();
}
