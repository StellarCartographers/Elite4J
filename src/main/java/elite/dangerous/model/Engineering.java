package elite.dangerous.model;

import java.util.List;

import lombok.EliteObject;

@EliteObject public class Engineering
{

    private String engineer, blueprintName, experimentalEffect;

    private int engineerID, blueprintID, level;

    private double quality;

    private List<Modification> modifications;
}
