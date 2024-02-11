/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

public interface ILoadGame
{
    public String commander();

    public String fid();

    public String ship();

    public String shipName();

    public String shipIdent();

    public String gameMode();

    public String group();

    public int shipID();

    public double fuelLevel();

    public double fuelCapacity();

    public long credits();

    public long loan();

    public boolean horizons();

    public boolean startLanded();

    public boolean startDead();
}
