package elite.dangerous.capi.modal.profile;

import lombok.Getter;

@Getter
public class Commander
{
    private int    id;
    private String name;
    
    public String getId()
    {
        return String.valueOf(id);
    }
}
