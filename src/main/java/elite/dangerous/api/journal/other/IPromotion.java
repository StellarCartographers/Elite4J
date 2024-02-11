/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.other;

public interface IPromotion
{
    public int combat();

    public int trade();

    public int explore();

    public int cqc();

    public int federation();

    public int empire();
}
