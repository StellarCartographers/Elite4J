/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.stationservices;

import java.util.Date;

public interface IMissionAccepted
{
    public String faction();

    public String name();

    public String localisedName();

    public String targetFaction();

    public String destinationSystem();

    public String destinationStation();

    public String influence();

    public String reputation();

    public long reward();

    public long missionID();

    public Date expiry();
}
