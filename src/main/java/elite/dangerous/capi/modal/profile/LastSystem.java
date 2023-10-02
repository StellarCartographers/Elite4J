package elite.dangerous.capi.modal.profile;

import lombok.Getter;

@Getter
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
