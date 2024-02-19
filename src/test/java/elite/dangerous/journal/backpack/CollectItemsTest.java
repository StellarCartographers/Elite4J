package elite.dangerous.journal.backpack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import elite.dangerous.Elite4J;
import elite.dangerous.journal.events.backpack.*;

public class CollectItemsTest
{
    String eventJson = "{ \"timestamp\":\"2023-11-14T05:20:50Z\", \"event\":\"CollectItems\", \"Name\":\"electromagnet\", \"Type\":\"Component\", \"OwnerID\":0, \"Count\":1, \"Stolen\":false }";

    @Test
    void testGenericParse()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(eventJson).get());
        assertInstanceOf(CollectItems.class, event);
    }
    
    @Test
    public void test()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(eventJson, CollectItems.class).get());
        assertNotNull(event);
        assertEquals(event.name(), "electromagnet");
        assertEquals(event.type(), "Component");
        assertEquals(event.ownerID(), 0);
        assertEquals(event.count(), 1);
        assertEquals(event.stolen(), false);
    }
}
