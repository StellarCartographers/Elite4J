package elite.dangerous.model;

import lombok.EliteObject;

@EliteObject
public class Modification
{
    private String  label;
    private double  value;
    private String  valueStr;
    private double  originalValue;
    private boolean lessIsGood;
}
