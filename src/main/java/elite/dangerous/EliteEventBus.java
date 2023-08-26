package elite.dangerous;

import com.google.common.eventbus.EventBus;

public class EliteEventBus {
    private EventBus eventBusImpl;
    private boolean notActive;

    static EliteEventBus nonOperational()
    {
        return new EliteEventBus(true);
    }
    
    boolean alreadyActive()
    {
        return this.notActive==false;
    }
    
    void setActive()
    {
        this.notActive = false;
    }
    
    EliteEventBus(boolean notActive) {
        this.eventBusImpl = new EventBus();
        this.notActive = notActive;
    }

    public void register(Object object) {
        if (notActive)
            return;
        eventBusImpl.register(object);
    }

    public void unregister(Object object) {
        if (notActive)
            return;
        eventBusImpl.unregister(object);
    }

    public void post(Object event) {
        if (notActive)
            return;
        eventBusImpl.post(event);
    }
}
