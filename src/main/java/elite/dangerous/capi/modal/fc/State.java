/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.capi.modal.fc;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum State
{
    @JsonProperty("ok")
    OK,
    @JsonProperty("private")
    PRIVATE,
    @JsonProperty("unmanned")
    UNMANNED,
    @JsonProperty("unavailable")
    UNAVAILABLE;
    
    public boolean notEquals(State state)
    {
        return this != state;
    }
}