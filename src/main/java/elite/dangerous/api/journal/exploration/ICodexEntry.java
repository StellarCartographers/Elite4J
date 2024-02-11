/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

public interface ICodexEntry
{
    public String name();

    public String subCategory();

    public String category();

    public String region();

    public String system();

    public int entryID();

    public long systemAddress();

    public boolean isNewEntry();

    public boolean newTraitsDiscovered();

    public String[] traits();

    public String nearestDestination();
}
