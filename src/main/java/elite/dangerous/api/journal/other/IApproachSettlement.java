/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.other;

public interface IApproachSettlement
{
    public String name();

    public String bodyName();

    public int bodyID();

    public double latitude();

    public double longitude();

    public long marketID();

    public long systemAddress();
}
