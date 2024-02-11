/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.core;

import org.atteo.classindex.IndexSubclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import elite.dangerous.Elite4J;
import elite.dangerous.util.EliteType;
import elite.dangerous.util.EventTimestamp;
import lombok.EliteObject;
import lombok.ObjectType;
import space.tscg.api.JsonWrapper;

@IndexSubclasses
@EliteObject(ObjectType.PARENT)
public class Event implements JsonWrapper, EliteType
{
    @JsonProperty("timestamp")
    private EventTimestamp timestamp;

    @Override
    public String toJson()
    {
        return Elite4J.ObjToString(this);
    }
}
