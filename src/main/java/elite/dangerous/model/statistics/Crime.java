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

@EliteCreator
@EliteObject
public class Crime
{
    private long notoriety;
    private long fines;
    private long totalFines;
    private long bountiesReceived;
    private long totalBounties;
    private long highestBounty;
    private long malwareUploaded;
    private long settlementsStateShutdown;
    private long productionSabotage;
    private long productionTheft;
    private long totalMurders;
    private long citizensMurdered;
    private long omnipolMurdered;
    private long guardsMurdered;
    private long dataStolen;
    private long goodsStolen;
    private long sampleStolen;
    private long totalStolen;
    private long turretsDestroyed;
    private long turretsOverloaded;
    private long turretsTotal;
    private long valueStolenStateChange;
    private long profilesCloned;
}
