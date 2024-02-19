package elite.dangerous.util;

import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.*;

public record Functions()
{

    public static String Capitalize(String word)
    {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static <E> ListBuilder<E> listBuilder()
    {
        return new ListBuilder<E>();
    }

    public static <K, V> MapBuilder<K, V> mapBuilder()
    {
        return new MapBuilder<K, V>();
    }
    public static class MapBuilder<K, V>
    {
        private Map<K, V> builderMap = new HashMap<>();

        public MapBuilder<K, V> add(K k, V v)
        {
            this.builderMap.put(k, v);
            return this;
        }

        public Map<K, V> build()
        {
            return UnmodifiableMap.unmodifiableMap(builderMap);
        }
    }

    public static class ListBuilder<E>
    {
        private List<E> builderList = new ArrayList<>();

        public ListBuilder<E> add(E e)
        {
            this.builderList.add(e);
            return this;
        }

        public List<E> build()
        {
            return UnmodifiableList.unmodifiableList(builderList);
        }
    }
}
