/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.exploration;

public interface IScreenshot
{
    public String filename();

    public String system();

    public String body();

    public int width();

    public int height();

    public int heading();

    public double latitude();

    public double longitude();

    public double altitude();
}
