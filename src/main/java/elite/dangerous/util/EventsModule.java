package elite.dangerous.util;

import com.fasterxml.jackson.databind.module.SimpleModule;

public final class EventsModule extends SimpleModule
{
    private static final long            serialVersionUID = -462450205000087703L;

    private volatile static EventsModule instance;

    public static EventsModule instance()
    {
        if (instance == null)
        {
            synchronized (EventsModule.class)
            {
                if (instance == null)
                {
                    instance = new EventsModule();
                }
            }
        }
        return instance;
    }

    private EventsModule()
    {
        //this.addDeserializer(EventTimestamp.class, new TimeStampAdapter.Deserializer());
        //this.addSerializer(EventTimestamp.class, new TimeStampAdapter.Serializer());
    }
}
