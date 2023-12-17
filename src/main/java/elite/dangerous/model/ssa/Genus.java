package elite.dangerous.model.ssa;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EliteObject;

@EliteObject
public class Genus
{
    @JsonProperty("genus")
    private String name;
}
