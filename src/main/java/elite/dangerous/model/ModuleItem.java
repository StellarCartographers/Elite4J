package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class ModuleItem
{
    private String  slot;
    private String  name;
    private String  engineerModifications;
    private boolean hot;
    private int     engineeredLevel;
    private double  quality;
}
