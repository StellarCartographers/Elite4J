package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class BioDataItem
{
    private String genus;
    private String species;
    private long   value;
    private long   bonus;
}
