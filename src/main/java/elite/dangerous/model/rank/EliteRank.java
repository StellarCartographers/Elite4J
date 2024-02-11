/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.rank;

public enum EliteRank
{
    I,
    II,
    III,
    IV,
    V;

    @Override
    public String toString()
    {
        return "%s %s".formatted(getClass().getSimpleName(), super.toString());
    }
}
