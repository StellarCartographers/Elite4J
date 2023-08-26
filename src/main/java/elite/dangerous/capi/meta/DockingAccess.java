package elite.dangerous.capi.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public enum DockingAccess
{
    @SerializedName("all")
    @JsonProperty("all")
    ALL,
    @SerializedName("squadronfriends")
    @JsonProperty("squadronfriends")
    SQUADRON_FRIENDS,
    @SerializedName("friends")
    @JsonProperty("friends")
    FRIENDS,
    @SerializedName("none")
    @JsonProperty("none")
    NONE
}
