/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.fdev;

import java.util.Map;

import elite.dangerous.model.Ship;
import elite.dangerous.model.identity.ID;
import elite.dangerous.util.*;

public final class Shipyard
{
    public static final Ship      ADDER                = create(128049267, "Adder", "Adder");
    public static final Ship      ALLIANCE_CHALLENGER  = create(128816588, "TypeX_3", "Alliance Challenger");
    public static final Ship      ALLIANCE_CHIEFTAIN   = create(128816574, "TypeX", "Alliance Chieftain");
    public static final Ship      ALLIANCE_CRUSADER    = create(128816581, "TypeX_2", "Alliance Crusader");
    public static final Ship      ANACONDA             = create(128049363, "Anaconda", "Anaconda");
    public static final Ship      ASP_EXPLORER         = create(128049303, "Asp", "Asp Explorer");
    public static final Ship      ASP_SCOUT            = create(128672276, "Asp_Scout", "Asp Scout");
    public static final Ship      BELUGA_LINER         = create(128049345, "BelugaLiner", "Beluga Liner");
    public static final Ship      COBRA_MKIII          = create(128049279, "CobraMkIII", "Cobra MkIII");
    public static final Ship      COBRA_MKIV           = create(128672262, "CobraMkIV", "Cobra MkIV");
    public static final Ship      DIAMONDBACK_EXPLORER = create(128671831, "DiamondBackXL", "Diamondback Explorer");
    public static final Ship      DIAMONDBACK_SCOUT    = create(128671217, "DiamondBack", "Diamondback Scout");
    public static final Ship      DOLPHIN              = create(128049291, "Dolphin", "Dolphin");
    public static final Ship      EAGLE                = create(128049255, "Eagle", "Eagle");
    public static final Ship      FEDERAL_ASSAULT_SHIP = create(128672145, "Federation_Dropship_MkII", "Federal Assault Ship");
    public static final Ship      FEDERAL_CORVETTE     = create(128049369, "Federation_Corvette", "Federal Corvette");
    public static final Ship      FEDERAL_DROPSHIP     = create(128049321, "Federation_Dropship", "Federal Dropship");
    public static final Ship      FEDERAL_GUNSHIP      = create(128672152, "Federation_Gunship", "Federal Gunship");
    public static final Ship      FER_DE_LANCE         = create(128049351, "FerDeLance", "Fer-de-Lance");
    public static final Ship      HAULER               = create(128049261, "Hauler", "Hauler");
    public static final Ship      IMPERIAL_CLIPPER     = create(128049315, "Empire_Trader", "Imperial Clipper");
    public static final Ship      IMPERIAL_COURIER     = create(128671223, "Empire_Courier", "Imperial Courier");
    public static final Ship      IMPERIAL_CUTTER      = create(128049375, "Cutter", "Imperial Cutter");
    public static final Ship      IMPERIAL_EAGLE       = create(128672138, "Empire_Eagle", "Imperial Eagle");
    public static final Ship      KEELBACK             = create(128672269, "Independant_Trader", "Keelback");
    public static final Ship      KRAIT_MKII           = create(128816567, "Krait_MkII", "Krait MkII");
    public static final Ship      KRAIT_PHANTOM        = create(128839281, "Krait_Light", "Krait Phantom");
    public static final Ship      MAMBA                = create(128915979, "Mamba", "Mamba");
    public static final Ship      ORCA                 = create(128049327, "Orca", "Orca");
    public static final Ship      PYTHON               = create(128049339, "Python", "Python");
    public static final Ship      SIDEWINDER           = create(128049249, "SideWinder", "Sidewinder");
    public static final Ship      TYPE10_DEFENDER      = create(128785619, "Type9_Military", "Type-10 Defender");
    public static final Ship      TYPE6_TRANSPORTER    = create(128049285, "Type6", "Type-6 Transporter");
    public static final Ship      TYPE7_TRANSPORTER    = create(128049297, "Type7", "Type-7 Transporter");
    public static final Ship      TYPE9_HEAVY          = create(128049333, "Type9", "Type-9 Heavy");
    public static final Ship      VIPER                = create(128049273, "Viper", "Viper MkIII");
    public static final Ship      VIPER_MKIV           = create(128672255, "Viper_MkIV", "Viper MkIV");
    public static final Ship      VULTURE              = create(128049309, "Vulture", "Vulture");
    public static Map<Long, Ship> map;
    static
    {
        Functions.MapBuilder<Long, Ship> builder = Functions.mapBuilder();
        for (var field : ReflectionHelper.getAllFieldsOfType(Shipyard.class, Ship.class))
        {
            try
            {
                Ship ship = (Ship) field.get(null);
                builder.add(ship.id().asLong(), ship);
            } catch (IllegalArgumentException | IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        map = builder.build();
    }

    private static Ship create(long id, String symbol, String name)
    {
        return Ship.Creator().id(new ID(id)).symbol(symbol).name(name).create();
    }

    public static Ship getFromId(long id)
    {
        return map.get(id);
    }
}
