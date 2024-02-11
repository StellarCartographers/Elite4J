/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal.events.other;

import lombok.*;

import java.util.ArrayList;

import elite.dangerous.core.Event;
import elite.dangerous.model.LockerItem;

@EliteObject 
public class ShipLocker extends Event
{

    private ArrayList<LockerItem> items;

    private ArrayList<LockerItem> components;

    private ArrayList<LockerItem> consumables;

    private ArrayList<LockerItem> data;
}
