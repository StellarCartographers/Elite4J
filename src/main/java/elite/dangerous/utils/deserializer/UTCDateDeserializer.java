package elite.dangerous.utils.deserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class UTCDateDeserializer extends TypeAdapter<Date> {
    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.toInstant().toString());
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        var j = in.nextString();
        if (j.equals("none")) {
            return null;
        }
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        var unformattedSplit = j.split("\\s+");
        var formatted        = "%sT%sZ".formatted(unformattedSplit[0], unformattedSplit[1]);
        return format.parse(formatted, new ParsePosition(0));
    }
}
