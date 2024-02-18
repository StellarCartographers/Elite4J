package elite.dangerous.journal.backpack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import elite.dangerous.Elite4J;
import elite.dangerous.journal.events.backpack.CollectItems;

public class CollectItemsTest
{
    private static String       eventJson = "{ \"timestamp\":\"2023-11-14T05:20:50Z\", \"event\":\"CollectItems\", \"Name\":\"electromagnet\", \"Type\":\"Component\", \"OwnerID\":0, \"Count\":1, \"Stolen\":false }";
    private static CollectItems event;

    @BeforeAll
    public static void setupTest() throws Exception
    {
        event = Elite4J.Journal.parse(eventJson, CollectItems.class).orElseThrow();
    }

    @Test
    public void test()
    {
        assertNotNull(event);
        assertEquals(event.name(), "electromagnet");
        assertEquals(event.type(), "Component");
        assertEquals(event.ownerID(), 0);
        assertEquals(event.count(), 1);
        assertEquals(event.stolen(), true);
    }
}
