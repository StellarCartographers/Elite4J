/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.statistics;

import lombok.*;

@EliteCreator @EliteObject
public class BankAccount
{
    private long currentWealth;
    private long spentOnShips;
    private long spentOnOutfitting;
    private long spentOnRepairs;
    private long spentOnFuel;
    private long spentOnAmmoConsumables;
    private long insuranceClaims;
    private long spentOnInsurance;
    private long ownedShipCount;
    private long spentOnSuits;
    private long spentOnWeapons;
    private long spentOnSuitConsumables;
    private long suitsOwned;
    private long weaponsOwned;
    private long spentOnPremiumStock;
    private long premiumStockBought;
}
