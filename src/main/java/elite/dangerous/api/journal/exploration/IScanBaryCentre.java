/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

public interface IScanBaryCentre
{
    public int bodyID();

    public String starSystem();

    public long systemAddress();

    public double semiMajorAxis();

    public double eccentricity();

    public double orbitalInclination();

    public double periapsis();

    public double orbitalPeriod();

    public double ascendingNode();

    public double meanAnomaly();
}
