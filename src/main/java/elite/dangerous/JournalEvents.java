/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import elite.dangerous.core.Event;
import elite.dangerous.journal.NonDefinedEvent;
import elite.dangerous.util.ReflectionHelper;

final class JournalEvents extends LinkedHashMap<String, Class<? extends Event>>
{
    private static final long serialVersionUID = -2805321847199808715L;
    private List<String>      eventNames;

    public JournalEvents()
    {
        this.eventNames = new ArrayList<String>();
    }

    @SuppressWarnings("unchecked")
    public static JournalEvents mapClassNamesToObjects(String pkg, Class<? extends Event> type)
    {
        JournalEvents result = new JournalEvents();
        ReflectionHelper.getClassesFromPackage(pkg).forEach(c ->
        {
            if (type.isAssignableFrom(c))
            {
                result.putIfAbsent(c.getSimpleName(), (Class<? extends Event>) c);
                result.addEventName(c);
            }
        });
        return result;
    }

    @Override
    public Class<? extends Event> put(String key, Class<? extends Event> value)
    {
        addEventName(value);
        return super.put(key, value);
    }

    private void addEventName(Class<?> c)
    {
        if (!c.isAnnotationPresent(NonDefinedEvent.class))
        {
            if (!eventNames.contains(c.getSimpleName()))
            {
                eventNames.add(c.getSimpleName());
            }
        }
    }

    public List<String> names()
    {
        return eventNamesAsList(false);
    }

    public List<String> names(boolean alphabetical)
    {
        return eventNamesAsList(alphabetical);
    }

    private List<String> eventNamesAsList(boolean sort)
    {
        if (sort)
        {
            var sorted = new ArrayList<String>(eventNames);
            Collections.sort(sorted);
            return sorted;
        }
        return eventNames;
    }
}
