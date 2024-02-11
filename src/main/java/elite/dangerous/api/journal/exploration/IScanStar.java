/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

public interface IScanStar extends IScan
{
    public String starType();

    public String luminosity();

    public long systemAddress();

    public double stellarMass();

    public long radius();

    public double absoluteMagnitude();

    public long ageMY();

    public boolean wasMapped();

    public boolean wasDiscovered();
}
