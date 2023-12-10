package elite.dangerous.model.statistics;

import lombok.EliteObject;

@EliteObject
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