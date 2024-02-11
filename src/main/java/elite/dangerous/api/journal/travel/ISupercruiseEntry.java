/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.travel;

public interface ISupercruiseEntry
{
    public String starSystem();

    public boolean taxi();

    public boolean multicrew();

    public long systemAddress();
}
