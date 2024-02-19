/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.journal;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.atteo.classindex.IndexSubclasses;

import elite.dangerous.Elite4J;
import elite.dangerous.util.*;

@IndexSubclasses
@EliteObject(ObjectType.PARENT)
public class Event implements EliteType
{
    @JsonProperty("timestamp")
    private EventTimestamp timestamp;

    public String toJson()
    {
        return Elite4J.ObjToString(this);
    }
}
