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
import elite.dangerous.model.LoadoutModule;

@EliteObject 
public class SwitchSuitLoadout extends Suit
{

    public ArrayList<String>        suitMods;

    public ArrayList<LoadoutModule> modules;
}
