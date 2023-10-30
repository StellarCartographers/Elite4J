package elite.dangerous.capi.modal.profile;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderMethodName = "Builder")
public class LastSystem
{
    public long   id;
    public String name;
    public String faction;

    public String getId()
    {
        return String.valueOf(id);
    }
}
