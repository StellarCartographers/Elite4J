/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.api.journal.travel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import elite.dangerous.journal.events.travel.Undocked;

@JsonDeserialize(as = Undocked.class)
public interface IUndocked
{
    String stationName();

    String stationType();;

    long marketID();
}
