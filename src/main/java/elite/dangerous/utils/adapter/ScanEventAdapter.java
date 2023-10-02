package elite.dangerous.utils.adapter;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import elite.dangerous.journal.events.exploration.Scan;

public class ScanEventAdapter extends StdDeserializer<Scan>
{
    private static final long serialVersionUID = -5029991041773163449L;

    protected ScanEventAdapter()
    {
        super(Scan.class);
    }

    @Override
    public Scan deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException
    {
        return null;
        //        Scan event;
        //        
        //        System.out.println(p.getText());
        //        System.out.println(p.getTextLength());
        //        
        //        JsonNode node = p.getCodec().readTree(p);
        //        if(node.has("PlanetClass"))
        //        {
        //            
        //            //event = ctxt.
        //        } else {
        //            event = p.readValueAs(ScanStar.class);
        //        }
        //        
        //        return event;
    }
}
