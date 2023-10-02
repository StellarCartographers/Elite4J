package elite.dangerous.capi;

import elite.dangerous.capi.modal.profile.Commander;
import elite.dangerous.capi.modal.profile.LastSystem;
import lombok.Getter;

@Getter
public class CAPIProfile
{
    private Commander  commander;
    private LastSystem lastSystem;
}
