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
public class Exploration
{
    private long   systemsVisited;
    private long   explorationProfits;
    private long   planetsScannedToLevel2;
    private long   planetsScannedToLevel3;
    private long   efficientScans;
    private long   highestPayout;
    private long   totalHyperspaceDistance;
    private long   totalHyperspaceJumps;
    private double greatestDistanceFromStart;
    private long   timePlayed;
    private long   onFootDistanceTravelled;
    private long   shuttleJourneys;
    private double shuttleDistanceTravelled;
    private long   spentOnShuttles;
    private long   firstFootfalls;
    private long   planetFootfalls;
    private long   settlementsVisited;
}
