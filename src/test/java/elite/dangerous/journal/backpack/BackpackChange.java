package elite.dangerous.journal.backpack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import elite.dangerous.Elite4J;
import elite.dangerous.journal.events.backpack.BackpackChange;

class BackpackChangeTest
{
    String removedJson = "{ \"timestamp\":\"2023-11-14T05:55:24Z\", \"event\":\"BackpackChange\", \"Removed\":[ { \"Name\":\"largecapacitypowerregulator\", \"Name_Localised\":\"Power Regulator\", \"OwnerID\":0, \"MissionID\":945537343, \"Count\":1, \"Type\":\"Item\" } ] }";
    String addedJson = "{ \"timestamp\":\"2023-11-14T06:42:07Z\", \"event\":\"BackpackChange\", \"Added\":[ { \"Name\":\"microhydraulics\", \"Name_Localised\":\"Micro Hydraulics\", \"OwnerID\":0, \"Count\":1, \"Type\":\"Component\" } ] }";
    
    @Test
    void testGenericParse_Remove()
    {
        var event = Elite4J.Journal.parse(removedJson).get();
        assertInstanceOf(BackpackChange.class, event);
    }
    
    @Test
    void testGenericParse_Added()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(addedJson).get());
        assertInstanceOf(BackpackChange.class, event);
    }
    
    @Test
    void testRemoved()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(removedJson, BackpackChange.class).get());
        assertFalse(event.removed().isEmpty());
        assertTrue(event.added().isEmpty());
    }
    
    @Test
    void testAdded()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(addedJson, BackpackChange.class).get());
        assertFalse(event.added().isEmpty());
        assertTrue(event.removed().isEmpty());
    }
}
