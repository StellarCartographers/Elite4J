package elite.dangerous.journal.backpack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import elite.dangerous.Elite4J;
import elite.dangerous.journal.events.backpack.*;

class TradeMicroResourcesTest
{
    String multiOffered = "{ \"timestamp\":\"2023-03-24T19:30:48Z\", \"event\":\"TradeMicroResources\", \"Offered\":[ { \"Name\":\"encryptedmemorychip\", \"Name_Localised\":\"Encrypted Memory Chip\", \"Category\":\"Component\", \"Count\":3 }, { \"Name\":\"opticallens\", \"Name_Localised\":\"Optical Lens\", \"Category\":\"Component\", \"Count\":2 }, { \"Name\":\"memorychip\", \"Name_Localised\":\"Memory Chip\", \"Category\":\"Component\", \"Count\":4 }, { \"Name\":\"microthrusters\", \"Name_Localised\":\"Micro Thrusters\", \"Category\":\"Component\", \"Count\":4 }, { \"Name\":\"titaniumplating\", \"Name_Localised\":\"Titanium Plating\", \"Category\":\"Component\", \"Count\":3 }, { \"Name\":\"weaponcomponent\", \"Name_Localised\":\"Weapon Component\", \"Category\":\"Component\", \"Count\":7 }, { \"Name\":\"microhydraulics\", \"Name_Localised\":\"Micro Hydraulics\", \"Category\":\"Component\", \"Count\":3 }, { \"Name\":\"transmitter\", \"Category\":\"Component\", \"Count\":3 }, { \"Name\":\"carbonfibreplating\", \"Name_Localised\":\"Carbon Fibre Plating\", \"Category\":\"Component\", \"Count\":3 } ], \"TotalCount\":32, \"Received\":\"tungstencarbide\", \"Received_Localised\":\"Tungsten Carbide\", \"Count\":14, \"Category\":\"Component\", \"MarketID\":3229756160 }";
    String singleOffered = "{ \"timestamp\":\"2023-11-14T11:02:25Z\", \"event\":\"TradeMicroResources\", \"Offered\":[ { \"Name\":\"weaponcomponent\", \"Name_Localised\":\"Weapon Component\", \"Category\":\"Component\", \"Count\":11 } ], \"TotalCount\":11, \"Received\":\"tungstencarbide\", \"Received_Localised\":\"Tungsten Carbide\", \"Count\":10, \"Category\":\"Component\", \"MarketID\":3225947648 }";
    
    @Test
    void testGenericParse_Multi()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(multiOffered).get());
        assertInstanceOf(TradeMicroResources.class, event);
    }
    
    @Test
    void testGenericParse_Single()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(singleOffered).get());
        assertInstanceOf(TradeMicroResources.class, event);
    }
    
    @Test
    void testMultipleOffered()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(multiOffered, TradeMicroResources.class).get());
        assertNotNull(event);
        assertEquals(9, event.offered().size());
    }
    
    @Test
    void testSingleOffered()
    {
        var event = assertDoesNotThrow(() -> Elite4J.Journal.parse(singleOffered, TradeMicroResources.class).get());
        assertNotNull(event);
        assertEquals(1, event.offered().size());
    }
}
