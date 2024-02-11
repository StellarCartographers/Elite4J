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

import elite.dangerous.model.scan.Ring;

public interface IScan
{
    public String scanType();

    public String bodyName();

    public int bodyID();

    public String starSystem();

    public double distanceFromArrivalLS();

    public double rotationPeriod();

    public double surfaceTemperature();

    public List<Ring> rings();

    public long semiMajorAxis();

    public double eccentricity();

    public double orbitalInclination();

    public double periapsis();

    public long orbitalPeriod();

    public boolean wasDiscovered();

    public boolean wasMapped();
}
