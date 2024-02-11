/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

public interface IFSSSignalDiscovered
{
    public String signalName();

    public String ussType();

    public String spawningState();

    public String spawningFaction();

    public int threatLevel();

    public long systemAddress();

    public double timeRemaining();

    public boolean isStation();
}
