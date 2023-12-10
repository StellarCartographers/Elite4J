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
    UNAVAILABLE,
}