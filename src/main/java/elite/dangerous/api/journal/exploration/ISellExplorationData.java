/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

public interface ISellExplorationData
{
    public String[] systems();

    public String[] discovered();

    public int baseValue();

    public int bonus();

    public int totalEarnings();
}
