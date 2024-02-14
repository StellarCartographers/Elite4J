package elite.dangerous.util;

public record Functions()
{
    public static String Capitalize(String word)
    {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
