/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

import java.util.List;

import elite.dangerous.model.FuelCapacity;
import elite.dangerous.model.Module;

public interface ILoadout
{
    public String ship();

    public int shipID();

    public String shipName();

    public String shipIdent();

    public int hullValue();

    public int modulesValue();

    public int rebuy();

    public FuelCapacity fuelCapacity();

    public int cargoCapacity();

    public double hullHealth();

    public double maxJumpRange();

    public double unladenMass();

    public String hot();

    public List<Module> modules();
}
