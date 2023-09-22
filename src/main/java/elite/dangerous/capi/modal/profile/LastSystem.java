package elite.dangerous.capi.modal.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "faction"})
@Getter
public class LastSystem
{
    @JsonProperty("id")
    public long   id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("faction")
    public String faction;

    public String getId()
    {
        return String.valueOf(id);
    }
}
