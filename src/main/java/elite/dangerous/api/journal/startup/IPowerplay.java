/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

public interface IPowerplay
{
    public String power();

    public int rank();

    public int merits();

    public int votes();

    public int timePledged();
}
