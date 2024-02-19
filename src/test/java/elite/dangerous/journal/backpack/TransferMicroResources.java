package elite.dangerous.journal.backpack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import elite.dangerous.Elite4J;
import elite.dangerous.journal.EventTest;
import elite.dangerous.journal.events.backpack.*;

class TransferMicroResourcesTest extends EventTest
{
    String json = "{ \"timestamp\":\"2021-04-14T15:07:54Z\", \"event\":\"TransferMicroResources\", \"Transfers\":[ { \"Name\":\"healthpack\", \"Name_Localised\":\"Medkit\", \"Category\":\"Consumable\", \"Count\":1, \"Direction\":\"ToBackpack\" }, { \"Name\":\"energycell\", \"Name_Localised\":\"Energy Cell\", \"Category\":\"Consumable\", \"Count\":1, \"Direction\":\"ToBackpack\" } ] }";

    @Override
    @Test
    protected void testGenericParse()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(json).get());
        assertInstanceOf(TransferMicroResources.class, event);
    }

    @Disabled
    @Test
    void test()
    {
        fail("Not yet implemented");
    }


}
