/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.onfoot;

public interface IDropShipDeploy
{
    public String starSystem();

    public long systemAddress();

    public String body();

    public long bodyID();

    public boolean onStation();

    public boolean onPlanet();
}
