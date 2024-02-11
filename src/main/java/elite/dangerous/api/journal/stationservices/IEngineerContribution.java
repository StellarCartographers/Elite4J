/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

public interface IEngineerContribution
{
    public String engineer();

    public String type();

    public String commodity();

    public String faction();

    public String material();

    public int engineerID();

    public int quantity();

    public int totalQuantity();
}
