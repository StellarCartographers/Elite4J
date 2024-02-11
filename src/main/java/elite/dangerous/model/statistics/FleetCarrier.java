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
public class FleetCarrier
{
    private long   exportTotal;
    private long   importTotal;
    private long   tradeprofitTotal;
    private long   tradespendTotal;
    private long   stolenprofitTotal;
    private long   stolenspendTotal;
    private double distanceTravelled;
    private long   totalJumps;
    private long   shipyardSold;
    private long   shipyardProfit;
    private long   outfittingSold;
    private long   outfittingProfit;
    private long   rearmTotal;
    private long   refuelTotal;
    private long   refuelProfit;
    private long   repairsTotal;
    private long   vouchersRedeemed;
    private long   vouchersProfit;
}
