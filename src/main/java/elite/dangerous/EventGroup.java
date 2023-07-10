package elite.dangerous;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

import elite.dangerous.base.Event;
import elite.dangerous.utils.Constant;

public enum EventGroup
{

    BACKPACK("backpack"),
    BOOK("book"),
    BUYSELL("buysell"),
    COMBAT("combat"),
    EXPLORATION("exploration"),
    FLEETCARRIERS("fleetcarriers"),
    ONFOOT("onfoot"),
    OTHER("other"),
    POWERPLAY("powerplay"),
    SQUADRON("squadron"),
    STARTUP("startup"),
    STATIONSERVICES("stationservices"),
    SUIT("suit"),
    TRADE("trade"),
    TRAVEL("travel"),
    ALL(BACKPACK, BOOK, BUYSELL, COMBAT, EXPLORATION, FLEETCARRIERS, ONFOOT, OTHER, POWERPLAY, SQUADRON, STARTUP, STATIONSERVICES, SUIT, TRADE, TRAVEL);

    Set<Class<? extends Trigger>> classSet;
    boolean                     write = false;

    EventGroup(EventGroup... groups)
    {
        Set<Class<? extends Trigger>> set = new HashSet<>();
        for (EventGroup group : groups)
        {
            set.addAll(group.classSet);
        }
        this.classSet = set;
    }

    EventGroup(String packageName)
    {
        this.classSet = Constant.R.getSubTypesOf(Trigger.class);
        this.write = true;
    }

    @SuppressWarnings("unchecked")
    public Set<Class<? extends Event>> getClassSet()
    {
        return classSet.stream().map(l -> (Class<? extends Event>)l).collect(Collectors.toSet());
    }

    public static Map<Class<? extends Event>, Trigger> getMap()
    {
        try
        {
            return Maps.asMap(EventGroup.ALL.getClassSet(), EventGroup::create);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static Trigger create(Class<? extends Event> event)
    {
        try
        {
            return (Trigger) event.getDeclaredConstructor().newInstance();
        } catch (Exception e)
        {
            throw new RuntimeException("Encountered ERROR instantiating Event: " + event.getSimpleName());
        }
    }
}
