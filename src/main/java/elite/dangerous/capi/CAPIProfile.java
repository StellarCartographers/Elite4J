package elite.dangerous.capi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import elite.dangerous.capi.modal.profile.Commander;
import elite.dangerous.capi.modal.profile.LastSystem;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"commander", "lastSystem"})
@Getter
public class CAPIProfile
{
    private Commander  commander;
    private LastSystem lastSystem;
}
