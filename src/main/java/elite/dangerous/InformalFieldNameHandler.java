package elite.dangerous;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class InformalFieldNameHandler
{
    final String regex = "_Localised";

    final String subst = "";

    final String result;

    private InformalFieldNameHandler(String json)
    {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(json);
        final String result = matcher.replaceAll(subst);
        this.result = result;
    }

    public static String parse(String jsonString)
    {
        return new InformalFieldNameHandler(jsonString).result;
    }
}
