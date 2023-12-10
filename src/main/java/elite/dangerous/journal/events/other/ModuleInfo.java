package elite.dangerous.journal.events.other;

import java.util.List;

import elite.dangerous.journal.base.Event;
import elite.dangerous.model.Module;
import lombok.EliteObject;

@EliteObject
public class ModuleInfo extends Event
{

    private List<Module> modules;

}
