/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous;

import java.util.regex.*;

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
