package elite.dangerous;

import java.util.LinkedHashMap;

import elite.dangerous.journal.base.Event;
import elite.dangerous.util.ReflectionHelper;
import lombok.NoArgsConstructor;

@NoArgsConstructor
final class JournalEvents extends LinkedHashMap<String, Class<? extends Event>>
{
    private static final long serialVersionUID = -2805321847199808715L;

    @SuppressWarnings("unchecked")
    public static JournalEvents mapClassNamesToObjects(String pkg, Class<? extends Event> type)
    {
        JournalEvents result = new JournalEvents();

        ReflectionHelper.getClassesFromPackage(pkg).forEach(c -> {
            if (type.isAssignableFrom(c)) {
                result.putIfAbsent(c.getSimpleName(), (Class<? extends Event>) c);
            }
        });
        return result;
    }
}
