package elite.dangerous.journal.events.powerplay;

import java.util.List;

import elite.dangerous.journal.base.Event;
import lombok.EliteObject;

@EliteObject
public class PowerplayVoucher extends Event
{

    private String       power;

    private List<String> systems;

}
