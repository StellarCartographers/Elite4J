package elite.dangerous.fdevid;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import space.tscg.collections.map.UnalterableMap;

public final class Shipyard
{
    @Data
    @Builder
    @Jacksonized
    public static class Ship
    {
        private int    fdevId;
        private String symbol;
        private String name;
    }

    private static Map<Integer, Ship> map = buildMap();

    private static Map<Integer, Ship> buildMap()
    {
        var internalMap = new HashMap<Integer, Ship>();
        internalMap.put(128049249, new Ship(128049249, "SideWinder", "Sidewinder"));
        internalMap.put(128049255, new Ship(128049255, "Eagle", "Eagle"));
        internalMap.put(128049261, new Ship(128049261, "Hauler", "Hauler"));
        internalMap.put(128049267, new Ship(128049267, "Adder", "Adder"));
        internalMap.put(128049273, new Ship(128049273, "Viper", "Viper MkIII"));
        internalMap.put(128049279, new Ship(128049279, "CobraMkIII", "Cobra MkIII"));
        internalMap.put(128049285, new Ship(128049285, "Type6", "Type-6 Transporter"));
        internalMap.put(128049291, new Ship(128049291, "Dolphin", "Dolphin"));
        internalMap.put(128049297, new Ship(128049297, "Type7", "Type-7 Transporter"));
        internalMap.put(128049303, new Ship(128049303, "Asp", "Asp Explorer"));
        internalMap.put(128049309, new Ship(128049309, "Vulture", "Vulture"));
        internalMap.put(128049315, new Ship(128049315, "Empire_Trader", "Imperial Clipper"));
        internalMap.put(128049321, new Ship(128049321, "Federation_Dropship", "Federal Dropship"));
        internalMap.put(128049327, new Ship(128049327, "Orca", "Orca"));
        internalMap.put(128049333, new Ship(128049333, "Type9", "Type-9 Heavy"));
        internalMap.put(128049339, new Ship(128049339, "Python", "Python"));
        internalMap.put(128049345, new Ship(128049345, "BelugaLiner", "Beluga Liner"));
        internalMap.put(128049351, new Ship(128049351, "FerDeLance", "Fer-de-Lance"));
        internalMap.put(128049363, new Ship(128049363, "Anaconda", "Anaconda"));
        internalMap.put(128049369, new Ship(128049369, "Federation_Corvette", "Federal Corvette"));
        internalMap.put(128049375, new Ship(128049375, "Cutter", "Imperial Cutter"));
        internalMap.put(128671217, new Ship(128671217, "DiamondBack", "Diamondback Scout"));
        internalMap.put(128671223, new Ship(128671223, "Empire_Courier", "Imperial Courier"));
        internalMap.put(128671831, new Ship(128671831, "DiamondBackXL", "Diamondback Explorer"));
        internalMap.put(128672138, new Ship(128672138, "Empire_Eagle", "Imperial Eagle"));
        internalMap.put(128672145, new Ship(128672145, "Federation_Dropship_MkII", "Federal Assault Ship"));
        internalMap.put(128672152, new Ship(128672152, "Federation_Gunship", "Federal Gunship"));
        internalMap.put(128672255, new Ship(128672255, "Viper_MkIV", "Viper MkIV"));
        internalMap.put(128672262, new Ship(128672262, "CobraMkIV", "Cobra MkIV"));
        internalMap.put(128672269, new Ship(128672269, "Independant_Trader", "Keelback"));
        internalMap.put(128672276, new Ship(128672276, "Asp_Scout", "Asp Scout"));
        internalMap.put(128785619, new Ship(128785619, "Type9_Military", "Type-10 Defender"));
        internalMap.put(128816567, new Ship(128816567, "Krait_MkII", "Krait MkII"));
        internalMap.put(128816574, new Ship(128816574, "TypeX", "Alliance Chieftain"));
        internalMap.put(128816581, new Ship(128816581, "TypeX_2", "Alliance Crusader"));
        internalMap.put(128816588, new Ship(128816588, "TypeX_3", "Alliance Challenger"));
        internalMap.put(128839281, new Ship(128839281, "Krait_Light", "Krait Phantom"));
        internalMap.put(128915979, new Ship(128915979, "Mamba", "Mamba"));
        return UnalterableMap.unalterableMap(internalMap);
    }
    
    public static Shipyard.Ship getFromId(int id)
    {
        return map.get(id);
    }
}
