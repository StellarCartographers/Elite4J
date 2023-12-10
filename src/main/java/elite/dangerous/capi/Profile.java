package elite.dangerous.capi;

import elite.dangerous.capi.modal.profile.Commander;
import elite.dangerous.capi.modal.profile.LastSystem;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderMethodName = "Builder")
public class Profile extends CAPIData
{
    private Commander commander;

    private LastSystem lastSystem;
}
