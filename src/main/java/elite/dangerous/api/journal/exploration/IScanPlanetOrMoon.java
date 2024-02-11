/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

import java.util.List;

import elite.dangerous.model.scan.*;

public interface IScanPlanetOrMoon extends IScan
{
    public double axialTilt();

    public String terraformState();

    public String planetClass();

    public String atmosphere();

    public String atmosphereType();

    public String volcanism();

    public String reserveLevel();

    public double massEM();

    public double surfaceGravity();

    public double surfacePressure();

    public int subclass();

    public boolean tidalLock();

    public boolean landable();

    public Parents parents();

    public List<AtmosphereItem> atmosphereComposition();

    public List<Material> materials();

    public Composition composition();
}
