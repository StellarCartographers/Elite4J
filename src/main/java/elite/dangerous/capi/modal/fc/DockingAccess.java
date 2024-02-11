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

public enum DockingAccess
{
    @JsonProperty("all")
    ALL,
    @JsonProperty("squadronfriends")
    SQUADRON_FRIENDS,
    @JsonProperty("friends")
    FRIENDS,
    @JsonProperty("none")
    NONE
}
