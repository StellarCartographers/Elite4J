/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.*;

import java.io.IOException;

class JsonOutputFormatter extends DefaultPrettyPrinter
{
    private static final long        serialVersionUID = 1L;
    static final JsonOutputFormatter _INSTANCE        = new JsonOutputFormatter();

    JsonOutputFormatter()
    {
        this._objectFieldValueSeparatorWithSpaces = "" + this._separators.getObjectFieldValueSeparator() + "";
        this.withObjectIndenter(new DefaultIndenter("  ", DefaultIndenter.SYS_LF));
    }

    JsonOutputFormatter(DefaultPrettyPrinter base)
    {
        super(base);
    }

    @Override
    public void writeStartObject(JsonGenerator g) throws IOException
    {
        _objectIndenter.writeIndentation(g, _nesting);
        super.writeStartObject(g);
    }

    @Override
    public void writeStartArray(JsonGenerator g) throws IOException
    {
        _arrayIndenter.writeIndentation(g, _nesting);
        super.writeStartArray(g);
    }

    @Override
    public DefaultPrettyPrinter createInstance()
    {
        return new JsonOutputFormatter(this);
    }
}
