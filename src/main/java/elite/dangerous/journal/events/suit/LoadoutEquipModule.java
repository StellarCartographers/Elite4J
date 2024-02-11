/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.suit;

import lombok.*;

import java.util.ArrayList;

import elite.dangerous.core.Suit;

@EliteObject 
public class LoadoutEquipModule extends Suit
{

    private String           slotName;

    private String           moduleName;

    private int              tier;

    public ArrayList<String> weaponMods;

    private long             suitModuleID;
}
