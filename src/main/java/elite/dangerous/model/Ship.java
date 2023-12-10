package elite.dangerous.model;

import elite.dangerous.fdev.FDevID;
import lombok.EliteObject;
import lombok.Value;

@Value
@EliteObject
public class Ship
{
    private FDevID id;
    private String symbol;
    private String name;
}
