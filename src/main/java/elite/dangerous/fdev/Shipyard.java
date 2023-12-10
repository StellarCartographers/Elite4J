package elite.dangerous.fdev;

import java.util.Map;

import space.tscg.collections.map.UnalterableMap;

public final class Shipyard
{
    public static final Ship ADDER = new Ship(128049267, "Adder", "Adder");
    public static final Ship ALLIANCE_CHALLENGER = new Ship(128816588, "TypeX_3", "Alliance Challenger");
    public static final Ship ALLIANCE_CHIEFTAIN = new Ship(128816574, "TypeX", "Alliance Chieftain");
    public static final Ship ALLIANCE_CRUSADER = new Ship(128816581, "TypeX_2", "Alliance Crusader");
    public static final Ship ANACONDA = new Ship(128049363, "Anaconda", "Anaconda");
    public static final Ship ASP_EXPLORER = new Ship(128049303, "Asp", "Asp Explorer");
    public static final Ship ASP_SCOUT = new Ship(128672276, "Asp_Scout", "Asp Scout");
    public static final Ship BELUGA_LINER = new Ship(128049345, "BelugaLiner", "Beluga Liner");
    public static final Ship COBRA_MKIII = new Ship(128049279, "CobraMkIII", "Cobra MkIII");
    public static final Ship COBRA_MKIV = new Ship(128672262, "CobraMkIV", "Cobra MkIV");
    public static final Ship DIAMONDBACK_EXPLORER = new Ship(128671831, "DiamondBackXL", "Diamondback Explorer");
    public static final Ship DIAMONDBACK_SCOUT = new Ship(128671217, "DiamondBack", "Diamondback Scout");
    public static final Ship DOLPHIN = new Ship(128049291, "Dolphin", "Dolphin");
    public static final Ship EAGLE = new Ship(128049255, "Eagle", "Eagle");
    public static final Ship FEDERAL_ASSAULT_SHIP = new Ship(128672145, "Federation_Dropship_MkII", "Federal Assault Ship");
    public static final Ship FEDERAL_CORVETTE = new Ship(128049369, "Federation_Corvette", "Federal Corvette");
    public static final Ship FEDERAL_DROPSHIP = new Ship(128049321, "Federation_Dropship", "Federal Dropship");
    public static final Ship FEDERAL_GUNSHIP = new Ship(128672152, "Federation_Gunship", "Federal Gunship");
    public static final Ship FER_DE_LANCE = new Ship(128049351, "FerDeLance", "Fer-de-Lance");
    public static final Ship HAULER = new Ship(128049261, "Hauler", "Hauler");
    public static final Ship IMPERIAL_CLIPPER = new Ship(128049315, "Empire_Trader", "Imperial Clipper");
    public static final Ship IMPERIAL_COURIER = new Ship(128671223, "Empire_Courier", "Imperial Courier");
    public static final Ship IMPERIAL_CUTTER = new Ship(128049375, "Cutter", "Imperial Cutter");
    public static final Ship IMPERIAL_EAGLE = new Ship(128672138, "Empire_Eagle", "Imperial Eagle");
    public static final Ship KEELBACK = new Ship(128672269, "Independant_Trader", "Keelback");
    public static final Ship KRAIT_MKII = new Ship(128816567, "Krait_MkII", "Krait MkII");
    public static final Ship KRAIT_PHANTOM = new Ship(128839281, "Krait_Light", "Krait Phantom");
    public static final Ship MAMBA = new Ship(128915979, "Mamba", "Mamba");
    public static final Ship ORCA = new Ship(128049327, "Orca", "Orca");
    public static final Ship PYTHON = new Ship(128049339, "Python", "Python");
    public static final Ship SIDEWINDER = new Ship(128049249, "SideWinder", "Sidewinder");
    public static final Ship TYPE10_DEFENDER = new Ship(128785619, "Type9_Military", "Type-10 Defender");
    public static final Ship TYPE6_TRANSPORTER = new Ship(128049285, "Type6", "Type-6 Transporter");
    public static final Ship TYPE7_TRANSPORTER = new Ship(128049297, "Type7", "Type-7 Transporter");
    public static final Ship TYPE9_HEAVY = new Ship(128049333, "Type9", "Type-9 Heavy");
    public static final Ship VIPER =  new Ship(128049273, "Viper", "Viper MkIII");
    public static final Ship VIPER_MKIV = new Ship(128672255, "Viper_MkIV", "Viper MkIV");
    public static final Ship VULTURE = new Ship(128049309, "Vulture", "Vulture");
    
    public static Map<Integer, Ship> map = buildMap();

    private static Map<Integer, Ship> buildMap()
    {
        var builder = new UnalterableMap.Builder<Integer, Ship>();
        for( var field: Shipyard.class.getDeclaredFields())
        {
            try
            {
                Ship ship = (Ship) field.get(null);
                builder.add(ship.fdevId(), ship);
            } catch (IllegalArgumentException | IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return builder.build();
    }
    
    public static Ship getFromId(int id)
    {
        return map.get(id);
    }
}
