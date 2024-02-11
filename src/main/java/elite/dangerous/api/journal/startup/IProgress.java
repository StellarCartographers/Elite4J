/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.startup;

public interface IProgress
{
    public int combat();

    public int trade();

    public int explore();

    public int soldier();

    public int exobiologist();

    public int empire();

    public int federation();

    public int cqc();
}
