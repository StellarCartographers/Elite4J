package elite.dangerous.capi.modal.profile;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderMethodName = "Builder")
public class Commander
{
    private int    id;
    private String name;
    
    public String getId()
    {
        return String.valueOf(id);
    }
}
