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
