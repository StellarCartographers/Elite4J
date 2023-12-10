package elite.dangerous.journal.events.combat;

import lombok.EliteObject;

@EliteObject
public class DiedByPVP extends Died
{
    private String killerName;

    private String killerShip;

    private String killerRank;
}
