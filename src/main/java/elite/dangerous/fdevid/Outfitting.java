package elite.dangerous.fdevid;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.jetbrains.annotations.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import space.tscg.api.carrier.ICarrierModule;
import space.tscg.collections.list.UnalterableList;
import space.tscg.collections.map.UnalterableMap;
import space.tscg.misc.StringUtil;

public final class Outfitting
{
    public enum DamageType
    {
        THERMAL,
        KINETIC,
        EXPLOSIVE,
        ABSOLUTE,;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public enum Type
    {
        // CORE
        POWER_PLANT,
        THRUSTERS,
        FRAME_SHIFT_DRIVE,
        LIFE_SUPPORT,
        POWER_DISTRIBUTOR,
        SENSORS,
        FUEL_TANK, // ALSO AN INTERNAL MODULE
        ARMOUR,

        // INTERNAL
        AUTO_FIELD_MAINTENANCE_UNIT("Auto Field-Maintenance Unit"),
        CARGO_RACK,
        CORROSION_RESISTANT_CARGO_RACK,
        DETAILED_SURFACE_SCANNER,
        DISCOVERY_SCANNER,
        FIGHTER_HANGAR,
        FRAME_SHIFT_DRIVE_INTERDICTOR,
        FUEL_SCOOP,
        GUARDIAN_FRAME_SHIFT_DRIVE_BOOSTER,
        GUARDIAN_HULL_REINFORCEMENT,
        GUARDIAN_MODULE_REINFORCEMENT,
        GUARDIAN_SHIELD_REINFORCEMENT,
        HULL_REINFORCEMENT,
        COLLECTOR_LIMPET_CONTROLLER,
        DECONTAMINATION_LIMPET_CONTROLLER,
        FUEL_TRANSFER_LIMPET_CONTROLLER,
        HATCH_BREAKER_LIMPET_CONTROLLER,
        PROSPECTOR_LIMPET_CONTROLLER,
        RECON_LIMPET_CONTROLLER,
        REPAIR_LIMPET_CONTROLLER,
        RESEARCH_LIMPET_CONTROLLER,
        MULTI_LIMPET_CONTROLLER,
        META_ALLOY_HULL_REINFORCEMENT,
        MODULE_REINFORCEMENT,
        PASSENGER_CABIN,
        PLANETARY_VEHICLE_HANGAR,
        REFINERY,
        SHIELD_CELL_BANK,
        SHIELD_GENERATOR,
        BI_WEAVE_SHIELD_GENERATOR("Bi-Weave Shield Generator"),
        ADVANCED_DOCKING_COMPUTER,
        STANDARD_DOCKING_COMPUTER,

        // UTILITY
        AX_XENO_SCANNER,
        CHAFF_LAUNCHER,
        ELECTRONIC_COUNTERMEASURE,
        FRAME_SHIFT_WAKE_SCANNER,
        HEATSINK_LAUNCHER,
        KILL_WARRANT_SCANNER,
        MANIFEST_SCANNER,
        POINT_DEFENCE_TURRET,
        PULSE_WAVE_ANALYSER,
        SHIELD_BOOSTER,
        SHUTDOWN_FIELD_NEUTRALISER,

        // WEAPONS
        BEAM_LASER,
        PULSE_LASER,
        BURST_LASER,
        CANNON,
        MULTI_CANNON("Multi-Cannon"),
        FRAGMENT_CANNON,
        SHOCK_CANNON,
        REMOTE_RELEASE_FLECHETTE_LAUNCHER,
        REMOTE_RELEASE_FLAK_LAUNCHER,
        RAILGUN,
        PLASMA_ACCELERATOR,
        MISSILE_RACK,
        SEEKER_MISSILE_RACK,
        TORPEDO_PYLON,
        MINE_LAUNCHER,
        SHOCK_MINE_LAUNCHER,
        ENZYME_MISSILE_RACK,
        ABRASION_BLASTER,
        MINING_LASER,
        SUB_SURFACE_DISPLACEMENT_MISSILE("Sub-Surface Displacement Missile"),
        SEISMIC_CHARGE_LAUNCHER,
        
        UNKNOWN,
        ;
        
        String name;

        public String formattedName()
        {
            if(name == null)
            {
                var l = super.toString().replace("_", " ");
                String[] s = l.split(" ");
                for (int i = 0; i < s.length; i++) {
                    s[i] = StringUtil.capitalize(s[i]);
                }
                return String.join(" ", s);
            }
            
            return name;
        }
        
        public static Type getType(Module module)
        {
            switch (module.getCategory()) {
                case STANDARD: {
                    for(var l : CoreList())
                    {
                        if(l.formattedName().equals(module.getName()))
                            return l;
                    }
                }
                case INTERNAL: {
                    for(var l : InternalList())
                    {
                        if(l.formattedName().equals(module.getName()))
                            return l;
                    }
                }
                case UTILITY: {
                    for(var l : UtilityList())
                    {
                        if(l.formattedName().equals(module.getName()))
                            return l;
                    }
                }
                case HARDPOINT: {
                    for(var l : WeaponList())
                    {
                        if(l.formattedName().equals(module.getName()))
                            return l;
                    }
                }
                default: return UNKNOWN;
            }
        }

        public static List<Type> CoreList()
        {
            EnumSet<Type> e = EnumSet.range(POWER_PLANT, ARMOUR);
            return new UnalterableList<Type>(Arrays.asList(e.toArray(new Type[0])));
        }
        
        public static List<Type> InternalList()
        {
            EnumSet<Type> e = EnumSet.range(AUTO_FIELD_MAINTENANCE_UNIT, STANDARD_DOCKING_COMPUTER);
            e.add(FUEL_TANK);
            return new UnalterableList<Type>(Arrays.asList(e.toArray(new Type[0])));
        }
        
        public static List<Type> UtilityList()
        {
            EnumSet<Type> e = EnumSet.range(AX_XENO_SCANNER, SHUTDOWN_FIELD_NEUTRALISER);
            return new UnalterableList<Type>(Arrays.asList(e.toArray(new Type[0])));
        }
        
        public static List<Type> WeaponList()
        {
            EnumSet<Type> e = EnumSet.range(BEAM_LASER, SEISMIC_CHARGE_LAUNCHER);
            return new UnalterableList<Type>(Arrays.asList(e.toArray(new Type[0])));
        }
    }

    public enum Category
    {
        STANDARD(Type.CoreList()),
        INTERNAL(Type.InternalList()),
        UTILITY(Type.UtilityList()),
        HARDPOINT(Type.WeaponList()),
        ;

        List<Type> list;
        
        Category(List<Type> list)
        {
            this.list = list;
        }
        
        @Override
        public String toString()
        {
            return StringUtil.capitalize(super.toString().toLowerCase());
        }
    }

    public enum Rating
    {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,;
    }

    public enum Mount
    {
        FIXED,
        TURRETED,
        GIMBALLED,;

        @Override
        public String toString()
        {
            return StringUtil.capitalize(super.toString().toLowerCase());
        }
    }

    public enum Guidance
    {
        DUMBFIRE,
        SEEKER,
        SWARM,;

        @Override
        public String toString()
        {
            return StringUtil.capitalize(super.toString().toLowerCase());
        }
    }

    @Data
    public static class Module
    {
        private String        symbol;
        private Category      category;
        private String        name;
        @Nullable
        private Mount         mount;
        @Nullable
        private Guidance      guidance;
        private Shipyard.Ship ship;
        private int           moduleClass;
        private Rating        rating;

        @Builder
        @Jacksonized
        private Module(String symbol, Category category, String name, @Nullable Mount mount, @Nullable Guidance guidance, Integer shipId, int moduleClass, Rating rating)
        {
            this.symbol = symbol;
            this.category = category;
            this.name = name;
            this.mount = mount;
            this.guidance = guidance;
            this.moduleClass = moduleClass;
            this.rating = rating;
            if (shipId != null) {
                this.ship = Shipyard.getFromId(shipId);
            } else {
                this.ship = null;
            }
        }

        private Module(String symbol, Category category, String name, @Nullable Mount mount, Integer shipId, int moduleClass, Rating rating)
        {
            this(symbol, category, name, mount, null, shipId, moduleClass, rating);
        }

        private Module(String symbol, Category category, String name, Integer shipId, int moduleClass, Rating rating)
        {
            this(symbol, category, name, null, null, shipId, moduleClass, rating);
        }

    }

    private static Map<Integer, Module> map = buildMap();

    private static Map<Integer, Module> buildMap()
    {
        var internalMap = new HashMap<Integer, Module>();
        internalMap.put(128049250, new Module("SideWinder_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049249, 1, Rating.I));
        internalMap.put(128049251, new Module("SideWinder_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049249, 1, Rating.I));
        internalMap.put(128049252, new Module("SideWinder_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049249, 1, Rating.I));
        internalMap.put(128049253, new Module("SideWinder_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049249, 1, Rating.I));
        internalMap.put(128049254, new Module("SideWinder_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049249, 1, Rating.I));
        internalMap.put(128049256, new Module("Eagle_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049255, 1, Rating.I));
        internalMap.put(128049257, new Module("Eagle_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049255, 1, Rating.I));
        internalMap.put(128049258, new Module("Eagle_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049255, 1, Rating.I));
        internalMap.put(128049259, new Module("Eagle_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049255, 1, Rating.I));
        internalMap.put(128049260, new Module("Eagle_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049255, 1, Rating.I));
        internalMap.put(128049262, new Module("Hauler_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049261, 1, Rating.I));
        internalMap.put(128049263, new Module("Hauler_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049261, 1, Rating.I));
        internalMap.put(128049264, new Module("Hauler_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049261, 1, Rating.I));
        internalMap.put(128049265, new Module("Hauler_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049261, 1, Rating.I));
        internalMap.put(128049266, new Module("Hauler_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049261, 1, Rating.I));
        internalMap.put(128049268, new Module("Adder_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049267, 1, Rating.I));
        internalMap.put(128049269, new Module("Adder_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049267, 1, Rating.I));
        internalMap.put(128049270, new Module("Adder_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049267, 1, Rating.I));
        internalMap.put(128049271, new Module("Adder_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049267, 1, Rating.I));
        internalMap.put(128049272, new Module("Adder_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049267, 1, Rating.I));
        internalMap.put(128049274, new Module("Viper_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049273, 1, Rating.I));
        internalMap.put(128049275, new Module("Viper_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049273, 1, Rating.I));
        internalMap.put(128049276, new Module("Viper_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049273, 1, Rating.I));
        internalMap.put(128049277, new Module("Viper_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049273, 1, Rating.I));
        internalMap.put(128049278, new Module("Viper_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049273, 1, Rating.I));
        internalMap.put(128049280, new Module("CobraMkIII_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049279, 1, Rating.I));
        internalMap.put(128049281, new Module("CobraMkIII_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049279, 1, Rating.I));
        internalMap.put(128049282, new Module("CobraMkIII_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049279, 1, Rating.I));
        internalMap.put(128049283, new Module("CobraMkIII_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049279, 1, Rating.I));
        internalMap.put(128049284, new Module("CobraMkIII_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049279, 1, Rating.I));
        internalMap.put(128049286, new Module("Type6_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049285, 1, Rating.I));
        internalMap.put(128049287, new Module("Type6_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049285, 1, Rating.I));
        internalMap.put(128049288, new Module("Type6_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049285, 1, Rating.I));
        internalMap.put(128049289, new Module("Type6_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049285, 1, Rating.I));
        internalMap.put(128049290, new Module("Type6_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049285, 1, Rating.I));
        internalMap.put(128049292, new Module("Dolphin_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049291, 1, Rating.I));
        internalMap.put(128049293, new Module("Dolphin_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049291, 1, Rating.I));
        internalMap.put(128049294, new Module("Dolphin_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049291, 1, Rating.I));
        internalMap.put(128049295, new Module("Dolphin_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049291, 1, Rating.I));
        internalMap.put(128049296, new Module("Dolphin_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049291, 1, Rating.I));
        internalMap.put(128049298, new Module("Type7_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049297, 1, Rating.I));
        internalMap.put(128049299, new Module("Type7_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049297, 1, Rating.I));
        internalMap.put(128049300, new Module("Type7_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049297, 1, Rating.I));
        internalMap.put(128049301, new Module("Type7_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049297, 1, Rating.I));
        internalMap.put(128049302, new Module("Type7_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049297, 1, Rating.I));
        internalMap.put(128049304, new Module("Asp_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049303, 1, Rating.I));
        internalMap.put(128049305, new Module("Asp_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049303, 1, Rating.I));
        internalMap.put(128049306, new Module("Asp_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049303, 1, Rating.I));
        internalMap.put(128049307, new Module("Asp_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049303, 1, Rating.I));
        internalMap.put(128049308, new Module("Asp_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049303, 1, Rating.I));
        internalMap.put(128049310, new Module("Vulture_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049309, 1, Rating.I));
        internalMap.put(128049311, new Module("Vulture_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049309, 1, Rating.I));
        internalMap.put(128049312, new Module("Vulture_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049309, 1, Rating.I));
        internalMap.put(128049313, new Module("Vulture_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049309, 1, Rating.I));
        internalMap.put(128049314, new Module("Vulture_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049309, 1, Rating.I));
        internalMap.put(128049316, new Module("Empire_Trader_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049315, 1, Rating.I));
        internalMap.put(128049317, new Module("Empire_Trader_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049315, 1, Rating.I));
        internalMap.put(128049318, new Module("Empire_Trader_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049315, 1, Rating.I));
        internalMap.put(128049319, new Module("Empire_Trader_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049315, 1, Rating.I));
        internalMap.put(128049320, new Module("Empire_Trader_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049315, 1, Rating.I));
        internalMap.put(128049322, new Module("Federation_Dropship_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049321, 1, Rating.I));
        internalMap.put(128049323, new Module("Federation_Dropship_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049321, 1, Rating.I));
        internalMap.put(128049324, new Module("Federation_Dropship_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049321, 1, Rating.I));
        internalMap.put(128049325, new Module("Federation_Dropship_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049321, 1, Rating.I));
        internalMap.put(128049326, new Module("Federation_Dropship_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049321, 1, Rating.I));
        internalMap.put(128049328, new Module("Orca_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049327, 1, Rating.I));
        internalMap.put(128049329, new Module("Orca_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049327, 1, Rating.I));
        internalMap.put(128049330, new Module("Orca_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049327, 1, Rating.I));
        internalMap.put(128049331, new Module("Orca_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049327, 1, Rating.I));
        internalMap.put(128049332, new Module("Orca_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049327, 1, Rating.I));
        internalMap.put(128049334, new Module("Type9_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049333, 1, Rating.I));
        internalMap.put(128049335, new Module("Type9_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049333, 1, Rating.I));
        internalMap.put(128049336, new Module("Type9_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049333, 1, Rating.I));
        internalMap.put(128049337, new Module("Type9_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049333, 1, Rating.I));
        internalMap.put(128049338, new Module("Type9_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049333, 1, Rating.I));
        internalMap.put(128049340, new Module("Python_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049339, 1, Rating.I));
        internalMap.put(128049341, new Module("Python_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049339, 1, Rating.I));
        internalMap.put(128049342, new Module("Python_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049339, 1, Rating.I));
        internalMap.put(128049343, new Module("Python_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049339, 1, Rating.I));
        internalMap.put(128049344, new Module("Python_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049339, 1, Rating.I));
        internalMap.put(128049346, new Module("BelugaLiner_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049345, 1, Rating.I));
        internalMap.put(128049347, new Module("BelugaLiner_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049345, 1, Rating.I));
        internalMap.put(128049348, new Module("BelugaLiner_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049345, 1, Rating.I));
        internalMap.put(128049349, new Module("BelugaLiner_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049345, 1, Rating.I));
        internalMap.put(128049350, new Module("BelugaLiner_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049345, 1, Rating.I));
        internalMap.put(128049352, new Module("FerDeLance_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049351, 1, Rating.I));
        internalMap.put(128049353, new Module("FerDeLance_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049351, 1, Rating.I));
        internalMap.put(128049354, new Module("FerDeLance_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049351, 1, Rating.I));
        internalMap.put(128049355, new Module("FerDeLance_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049351, 1, Rating.I));
        internalMap.put(128049356, new Module("FerDeLance_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049351, 1, Rating.I));
        internalMap.put(128049364, new Module("Anaconda_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049363, 1, Rating.I));
        internalMap.put(128049365, new Module("Anaconda_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049363, 1, Rating.I));
        internalMap.put(128049366, new Module("Anaconda_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049363, 1, Rating.I));
        internalMap.put(128049367, new Module("Anaconda_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049363, 1, Rating.I));
        internalMap.put(128049368, new Module("Anaconda_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049363, 1, Rating.I));
        internalMap.put(128049370, new Module("Federation_Corvette_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049369, 1, Rating.I));
        internalMap.put(128049371, new Module("Federation_Corvette_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049369, 1, Rating.I));
        internalMap.put(128049372, new Module("Federation_Corvette_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049369, 1, Rating.I));
        internalMap.put(128049373, new Module("Federation_Corvette_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049369, 1, Rating.I));
        internalMap.put(128049374, new Module("Federation_Corvette_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049369, 1, Rating.I));
        internalMap.put(128049376, new Module("Cutter_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128049375, 1, Rating.I));
        internalMap.put(128049377, new Module("Cutter_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128049375, 1, Rating.I));
        internalMap.put(128049378, new Module("Cutter_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128049375, 1, Rating.I));
        internalMap.put(128049379, new Module("Cutter_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128049375, 1, Rating.I));
        internalMap.put(128049380, new Module("Cutter_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128049375, 1, Rating.I));
        internalMap.put(128049381, new Module("Hpt_PulseLaser_Fixed_Small", Category.HARDPOINT, "Pulse Laser", Mount.FIXED, null, 1, Rating.F));
        internalMap.put(128049382, new Module("Hpt_PulseLaser_Fixed_Medium", Category.HARDPOINT, "Pulse Laser", Mount.FIXED, null, 2, Rating.E));
        internalMap.put(128049383, new Module("Hpt_PulseLaser_Fixed_Large", Category.HARDPOINT, "Pulse Laser", Mount.FIXED, null, 3, Rating.D));
        internalMap.put(128049384, new Module("Hpt_PulseLaser_Fixed_Huge", Category.HARDPOINT, "Pulse Laser", Mount.FIXED, null, 4, Rating.A));
        internalMap.put(128049385, new Module("Hpt_PulseLaser_Gimbal_Small", Category.HARDPOINT, "Pulse Laser", Mount.GIMBALLED, null, 1, Rating.G));
        internalMap.put(128049386, new Module("Hpt_PulseLaser_Gimbal_Medium", Category.HARDPOINT, "Pulse Laser", Mount.GIMBALLED, null, 2, Rating.F));
        internalMap.put(128049387, new Module("Hpt_PulseLaser_Gimbal_Large", Category.HARDPOINT, "Pulse Laser", Mount.GIMBALLED, null, 3, Rating.E));
        internalMap.put(128049388, new Module("Hpt_PulseLaser_Turret_Small", Category.HARDPOINT, "Pulse Laser", Mount.TURRETED, null, 1, Rating.G));
        internalMap.put(128049389, new Module("Hpt_PulseLaser_Turret_Medium", Category.HARDPOINT, "Pulse Laser", Mount.TURRETED, null, 2, Rating.F));
        internalMap.put(128049390, new Module("Hpt_PulseLaser_Turret_Large", Category.HARDPOINT, "Pulse Laser", Mount.TURRETED, null, 3, Rating.F));
        internalMap.put(128049400, new Module("Hpt_PulseLaserBurst_Fixed_Small", Category.HARDPOINT, "Burst Laser", Mount.FIXED, null, 1, Rating.F));
        internalMap.put(128049401, new Module("Hpt_PulseLaserBurst_Fixed_Medium", Category.HARDPOINT, "Burst Laser", Mount.FIXED, null, 2, Rating.E));
        internalMap.put(128049402, new Module("Hpt_PulseLaserBurst_Fixed_Large", Category.HARDPOINT, "Burst Laser", Mount.FIXED, null, 3, Rating.D));
        internalMap.put(128049403, new Module("Hpt_PulseLaserBurst_Fixed_Huge", Category.HARDPOINT, "Burst Laser", Mount.FIXED, null, 4, Rating.E));
        internalMap.put(128049404, new Module("Hpt_PulseLaserBurst_Gimbal_Small", Category.HARDPOINT, "Burst Laser", Mount.GIMBALLED, null, 1, Rating.G));
        internalMap.put(128049405, new Module("Hpt_PulseLaserBurst_Gimbal_Medium", Category.HARDPOINT, "Burst Laser", Mount.GIMBALLED, null, 2, Rating.F));
        internalMap.put(128049406, new Module("Hpt_PulseLaserBurst_Gimbal_Large", Category.HARDPOINT, "Burst Laser", Mount.GIMBALLED, null, 3, Rating.E));
        internalMap.put(128049407, new Module("Hpt_PulseLaserBurst_Turret_Small", Category.HARDPOINT, "Burst Laser", Mount.TURRETED, null, 1, Rating.G));
        internalMap.put(128049408, new Module("Hpt_PulseLaserBurst_Turret_Medium", Category.HARDPOINT, "Burst Laser", Mount.TURRETED, null, 2, Rating.F));
        internalMap.put(128049409, new Module("Hpt_PulseLaserBurst_Turret_Large", Category.HARDPOINT, "Burst Laser", Mount.TURRETED, null, 3, Rating.E));
        internalMap.put(128049428, new Module("Hpt_BeamLaser_Fixed_Small", Category.HARDPOINT, "Beam Laser", Mount.FIXED, null, 1, Rating.E));
        internalMap.put(128049429, new Module("Hpt_BeamLaser_Fixed_Medium", Category.HARDPOINT, "Beam Laser", Mount.FIXED, null, 2, Rating.D));
        internalMap.put(128049430, new Module("Hpt_BeamLaser_Fixed_Large", Category.HARDPOINT, "Beam Laser", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128049431, new Module("Hpt_BeamLaser_Fixed_Huge", Category.HARDPOINT, "Beam Laser", Mount.FIXED, null, 4, Rating.A));
        internalMap.put(128049432, new Module("Hpt_BeamLaser_Gimbal_Small", Category.HARDPOINT, "Beam Laser", Mount.GIMBALLED, null, 1, Rating.E));
        internalMap.put(128049433, new Module("Hpt_BeamLaser_Gimbal_Medium", Category.HARDPOINT, "Beam Laser", Mount.GIMBALLED, null, 2, Rating.D));
        internalMap.put(128049434, new Module("Hpt_BeamLaser_Gimbal_Large", Category.HARDPOINT, "Beam Laser", Mount.GIMBALLED, null, 3, Rating.C));
        internalMap.put(128049435, new Module("Hpt_BeamLaser_Turret_Small", Category.HARDPOINT, "Beam Laser", Mount.TURRETED, null, 1, Rating.F));
        internalMap.put(128049436, new Module("Hpt_BeamLaser_Turret_Medium", Category.HARDPOINT, "Beam Laser", Mount.TURRETED, null, 2, Rating.E));
        internalMap.put(128049437, new Module("Hpt_BeamLaser_Turret_Large", Category.HARDPOINT, "Beam Laser", Mount.TURRETED, null, 3, Rating.D));
        internalMap.put(128049438, new Module("Hpt_Cannon_Fixed_Small", Category.HARDPOINT, "Cannon", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128049439, new Module("Hpt_Cannon_Fixed_Medium", Category.HARDPOINT, "Cannon", Mount.FIXED, null, 2, Rating.D));
        internalMap.put(128049440, new Module("Hpt_Cannon_Fixed_Large", Category.HARDPOINT, "Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128049441, new Module("Hpt_Cannon_Fixed_Huge", Category.HARDPOINT, "Cannon", Mount.FIXED, null, 4, Rating.B));
        internalMap.put(128049442, new Module("Hpt_Cannon_Gimbal_Small", Category.HARDPOINT, "Cannon", Mount.GIMBALLED, null, 1, Rating.E));
        internalMap.put(128049443, new Module("Hpt_Cannon_Gimbal_Medium", Category.HARDPOINT, "Cannon", Mount.GIMBALLED, null, 2, Rating.D));
        internalMap.put(128049444, new Module("Hpt_Cannon_Gimbal_Huge", Category.HARDPOINT, "Cannon", Mount.GIMBALLED, null, 4, Rating.B));
        internalMap.put(128049445, new Module("Hpt_Cannon_Turret_Small", Category.HARDPOINT, "Cannon", Mount.TURRETED, null, 1, Rating.F));
        internalMap.put(128049446, new Module("Hpt_Cannon_Turret_Medium", Category.HARDPOINT, "Cannon", Mount.TURRETED, null, 2, Rating.E));
        internalMap.put(128049447, new Module("Hpt_Cannon_Turret_Large", Category.HARDPOINT, "Cannon", Mount.TURRETED, null, 3, Rating.D));
        internalMap.put(128049448, new Module("Hpt_Slugshot_Fixed_Small", Category.HARDPOINT, "Fragment Cannon", Mount.FIXED, null, 1, Rating.E));
        internalMap.put(128049449, new Module("Hpt_Slugshot_Fixed_Medium", Category.HARDPOINT, "Fragment Cannon", Mount.FIXED, null, 2, Rating.A));
        internalMap.put(128049450, new Module("Hpt_Slugshot_Fixed_Large", Category.HARDPOINT, "Fragment Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128049451, new Module("Hpt_Slugshot_Gimbal_Small", Category.HARDPOINT, "Fragment Cannon", Mount.GIMBALLED, null, 1, Rating.E));
        internalMap.put(128049452, new Module("Hpt_Slugshot_Gimbal_Medium", Category.HARDPOINT, "Fragment Cannon", Mount.GIMBALLED, null, 2, Rating.D));
        internalMap.put(128049453, new Module("Hpt_Slugshot_Turret_Small", Category.HARDPOINT, "Fragment Cannon", Mount.TURRETED, null, 1, Rating.E));
        internalMap.put(128049454, new Module("Hpt_Slugshot_Turret_Medium", Category.HARDPOINT, "Fragment Cannon", Mount.TURRETED, null, 2, Rating.D));
        internalMap.put(128049455, new Module("Hpt_MultiCannon_Fixed_Small", Category.HARDPOINT, "Multi-Cannon", Mount.FIXED, null, 1, Rating.F));
        internalMap.put(128049456, new Module("Hpt_MultiCannon_Fixed_Medium", Category.HARDPOINT, "Multi-Cannon", Mount.FIXED, null, 2, Rating.E));
        internalMap.put(128049457, new Module("Hpt_MultiCannon_Fixed_Large", Category.HARDPOINT, "Multi-Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128049458, new Module("Hpt_MultiCannon_Fixed_Huge", Category.HARDPOINT, "Multi-Cannon", Mount.FIXED, null, 4, Rating.A));
        internalMap.put(128049459, new Module("Hpt_MultiCannon_Gimbal_Small", Category.HARDPOINT, "Multi-Cannon", Mount.GIMBALLED, null, 1, Rating.G));
        internalMap.put(128049460, new Module("Hpt_MultiCannon_Gimbal_Medium", Category.HARDPOINT, "Multi-Cannon", Mount.GIMBALLED, null, 2, Rating.F));
        internalMap.put(128049461, new Module("Hpt_MultiCannon_Gimbal_Large", Category.HARDPOINT, "Multi-Cannon", Mount.GIMBALLED, null, 3, Rating.C));
        internalMap.put(128049462, new Module("Hpt_MultiCannon_Turret_Small", Category.HARDPOINT, "Multi-Cannon", Mount.TURRETED, null, 1, Rating.G));
        internalMap.put(128049463, new Module("Hpt_MultiCannon_Turret_Medium", Category.HARDPOINT, "Multi-Cannon", Mount.TURRETED, null, 2, Rating.F));
        internalMap.put(128049464, new Module("Hpt_MultiCannon_Turret_Large", Category.HARDPOINT, "Multi-Cannon", Mount.TURRETED, null, 3, Rating.E));
        internalMap.put(128049465, new Module("Hpt_PlasmaAccelerator_Fixed_Medium", Category.HARDPOINT, "Plasma Accelerator", Mount.FIXED, null, 2, Rating.C));
        internalMap.put(128049466, new Module("Hpt_PlasmaAccelerator_Fixed_Large", Category.HARDPOINT, "Plasma Accelerator", Mount.FIXED, null, 3, Rating.B));
        internalMap.put(128049467, new Module("Hpt_PlasmaAccelerator_Fixed_Huge", Category.HARDPOINT, "Plasma Accelerator", Mount.FIXED, null, 4, Rating.A));
        internalMap.put(128049488, new Module("Hpt_Railgun_Fixed_Small", Category.HARDPOINT, "Rail Gun", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128049489, new Module("Hpt_Railgun_Fixed_Medium", Category.HARDPOINT, "Rail Gun", Mount.FIXED, null, 2, Rating.B));
        internalMap.put(128049492, new Module("Hpt_BasicMissileRack_Fixed_Small", Category.HARDPOINT, "Seeker Missile Rack", Mount.FIXED, Guidance.SEEKER, null, 1, Rating.B));
        internalMap.put(128049493, new Module("Hpt_BasicMissileRack_Fixed_Medium", Category.HARDPOINT, "Seeker Missile Rack", Mount.FIXED, Guidance.SEEKER, null, 2, Rating.B));
        internalMap.put(128049494, new Module("Hpt_BasicMissileRack_Fixed_Large", Category.HARDPOINT, "Seeker Missile Rack", Mount.FIXED, Guidance.SEEKER, null, 3, Rating.A));
        internalMap.put(128049500, new Module("Hpt_MineLauncher_Fixed_Small", Category.HARDPOINT, "Mine Launcher", Mount.FIXED, null, 1, Rating.I));
        internalMap.put(128049501, new Module("Hpt_MineLauncher_Fixed_Medium", Category.HARDPOINT, "Mine Launcher", Mount.FIXED, null, 2, Rating.I));
        internalMap.put(128049509, new Module("Hpt_AdvancedTorpPylon_Fixed_Small", Category.HARDPOINT, "Torpedo Pylon", Mount.FIXED, Guidance.SEEKER, null, 1, Rating.I));
        internalMap.put(128049510, new Module("Hpt_AdvancedTorpPylon_Fixed_Medium", Category.HARDPOINT, "Torpedo Pylon", Mount.FIXED, Guidance.SEEKER, null, 2, Rating.I));
        internalMap.put(128049511, new Module("Hpt_AdvancedTorpPylon_Fixed_Large", Category.HARDPOINT, "Torpedo Pylon", Mount.FIXED, Guidance.SEEKER, null, 3, Rating.I));
        internalMap.put(128049513, new Module("Hpt_ChaffLauncher_Tiny", Category.UTILITY, "Chaff Launcher", null, 0, Rating.I));
        internalMap.put(128049516, new Module("Hpt_ElectronicCountermeasure_Tiny", Category.UTILITY, "Electronic Countermeasure", null, 0, Rating.F));
        internalMap.put(128049519, new Module("Hpt_HeatSinkLauncher_Turret_Tiny", Category.UTILITY, "Heat Sink Launcher", null, 0, Rating.I));
        internalMap.put(128049522, new Module("Hpt_PlasmaPointDefence_Turret_Tiny", Category.UTILITY, "Point Defence", null, 0, Rating.I));
        internalMap.put(128049525, new Module("Hpt_MiningLaser_Fixed_Small", Category.HARDPOINT, "Mining Laser", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128049526, new Module("Hpt_MiningLaser_Fixed_Medium", Category.HARDPOINT, "Mining Laser", Mount.FIXED, null, 2, Rating.D));
        internalMap.put(128049549, new Module("Int_DockingComputer_Standard", Category.INTERNAL, "Standard Docking Computer", null, 1, Rating.E));
        internalMap.put(128064033, new Module("Int_Powerplant_Size2_Class1", Category.STANDARD, "Power Plant", null, 2, Rating.E));
        internalMap.put(128064034, new Module("Int_Powerplant_Size2_Class2", Category.STANDARD, "Power Plant", null, 2, Rating.D));
        internalMap.put(128064035, new Module("Int_Powerplant_Size2_Class3", Category.STANDARD, "Power Plant", null, 2, Rating.C));
        internalMap.put(128064036, new Module("Int_Powerplant_Size2_Class4", Category.STANDARD, "Power Plant", null, 2, Rating.B));
        internalMap.put(128064037, new Module("Int_Powerplant_Size2_Class5", Category.STANDARD, "Power Plant", null, 2, Rating.A));
        internalMap.put(128064038, new Module("Int_Powerplant_Size3_Class1", Category.STANDARD, "Power Plant", null, 3, Rating.E));
        internalMap.put(128064039, new Module("Int_Powerplant_Size3_Class2", Category.STANDARD, "Power Plant", null, 3, Rating.D));
        internalMap.put(128064040, new Module("Int_Powerplant_Size3_Class3", Category.STANDARD, "Power Plant", null, 3, Rating.C));
        internalMap.put(128064041, new Module("Int_Powerplant_Size3_Class4", Category.STANDARD, "Power Plant", null, 3, Rating.B));
        internalMap.put(128064042, new Module("Int_Powerplant_Size3_Class5", Category.STANDARD, "Power Plant", null, 3, Rating.A));
        internalMap.put(128064043, new Module("Int_Powerplant_Size4_Class1", Category.STANDARD, "Power Plant", null, 4, Rating.E));
        internalMap.put(128064044, new Module("Int_Powerplant_Size4_Class2", Category.STANDARD, "Power Plant", null, 4, Rating.D));
        internalMap.put(128064045, new Module("Int_Powerplant_Size4_Class3", Category.STANDARD, "Power Plant", null, 4, Rating.C));
        internalMap.put(128064046, new Module("Int_Powerplant_Size4_Class4", Category.STANDARD, "Power Plant", null, 4, Rating.B));
        internalMap.put(128064047, new Module("Int_Powerplant_Size4_Class5", Category.STANDARD, "Power Plant", null, 4, Rating.A));
        internalMap.put(128064048, new Module("Int_Powerplant_Size5_Class1", Category.STANDARD, "Power Plant", null, 5, Rating.E));
        internalMap.put(128064049, new Module("Int_Powerplant_Size5_Class2", Category.STANDARD, "Power Plant", null, 5, Rating.D));
        internalMap.put(128064050, new Module("Int_Powerplant_Size5_Class3", Category.STANDARD, "Power Plant", null, 5, Rating.C));
        internalMap.put(128064051, new Module("Int_Powerplant_Size5_Class4", Category.STANDARD, "Power Plant", null, 5, Rating.B));
        internalMap.put(128064052, new Module("Int_Powerplant_Size5_Class5", Category.STANDARD, "Power Plant", null, 5, Rating.A));
        internalMap.put(128064053, new Module("Int_Powerplant_Size6_Class1", Category.STANDARD, "Power Plant", null, 6, Rating.E));
        internalMap.put(128064054, new Module("Int_Powerplant_Size6_Class2", Category.STANDARD, "Power Plant", null, 6, Rating.D));
        internalMap.put(128064055, new Module("Int_Powerplant_Size6_Class3", Category.STANDARD, "Power Plant", null, 6, Rating.C));
        internalMap.put(128064056, new Module("Int_Powerplant_Size6_Class4", Category.STANDARD, "Power Plant", null, 6, Rating.B));
        internalMap.put(128064057, new Module("Int_Powerplant_Size6_Class5", Category.STANDARD, "Power Plant", null, 6, Rating.A));
        internalMap.put(128064058, new Module("Int_Powerplant_Size7_Class1", Category.STANDARD, "Power Plant", null, 7, Rating.E));
        internalMap.put(128064059, new Module("Int_Powerplant_Size7_Class2", Category.STANDARD, "Power Plant", null, 7, Rating.D));
        internalMap.put(128064060, new Module("Int_Powerplant_Size7_Class3", Category.STANDARD, "Power Plant", null, 7, Rating.C));
        internalMap.put(128064061, new Module("Int_Powerplant_Size7_Class4", Category.STANDARD, "Power Plant", null, 7, Rating.B));
        internalMap.put(128064062, new Module("Int_Powerplant_Size7_Class5", Category.STANDARD, "Power Plant", null, 7, Rating.A));
        internalMap.put(128064063, new Module("Int_Powerplant_Size8_Class1", Category.STANDARD, "Power Plant", null, 8, Rating.E));
        internalMap.put(128064064, new Module("Int_Powerplant_Size8_Class2", Category.STANDARD, "Power Plant", null, 8, Rating.D));
        internalMap.put(128064065, new Module("Int_Powerplant_Size8_Class3", Category.STANDARD, "Power Plant", null, 8, Rating.C));
        internalMap.put(128064066, new Module("Int_Powerplant_Size8_Class4", Category.STANDARD, "Power Plant", null, 8, Rating.B));
        internalMap.put(128064067, new Module("Int_Powerplant_Size8_Class5", Category.STANDARD, "Power Plant", null, 8, Rating.A));
        internalMap.put(128064068, new Module("Int_Engine_Size2_Class1", Category.STANDARD, "Thrusters", null, 2, Rating.E));
        internalMap.put(128064069, new Module("Int_Engine_Size2_Class2", Category.STANDARD, "Thrusters", null, 2, Rating.D));
        internalMap.put(128064070, new Module("Int_Engine_Size2_Class3", Category.STANDARD, "Thrusters", null, 2, Rating.C));
        internalMap.put(128064071, new Module("Int_Engine_Size2_Class4", Category.STANDARD, "Thrusters", null, 2, Rating.B));
        internalMap.put(128064072, new Module("Int_Engine_Size2_Class5", Category.STANDARD, "Thrusters", null, 2, Rating.A));
        internalMap.put(128064073, new Module("Int_Engine_Size3_Class1", Category.STANDARD, "Thrusters", null, 3, Rating.E));
        internalMap.put(128064074, new Module("Int_Engine_Size3_Class2", Category.STANDARD, "Thrusters", null, 3, Rating.D));
        internalMap.put(128064075, new Module("Int_Engine_Size3_Class3", Category.STANDARD, "Thrusters", null, 3, Rating.C));
        internalMap.put(128064076, new Module("Int_Engine_Size3_Class4", Category.STANDARD, "Thrusters", null, 3, Rating.B));
        internalMap.put(128064077, new Module("Int_Engine_Size3_Class5", Category.STANDARD, "Thrusters", null, 3, Rating.A));
        internalMap.put(128064078, new Module("Int_Engine_Size4_Class1", Category.STANDARD, "Thrusters", null, 4, Rating.E));
        internalMap.put(128064079, new Module("Int_Engine_Size4_Class2", Category.STANDARD, "Thrusters", null, 4, Rating.D));
        internalMap.put(128064080, new Module("Int_Engine_Size4_Class3", Category.STANDARD, "Thrusters", null, 4, Rating.C));
        internalMap.put(128064081, new Module("Int_Engine_Size4_Class4", Category.STANDARD, "Thrusters", null, 4, Rating.B));
        internalMap.put(128064082, new Module("Int_Engine_Size4_Class5", Category.STANDARD, "Thrusters", null, 4, Rating.A));
        internalMap.put(128064083, new Module("Int_Engine_Size5_Class1", Category.STANDARD, "Thrusters", null, 5, Rating.E));
        internalMap.put(128064084, new Module("Int_Engine_Size5_Class2", Category.STANDARD, "Thrusters", null, 5, Rating.D));
        internalMap.put(128064085, new Module("Int_Engine_Size5_Class3", Category.STANDARD, "Thrusters", null, 5, Rating.C));
        internalMap.put(128064086, new Module("Int_Engine_Size5_Class4", Category.STANDARD, "Thrusters", null, 5, Rating.B));
        internalMap.put(128064087, new Module("Int_Engine_Size5_Class5", Category.STANDARD, "Thrusters", null, 5, Rating.A));
        internalMap.put(128064088, new Module("Int_Engine_Size6_Class1", Category.STANDARD, "Thrusters", null, 6, Rating.E));
        internalMap.put(128064089, new Module("Int_Engine_Size6_Class2", Category.STANDARD, "Thrusters", null, 6, Rating.D));
        internalMap.put(128064090, new Module("Int_Engine_Size6_Class3", Category.STANDARD, "Thrusters", null, 6, Rating.C));
        internalMap.put(128064091, new Module("Int_Engine_Size6_Class4", Category.STANDARD, "Thrusters", null, 6, Rating.B));
        internalMap.put(128064092, new Module("Int_Engine_Size6_Class5", Category.STANDARD, "Thrusters", null, 6, Rating.A));
        internalMap.put(128064093, new Module("Int_Engine_Size7_Class1", Category.STANDARD, "Thrusters", null, 7, Rating.E));
        internalMap.put(128064094, new Module("Int_Engine_Size7_Class2", Category.STANDARD, "Thrusters", null, 7, Rating.D));
        internalMap.put(128064095, new Module("Int_Engine_Size7_Class3", Category.STANDARD, "Thrusters", null, 7, Rating.C));
        internalMap.put(128064096, new Module("Int_Engine_Size7_Class4", Category.STANDARD, "Thrusters", null, 7, Rating.B));
        internalMap.put(128064097, new Module("Int_Engine_Size7_Class5", Category.STANDARD, "Thrusters", null, 7, Rating.A));
        internalMap.put(128064098, new Module("Int_Engine_Size8_Class1", Category.STANDARD, "Thrusters", null, 8, Rating.E));
        internalMap.put(128064099, new Module("Int_Engine_Size8_Class2", Category.STANDARD, "Thrusters", null, 8, Rating.D));
        internalMap.put(128064100, new Module("Int_Engine_Size8_Class3", Category.STANDARD, "Thrusters", null, 8, Rating.C));
        internalMap.put(128064101, new Module("Int_Engine_Size8_Class4", Category.STANDARD, "Thrusters", null, 8, Rating.B));
        internalMap.put(128064102, new Module("Int_Engine_Size8_Class5", Category.STANDARD, "Thrusters", null, 8, Rating.A));
        internalMap.put(128064103, new Module("Int_Hyperdrive_Size2_Class1", Category.STANDARD, "Frame Shift Drive", null, 2, Rating.E));
        internalMap.put(128064104, new Module("Int_Hyperdrive_Size2_Class2", Category.STANDARD, "Frame Shift Drive", null, 2, Rating.D));
        internalMap.put(128064105, new Module("Int_Hyperdrive_Size2_Class3", Category.STANDARD, "Frame Shift Drive", null, 2, Rating.C));
        internalMap.put(128064106, new Module("Int_Hyperdrive_Size2_Class4", Category.STANDARD, "Frame Shift Drive", null, 2, Rating.B));
        internalMap.put(128064107, new Module("Int_Hyperdrive_Size2_Class5", Category.STANDARD, "Frame Shift Drive", null, 2, Rating.A));
        internalMap.put(128064108, new Module("Int_Hyperdrive_Size3_Class1", Category.STANDARD, "Frame Shift Drive", null, 3, Rating.E));
        internalMap.put(128064109, new Module("Int_Hyperdrive_Size3_Class2", Category.STANDARD, "Frame Shift Drive", null, 3, Rating.D));
        internalMap.put(128064110, new Module("Int_Hyperdrive_Size3_Class3", Category.STANDARD, "Frame Shift Drive", null, 3, Rating.C));
        internalMap.put(128064111, new Module("Int_Hyperdrive_Size3_Class4", Category.STANDARD, "Frame Shift Drive", null, 3, Rating.B));
        internalMap.put(128064112, new Module("Int_Hyperdrive_Size3_Class5", Category.STANDARD, "Frame Shift Drive", null, 3, Rating.A));
        internalMap.put(128064113, new Module("Int_Hyperdrive_Size4_Class1", Category.STANDARD, "Frame Shift Drive", null, 4, Rating.E));
        internalMap.put(128064114, new Module("Int_Hyperdrive_Size4_Class2", Category.STANDARD, "Frame Shift Drive", null, 4, Rating.D));
        internalMap.put(128064115, new Module("Int_Hyperdrive_Size4_Class3", Category.STANDARD, "Frame Shift Drive", null, 4, Rating.C));
        internalMap.put(128064116, new Module("Int_Hyperdrive_Size4_Class4", Category.STANDARD, "Frame Shift Drive", null, 4, Rating.B));
        internalMap.put(128064117, new Module("Int_Hyperdrive_Size4_Class5", Category.STANDARD, "Frame Shift Drive", null, 4, Rating.A));
        internalMap.put(128064118, new Module("Int_Hyperdrive_Size5_Class1", Category.STANDARD, "Frame Shift Drive", null, 5, Rating.E));
        internalMap.put(128064119, new Module("Int_Hyperdrive_Size5_Class2", Category.STANDARD, "Frame Shift Drive", null, 5, Rating.D));
        internalMap.put(128064120, new Module("Int_Hyperdrive_Size5_Class3", Category.STANDARD, "Frame Shift Drive", null, 5, Rating.C));
        internalMap.put(128064121, new Module("Int_Hyperdrive_Size5_Class4", Category.STANDARD, "Frame Shift Drive", null, 5, Rating.B));
        internalMap.put(128064122, new Module("Int_Hyperdrive_Size5_Class5", Category.STANDARD, "Frame Shift Drive", null, 5, Rating.A));
        internalMap.put(128064123, new Module("Int_Hyperdrive_Size6_Class1", Category.STANDARD, "Frame Shift Drive", null, 6, Rating.E));
        internalMap.put(128064124, new Module("Int_Hyperdrive_Size6_Class2", Category.STANDARD, "Frame Shift Drive", null, 6, Rating.D));
        internalMap.put(128064125, new Module("Int_Hyperdrive_Size6_Class3", Category.STANDARD, "Frame Shift Drive", null, 6, Rating.C));
        internalMap.put(128064126, new Module("Int_Hyperdrive_Size6_Class4", Category.STANDARD, "Frame Shift Drive", null, 6, Rating.B));
        internalMap.put(128064127, new Module("Int_Hyperdrive_Size6_Class5", Category.STANDARD, "Frame Shift Drive", null, 6, Rating.A));
        internalMap.put(128064128, new Module("Int_Hyperdrive_Size7_Class1", Category.STANDARD, "Frame Shift Drive", null, 7, Rating.E));
        internalMap.put(128064129, new Module("Int_Hyperdrive_Size7_Class2", Category.STANDARD, "Frame Shift Drive", null, 7, Rating.D));
        internalMap.put(128064130, new Module("Int_Hyperdrive_Size7_Class3", Category.STANDARD, "Frame Shift Drive", null, 7, Rating.C));
        internalMap.put(128064131, new Module("Int_Hyperdrive_Size7_Class4", Category.STANDARD, "Frame Shift Drive", null, 7, Rating.B));
        internalMap.put(128064132, new Module("Int_Hyperdrive_Size7_Class5", Category.STANDARD, "Frame Shift Drive", null, 7, Rating.A));
        internalMap.put(128064133, new Module("Int_Hyperdrive_Size8_Class1", Category.STANDARD, "Frame Shift Drive", null, 8, Rating.E));
        internalMap.put(128064134, new Module("Int_Hyperdrive_Size8_Class2", Category.STANDARD, "Frame Shift Drive", null, 8, Rating.D));
        internalMap.put(128064135, new Module("Int_Hyperdrive_Size8_Class3", Category.STANDARD, "Frame Shift Drive", null, 8, Rating.C));
        internalMap.put(128064136, new Module("Int_Hyperdrive_Size8_Class4", Category.STANDARD, "Frame Shift Drive", null, 8, Rating.B));
        internalMap.put(128064137, new Module("Int_Hyperdrive_Size8_Class5", Category.STANDARD, "Frame Shift Drive", null, 8, Rating.A));
        internalMap.put(128064138, new Module("Int_LifeSupport_Size1_Class1", Category.STANDARD, "Life Support", null, 1, Rating.E));
        internalMap.put(128064139, new Module("Int_LifeSupport_Size1_Class2", Category.STANDARD, "Life Support", null, 1, Rating.D));
        internalMap.put(128064140, new Module("Int_LifeSupport_Size1_Class3", Category.STANDARD, "Life Support", null, 1, Rating.C));
        internalMap.put(128064141, new Module("Int_LifeSupport_Size1_Class4", Category.STANDARD, "Life Support", null, 1, Rating.B));
        internalMap.put(128064142, new Module("Int_LifeSupport_Size1_Class5", Category.STANDARD, "Life Support", null, 1, Rating.A));
        internalMap.put(128064143, new Module("Int_LifeSupport_Size2_Class1", Category.STANDARD, "Life Support", null, 2, Rating.E));
        internalMap.put(128064144, new Module("Int_LifeSupport_Size2_Class2", Category.STANDARD, "Life Support", null, 2, Rating.D));
        internalMap.put(128064145, new Module("Int_LifeSupport_Size2_Class3", Category.STANDARD, "Life Support", null, 2, Rating.C));
        internalMap.put(128064146, new Module("Int_LifeSupport_Size2_Class4", Category.STANDARD, "Life Support", null, 2, Rating.B));
        internalMap.put(128064147, new Module("Int_LifeSupport_Size2_Class5", Category.STANDARD, "Life Support", null, 2, Rating.A));
        internalMap.put(128064148, new Module("Int_LifeSupport_Size3_Class1", Category.STANDARD, "Life Support", null, 3, Rating.E));
        internalMap.put(128064149, new Module("Int_LifeSupport_Size3_Class2", Category.STANDARD, "Life Support", null, 3, Rating.D));
        internalMap.put(128064150, new Module("Int_LifeSupport_Size3_Class3", Category.STANDARD, "Life Support", null, 3, Rating.C));
        internalMap.put(128064151, new Module("Int_LifeSupport_Size3_Class4", Category.STANDARD, "Life Support", null, 3, Rating.B));
        internalMap.put(128064152, new Module("Int_LifeSupport_Size3_Class5", Category.STANDARD, "Life Support", null, 3, Rating.A));
        internalMap.put(128064153, new Module("Int_LifeSupport_Size4_Class1", Category.STANDARD, "Life Support", null, 4, Rating.E));
        internalMap.put(128064154, new Module("Int_LifeSupport_Size4_Class2", Category.STANDARD, "Life Support", null, 4, Rating.D));
        internalMap.put(128064155, new Module("Int_LifeSupport_Size4_Class3", Category.STANDARD, "Life Support", null, 4, Rating.C));
        internalMap.put(128064156, new Module("Int_LifeSupport_Size4_Class4", Category.STANDARD, "Life Support", null, 4, Rating.B));
        internalMap.put(128064157, new Module("Int_LifeSupport_Size4_Class5", Category.STANDARD, "Life Support", null, 4, Rating.A));
        internalMap.put(128064158, new Module("Int_LifeSupport_Size5_Class1", Category.STANDARD, "Life Support", null, 5, Rating.E));
        internalMap.put(128064159, new Module("Int_LifeSupport_Size5_Class2", Category.STANDARD, "Life Support", null, 5, Rating.D));
        internalMap.put(128064160, new Module("Int_LifeSupport_Size5_Class3", Category.STANDARD, "Life Support", null, 5, Rating.C));
        internalMap.put(128064161, new Module("Int_LifeSupport_Size5_Class4", Category.STANDARD, "Life Support", null, 5, Rating.B));
        internalMap.put(128064162, new Module("Int_LifeSupport_Size5_Class5", Category.STANDARD, "Life Support", null, 5, Rating.A));
        internalMap.put(128064163, new Module("Int_LifeSupport_Size6_Class1", Category.STANDARD, "Life Support", null, 6, Rating.E));
        internalMap.put(128064164, new Module("Int_LifeSupport_Size6_Class2", Category.STANDARD, "Life Support", null, 6, Rating.D));
        internalMap.put(128064165, new Module("Int_LifeSupport_Size6_Class3", Category.STANDARD, "Life Support", null, 6, Rating.C));
        internalMap.put(128064166, new Module("Int_LifeSupport_Size6_Class4", Category.STANDARD, "Life Support", null, 6, Rating.B));
        internalMap.put(128064167, new Module("Int_LifeSupport_Size6_Class5", Category.STANDARD, "Life Support", null, 6, Rating.A));
        internalMap.put(128064168, new Module("Int_LifeSupport_Size7_Class1", Category.STANDARD, "Life Support", null, 7, Rating.E));
        internalMap.put(128064169, new Module("Int_LifeSupport_Size7_Class2", Category.STANDARD, "Life Support", null, 7, Rating.D));
        internalMap.put(128064170, new Module("Int_LifeSupport_Size7_Class3", Category.STANDARD, "Life Support", null, 7, Rating.C));
        internalMap.put(128064171, new Module("Int_LifeSupport_Size7_Class4", Category.STANDARD, "Life Support", null, 7, Rating.B));
        internalMap.put(128064172, new Module("Int_LifeSupport_Size7_Class5", Category.STANDARD, "Life Support", null, 7, Rating.A));
        internalMap.put(128064173, new Module("Int_LifeSupport_Size8_Class1", Category.STANDARD, "Life Support", null, 8, Rating.E));
        internalMap.put(128064174, new Module("Int_LifeSupport_Size8_Class2", Category.STANDARD, "Life Support", null, 8, Rating.D));
        internalMap.put(128064175, new Module("Int_LifeSupport_Size8_Class3", Category.STANDARD, "Life Support", null, 8, Rating.C));
        internalMap.put(128064176, new Module("Int_LifeSupport_Size8_Class4", Category.STANDARD, "Life Support", null, 8, Rating.B));
        internalMap.put(128064177, new Module("Int_LifeSupport_Size8_Class5", Category.STANDARD, "Life Support", null, 8, Rating.A));
        internalMap.put(128064178, new Module("Int_PowerDistributor_Size1_Class1", Category.STANDARD, "Power Distributor", null, 1, Rating.E));
        internalMap.put(128064179, new Module("Int_PowerDistributor_Size1_Class2", Category.STANDARD, "Power Distributor", null, 1, Rating.D));
        internalMap.put(128064180, new Module("Int_PowerDistributor_Size1_Class3", Category.STANDARD, "Power Distributor", null, 1, Rating.C));
        internalMap.put(128064181, new Module("Int_PowerDistributor_Size1_Class4", Category.STANDARD, "Power Distributor", null, 1, Rating.B));
        internalMap.put(128064182, new Module("Int_PowerDistributor_Size1_Class5", Category.STANDARD, "Power Distributor", null, 1, Rating.A));
        internalMap.put(128064183, new Module("Int_PowerDistributor_Size2_Class1", Category.STANDARD, "Power Distributor", null, 2, Rating.E));
        internalMap.put(128064184, new Module("Int_PowerDistributor_Size2_Class2", Category.STANDARD, "Power Distributor", null, 2, Rating.D));
        internalMap.put(128064185, new Module("Int_PowerDistributor_Size2_Class3", Category.STANDARD, "Power Distributor", null, 2, Rating.C));
        internalMap.put(128064186, new Module("Int_PowerDistributor_Size2_Class4", Category.STANDARD, "Power Distributor", null, 2, Rating.B));
        internalMap.put(128064187, new Module("Int_PowerDistributor_Size2_Class5", Category.STANDARD, "Power Distributor", null, 2, Rating.A));
        internalMap.put(128064188, new Module("Int_PowerDistributor_Size3_Class1", Category.STANDARD, "Power Distributor", null, 3, Rating.E));
        internalMap.put(128064189, new Module("Int_PowerDistributor_Size3_Class2", Category.STANDARD, "Power Distributor", null, 3, Rating.D));
        internalMap.put(128064190, new Module("Int_PowerDistributor_Size3_Class3", Category.STANDARD, "Power Distributor", null, 3, Rating.C));
        internalMap.put(128064191, new Module("Int_PowerDistributor_Size3_Class4", Category.STANDARD, "Power Distributor", null, 3, Rating.B));
        internalMap.put(128064192, new Module("Int_PowerDistributor_Size3_Class5", Category.STANDARD, "Power Distributor", null, 3, Rating.A));
        internalMap.put(128064193, new Module("Int_PowerDistributor_Size4_Class1", Category.STANDARD, "Power Distributor", null, 4, Rating.E));
        internalMap.put(128064194, new Module("Int_PowerDistributor_Size4_Class2", Category.STANDARD, "Power Distributor", null, 4, Rating.D));
        internalMap.put(128064195, new Module("Int_PowerDistributor_Size4_Class3", Category.STANDARD, "Power Distributor", null, 4, Rating.C));
        internalMap.put(128064196, new Module("Int_PowerDistributor_Size4_Class4", Category.STANDARD, "Power Distributor", null, 4, Rating.B));
        internalMap.put(128064197, new Module("Int_PowerDistributor_Size4_Class5", Category.STANDARD, "Power Distributor", null, 4, Rating.A));
        internalMap.put(128064198, new Module("Int_PowerDistributor_Size5_Class1", Category.STANDARD, "Power Distributor", null, 5, Rating.E));
        internalMap.put(128064199, new Module("Int_PowerDistributor_Size5_Class2", Category.STANDARD, "Power Distributor", null, 5, Rating.D));
        internalMap.put(128064200, new Module("Int_PowerDistributor_Size5_Class3", Category.STANDARD, "Power Distributor", null, 5, Rating.C));
        internalMap.put(128064201, new Module("Int_PowerDistributor_Size5_Class4", Category.STANDARD, "Power Distributor", null, 5, Rating.B));
        internalMap.put(128064202, new Module("Int_PowerDistributor_Size5_Class5", Category.STANDARD, "Power Distributor", null, 5, Rating.A));
        internalMap.put(128064203, new Module("Int_PowerDistributor_Size6_Class1", Category.STANDARD, "Power Distributor", null, 6, Rating.E));
        internalMap.put(128064204, new Module("Int_PowerDistributor_Size6_Class2", Category.STANDARD, "Power Distributor", null, 6, Rating.D));
        internalMap.put(128064205, new Module("Int_PowerDistributor_Size6_Class3", Category.STANDARD, "Power Distributor", null, 6, Rating.C));
        internalMap.put(128064206, new Module("Int_PowerDistributor_Size6_Class4", Category.STANDARD, "Power Distributor", null, 6, Rating.B));
        internalMap.put(128064207, new Module("Int_PowerDistributor_Size6_Class5", Category.STANDARD, "Power Distributor", null, 6, Rating.A));
        internalMap.put(128064208, new Module("Int_PowerDistributor_Size7_Class1", Category.STANDARD, "Power Distributor", null, 7, Rating.E));
        internalMap.put(128064209, new Module("Int_PowerDistributor_Size7_Class2", Category.STANDARD, "Power Distributor", null, 7, Rating.D));
        internalMap.put(128064210, new Module("Int_PowerDistributor_Size7_Class3", Category.STANDARD, "Power Distributor", null, 7, Rating.C));
        internalMap.put(128064211, new Module("Int_PowerDistributor_Size7_Class4", Category.STANDARD, "Power Distributor", null, 7, Rating.B));
        internalMap.put(128064212, new Module("Int_PowerDistributor_Size7_Class5", Category.STANDARD, "Power Distributor", null, 7, Rating.A));
        internalMap.put(128064213, new Module("Int_PowerDistributor_Size8_Class1", Category.STANDARD, "Power Distributor", null, 8, Rating.E));
        internalMap.put(128064214, new Module("Int_PowerDistributor_Size8_Class2", Category.STANDARD, "Power Distributor", null, 8, Rating.D));
        internalMap.put(128064215, new Module("Int_PowerDistributor_Size8_Class3", Category.STANDARD, "Power Distributor", null, 8, Rating.C));
        internalMap.put(128064216, new Module("Int_PowerDistributor_Size8_Class4", Category.STANDARD, "Power Distributor", null, 8, Rating.B));
        internalMap.put(128064217, new Module("Int_PowerDistributor_Size8_Class5", Category.STANDARD, "Power Distributor", null, 8, Rating.A));
        internalMap.put(128064218, new Module("Int_Sensors_Size1_Class1", Category.STANDARD, "Sensors", null, 1, Rating.E));
        internalMap.put(128064219, new Module("Int_Sensors_Size1_Class2", Category.STANDARD, "Sensors", null, 1, Rating.D));
        internalMap.put(128064220, new Module("Int_Sensors_Size1_Class3", Category.STANDARD, "Sensors", null, 1, Rating.C));
        internalMap.put(128064221, new Module("Int_Sensors_Size1_Class4", Category.STANDARD, "Sensors", null, 1, Rating.B));
        internalMap.put(128064222, new Module("Int_Sensors_Size1_Class5", Category.STANDARD, "Sensors", null, 1, Rating.A));
        internalMap.put(128064223, new Module("Int_Sensors_Size2_Class1", Category.STANDARD, "Sensors", null, 2, Rating.E));
        internalMap.put(128064224, new Module("Int_Sensors_Size2_Class2", Category.STANDARD, "Sensors", null, 2, Rating.D));
        internalMap.put(128064225, new Module("Int_Sensors_Size2_Class3", Category.STANDARD, "Sensors", null, 2, Rating.C));
        internalMap.put(128064226, new Module("Int_Sensors_Size2_Class4", Category.STANDARD, "Sensors", null, 2, Rating.B));
        internalMap.put(128064227, new Module("Int_Sensors_Size2_Class5", Category.STANDARD, "Sensors", null, 2, Rating.A));
        internalMap.put(128064228, new Module("Int_Sensors_Size3_Class1", Category.STANDARD, "Sensors", null, 3, Rating.E));
        internalMap.put(128064229, new Module("Int_Sensors_Size3_Class2", Category.STANDARD, "Sensors", null, 3, Rating.D));
        internalMap.put(128064230, new Module("Int_Sensors_Size3_Class3", Category.STANDARD, "Sensors", null, 3, Rating.C));
        internalMap.put(128064231, new Module("Int_Sensors_Size3_Class4", Category.STANDARD, "Sensors", null, 3, Rating.B));
        internalMap.put(128064232, new Module("Int_Sensors_Size3_Class5", Category.STANDARD, "Sensors", null, 3, Rating.A));
        internalMap.put(128064233, new Module("Int_Sensors_Size4_Class1", Category.STANDARD, "Sensors", null, 4, Rating.E));
        internalMap.put(128064234, new Module("Int_Sensors_Size4_Class2", Category.STANDARD, "Sensors", null, 4, Rating.D));
        internalMap.put(128064235, new Module("Int_Sensors_Size4_Class3", Category.STANDARD, "Sensors", null, 4, Rating.C));
        internalMap.put(128064236, new Module("Int_Sensors_Size4_Class4", Category.STANDARD, "Sensors", null, 4, Rating.B));
        internalMap.put(128064237, new Module("Int_Sensors_Size4_Class5", Category.STANDARD, "Sensors", null, 4, Rating.A));
        internalMap.put(128064238, new Module("Int_Sensors_Size5_Class1", Category.STANDARD, "Sensors", null, 5, Rating.E));
        internalMap.put(128064239, new Module("Int_Sensors_Size5_Class2", Category.STANDARD, "Sensors", null, 5, Rating.D));
        internalMap.put(128064240, new Module("Int_Sensors_Size5_Class3", Category.STANDARD, "Sensors", null, 5, Rating.C));
        internalMap.put(128064241, new Module("Int_Sensors_Size5_Class4", Category.STANDARD, "Sensors", null, 5, Rating.B));
        internalMap.put(128064242, new Module("Int_Sensors_Size5_Class5", Category.STANDARD, "Sensors", null, 5, Rating.A));
        internalMap.put(128064243, new Module("Int_Sensors_Size6_Class1", Category.STANDARD, "Sensors", null, 6, Rating.E));
        internalMap.put(128064244, new Module("Int_Sensors_Size6_Class2", Category.STANDARD, "Sensors", null, 6, Rating.D));
        internalMap.put(128064245, new Module("Int_Sensors_Size6_Class3", Category.STANDARD, "Sensors", null, 6, Rating.C));
        internalMap.put(128064246, new Module("Int_Sensors_Size6_Class4", Category.STANDARD, "Sensors", null, 6, Rating.B));
        internalMap.put(128064247, new Module("Int_Sensors_Size6_Class5", Category.STANDARD, "Sensors", null, 6, Rating.A));
        internalMap.put(128064248, new Module("Int_Sensors_Size7_Class1", Category.STANDARD, "Sensors", null, 7, Rating.E));
        internalMap.put(128064249, new Module("Int_Sensors_Size7_Class2", Category.STANDARD, "Sensors", null, 7, Rating.D));
        internalMap.put(128064250, new Module("Int_Sensors_Size7_Class3", Category.STANDARD, "Sensors", null, 7, Rating.C));
        internalMap.put(128064251, new Module("Int_Sensors_Size7_Class4", Category.STANDARD, "Sensors", null, 7, Rating.B));
        internalMap.put(128064252, new Module("Int_Sensors_Size7_Class5", Category.STANDARD, "Sensors", null, 7, Rating.A));
        internalMap.put(128064253, new Module("Int_Sensors_Size8_Class1", Category.STANDARD, "Sensors", null, 8, Rating.E));
        internalMap.put(128064254, new Module("Int_Sensors_Size8_Class2", Category.STANDARD, "Sensors", null, 8, Rating.D));
        internalMap.put(128064255, new Module("Int_Sensors_Size8_Class3", Category.STANDARD, "Sensors", null, 8, Rating.C));
        internalMap.put(128064256, new Module("Int_Sensors_Size8_Class4", Category.STANDARD, "Sensors", null, 8, Rating.B));
        internalMap.put(128064257, new Module("Int_Sensors_Size8_Class5", Category.STANDARD, "Sensors", null, 8, Rating.A));
        internalMap.put(128064258, new Module("Int_ShieldGenerator_Size1_Class1", Category.INTERNAL, "Shield Generator", null, 1, Rating.E));
        internalMap.put(128064259, new Module("Int_ShieldGenerator_Size1_Class2", Category.INTERNAL, "Shield Generator", null, 1, Rating.D));
        internalMap.put(128064260, new Module("Int_ShieldGenerator_Size1_Class3", Category.INTERNAL, "Shield Generator", null, 1, Rating.C));
        internalMap.put(128064262, new Module("Int_ShieldGenerator_Size1_Class5", Category.INTERNAL, "Shield Generator", null, 1, Rating.A));
        internalMap.put(128064263, new Module("Int_ShieldGenerator_Size2_Class1", Category.INTERNAL, "Shield Generator", null, 2, Rating.E));
        internalMap.put(128064264, new Module("Int_ShieldGenerator_Size2_Class2", Category.INTERNAL, "Shield Generator", null, 2, Rating.D));
        internalMap.put(128064265, new Module("Int_ShieldGenerator_Size2_Class3", Category.INTERNAL, "Shield Generator", null, 2, Rating.C));
        internalMap.put(128064266, new Module("Int_ShieldGenerator_Size2_Class4", Category.INTERNAL, "Shield Generator", null, 2, Rating.B));
        internalMap.put(128064267, new Module("Int_ShieldGenerator_Size2_Class5", Category.INTERNAL, "Shield Generator", null, 2, Rating.A));
        internalMap.put(128064268, new Module("Int_ShieldGenerator_Size3_Class1", Category.INTERNAL, "Shield Generator", null, 3, Rating.E));
        internalMap.put(128064269, new Module("Int_ShieldGenerator_Size3_Class2", Category.INTERNAL, "Shield Generator", null, 3, Rating.D));
        internalMap.put(128064270, new Module("Int_ShieldGenerator_Size3_Class3", Category.INTERNAL, "Shield Generator", null, 3, Rating.C));
        internalMap.put(128064271, new Module("Int_ShieldGenerator_Size3_Class4", Category.INTERNAL, "Shield Generator", null, 3, Rating.B));
        internalMap.put(128064272, new Module("Int_ShieldGenerator_Size3_Class5", Category.INTERNAL, "Shield Generator", null, 3, Rating.A));
        internalMap.put(128064273, new Module("Int_ShieldGenerator_Size4_Class1", Category.INTERNAL, "Shield Generator", null, 4, Rating.E));
        internalMap.put(128064274, new Module("Int_ShieldGenerator_Size4_Class2", Category.INTERNAL, "Shield Generator", null, 4, Rating.D));
        internalMap.put(128064275, new Module("Int_ShieldGenerator_Size4_Class3", Category.INTERNAL, "Shield Generator", null, 4, Rating.C));
        internalMap.put(128064276, new Module("Int_ShieldGenerator_Size4_Class4", Category.INTERNAL, "Shield Generator", null, 4, Rating.B));
        internalMap.put(128064277, new Module("Int_ShieldGenerator_Size4_Class5", Category.INTERNAL, "Shield Generator", null, 4, Rating.A));
        internalMap.put(128064278, new Module("Int_ShieldGenerator_Size5_Class1", Category.INTERNAL, "Shield Generator", null, 5, Rating.E));
        internalMap.put(128064279, new Module("Int_ShieldGenerator_Size5_Class2", Category.INTERNAL, "Shield Generator", null, 5, Rating.D));
        internalMap.put(128064280, new Module("Int_ShieldGenerator_Size5_Class3", Category.INTERNAL, "Shield Generator", null, 5, Rating.C));
        internalMap.put(128064281, new Module("Int_ShieldGenerator_Size5_Class4", Category.INTERNAL, "Shield Generator", null, 5, Rating.B));
        internalMap.put(128064282, new Module("Int_ShieldGenerator_Size5_Class5", Category.INTERNAL, "Shield Generator", null, 5, Rating.A));
        internalMap.put(128064283, new Module("Int_ShieldGenerator_Size6_Class1", Category.INTERNAL, "Shield Generator", null, 6, Rating.E));
        internalMap.put(128064284, new Module("Int_ShieldGenerator_Size6_Class2", Category.INTERNAL, "Shield Generator", null, 6, Rating.D));
        internalMap.put(128064285, new Module("Int_ShieldGenerator_Size6_Class3", Category.INTERNAL, "Shield Generator", null, 6, Rating.C));
        internalMap.put(128064286, new Module("Int_ShieldGenerator_Size6_Class4", Category.INTERNAL, "Shield Generator", null, 6, Rating.B));
        internalMap.put(128064287, new Module("Int_ShieldGenerator_Size6_Class5", Category.INTERNAL, "Shield Generator", null, 6, Rating.A));
        internalMap.put(128064288, new Module("Int_ShieldGenerator_Size7_Class1", Category.INTERNAL, "Shield Generator", null, 7, Rating.E));
        internalMap.put(128064289, new Module("Int_ShieldGenerator_Size7_Class2", Category.INTERNAL, "Shield Generator", null, 7, Rating.D));
        internalMap.put(128064290, new Module("Int_ShieldGenerator_Size7_Class3", Category.INTERNAL, "Shield Generator", null, 7, Rating.C));
        internalMap.put(128064291, new Module("Int_ShieldGenerator_Size7_Class4", Category.INTERNAL, "Shield Generator", null, 7, Rating.B));
        internalMap.put(128064292, new Module("Int_ShieldGenerator_Size7_Class5", Category.INTERNAL, "Shield Generator", null, 7, Rating.A));
        internalMap.put(128064293, new Module("Int_ShieldGenerator_Size8_Class1", Category.INTERNAL, "Shield Generator", null, 8, Rating.E));
        internalMap.put(128064294, new Module("Int_ShieldGenerator_Size8_Class2", Category.INTERNAL, "Shield Generator", null, 8, Rating.D));
        internalMap.put(128064295, new Module("Int_ShieldGenerator_Size8_Class3", Category.INTERNAL, "Shield Generator", null, 8, Rating.C));
        internalMap.put(128064296, new Module("Int_ShieldGenerator_Size8_Class4", Category.INTERNAL, "Shield Generator", null, 8, Rating.B));
        internalMap.put(128064297, new Module("Int_ShieldGenerator_Size8_Class5", Category.INTERNAL, "Shield Generator", null, 8, Rating.A));
        internalMap.put(128064298, new Module("Int_ShieldCellBank_Size1_Class1", Category.INTERNAL, "Shield Cell Bank", null, 1, Rating.E));
        internalMap.put(128064299, new Module("Int_ShieldCellBank_Size1_Class2", Category.INTERNAL, "Shield Cell Bank", null, 1, Rating.D));
        internalMap.put(128064300, new Module("Int_ShieldCellBank_Size1_Class3", Category.INTERNAL, "Shield Cell Bank", null, 1, Rating.C));
        internalMap.put(128064301, new Module("Int_ShieldCellBank_Size1_Class4", Category.INTERNAL, "Shield Cell Bank", null, 1, Rating.B));
        internalMap.put(128064302, new Module("Int_ShieldCellBank_Size1_Class5", Category.INTERNAL, "Shield Cell Bank", null, 1, Rating.A));
        internalMap.put(128064303, new Module("Int_ShieldCellBank_Size2_Class1", Category.INTERNAL, "Shield Cell Bank", null, 2, Rating.E));
        internalMap.put(128064304, new Module("Int_ShieldCellBank_Size2_Class2", Category.INTERNAL, "Shield Cell Bank", null, 2, Rating.D));
        internalMap.put(128064305, new Module("Int_ShieldCellBank_Size2_Class3", Category.INTERNAL, "Shield Cell Bank", null, 2, Rating.C));
        internalMap.put(128064306, new Module("Int_ShieldCellBank_Size2_Class4", Category.INTERNAL, "Shield Cell Bank", null, 2, Rating.B));
        internalMap.put(128064307, new Module("Int_ShieldCellBank_Size2_Class5", Category.INTERNAL, "Shield Cell Bank", null, 2, Rating.A));
        internalMap.put(128064308, new Module("Int_ShieldCellBank_Size3_Class1", Category.INTERNAL, "Shield Cell Bank", null, 3, Rating.E));
        internalMap.put(128064309, new Module("Int_ShieldCellBank_Size3_Class2", Category.INTERNAL, "Shield Cell Bank", null, 3, Rating.D));
        internalMap.put(128064310, new Module("Int_ShieldCellBank_Size3_Class3", Category.INTERNAL, "Shield Cell Bank", null, 3, Rating.C));
        internalMap.put(128064311, new Module("Int_ShieldCellBank_Size3_Class4", Category.INTERNAL, "Shield Cell Bank", null, 3, Rating.B));
        internalMap.put(128064312, new Module("Int_ShieldCellBank_Size3_Class5", Category.INTERNAL, "Shield Cell Bank", null, 3, Rating.A));
        internalMap.put(128064313, new Module("Int_ShieldCellBank_Size4_Class1", Category.INTERNAL, "Shield Cell Bank", null, 4, Rating.E));
        internalMap.put(128064314, new Module("Int_ShieldCellBank_Size4_Class2", Category.INTERNAL, "Shield Cell Bank", null, 4, Rating.D));
        internalMap.put(128064315, new Module("Int_ShieldCellBank_Size4_Class3", Category.INTERNAL, "Shield Cell Bank", null, 4, Rating.C));
        internalMap.put(128064316, new Module("Int_ShieldCellBank_Size4_Class4", Category.INTERNAL, "Shield Cell Bank", null, 4, Rating.B));
        internalMap.put(128064317, new Module("Int_ShieldCellBank_Size4_Class5", Category.INTERNAL, "Shield Cell Bank", null, 4, Rating.A));
        internalMap.put(128064318, new Module("Int_ShieldCellBank_Size5_Class1", Category.INTERNAL, "Shield Cell Bank", null, 5, Rating.E));
        internalMap.put(128064319, new Module("Int_ShieldCellBank_Size5_Class2", Category.INTERNAL, "Shield Cell Bank", null, 5, Rating.D));
        internalMap.put(128064320, new Module("Int_ShieldCellBank_Size5_Class3", Category.INTERNAL, "Shield Cell Bank", null, 5, Rating.C));
        internalMap.put(128064321, new Module("Int_ShieldCellBank_Size5_Class4", Category.INTERNAL, "Shield Cell Bank", null, 5, Rating.B));
        internalMap.put(128064322, new Module("Int_ShieldCellBank_Size5_Class5", Category.INTERNAL, "Shield Cell Bank", null, 5, Rating.A));
        internalMap.put(128064323, new Module("Int_ShieldCellBank_Size6_Class1", Category.INTERNAL, "Shield Cell Bank", null, 6, Rating.E));
        internalMap.put(128064324, new Module("Int_ShieldCellBank_Size6_Class2", Category.INTERNAL, "Shield Cell Bank", null, 6, Rating.D));
        internalMap.put(128064325, new Module("Int_ShieldCellBank_Size6_Class3", Category.INTERNAL, "Shield Cell Bank", null, 6, Rating.C));
        internalMap.put(128064326, new Module("Int_ShieldCellBank_Size6_Class4", Category.INTERNAL, "Shield Cell Bank", null, 6, Rating.B));
        internalMap.put(128064327, new Module("Int_ShieldCellBank_Size6_Class5", Category.INTERNAL, "Shield Cell Bank", null, 6, Rating.A));
        internalMap.put(128064328, new Module("Int_ShieldCellBank_Size7_Class1", Category.INTERNAL, "Shield Cell Bank", null, 7, Rating.E));
        internalMap.put(128064329, new Module("Int_ShieldCellBank_Size7_Class2", Category.INTERNAL, "Shield Cell Bank", null, 7, Rating.D));
        internalMap.put(128064330, new Module("Int_ShieldCellBank_Size7_Class3", Category.INTERNAL, "Shield Cell Bank", null, 7, Rating.C));
        internalMap.put(128064331, new Module("Int_ShieldCellBank_Size7_Class4", Category.INTERNAL, "Shield Cell Bank", null, 7, Rating.B));
        internalMap.put(128064332, new Module("Int_ShieldCellBank_Size7_Class5", Category.INTERNAL, "Shield Cell Bank", null, 7, Rating.A));
        internalMap.put(128064333, new Module("Int_ShieldCellBank_Size8_Class1", Category.INTERNAL, "Shield Cell Bank", null, 8, Rating.E));
        internalMap.put(128064334, new Module("Int_ShieldCellBank_Size8_Class2", Category.INTERNAL, "Shield Cell Bank", null, 8, Rating.D));
        internalMap.put(128064335, new Module("Int_ShieldCellBank_Size8_Class3", Category.INTERNAL, "Shield Cell Bank", null, 8, Rating.C));
        internalMap.put(128064336, new Module("Int_ShieldCellBank_Size8_Class4", Category.INTERNAL, "Shield Cell Bank", null, 8, Rating.B));
        internalMap.put(128064337, new Module("Int_ShieldCellBank_Size8_Class5", Category.INTERNAL, "Shield Cell Bank", null, 8, Rating.A));
        internalMap.put(128064338, new Module("Int_CargoRack_Size1_Class1", Category.INTERNAL, "Cargo Rack", null, 1, Rating.E));
        internalMap.put(128064339, new Module("Int_CargoRack_Size2_Class1", Category.INTERNAL, "Cargo Rack", null, 2, Rating.E));
        internalMap.put(128064340, new Module("Int_CargoRack_Size3_Class1", Category.INTERNAL, "Cargo Rack", null, 3, Rating.E));
        internalMap.put(128064341, new Module("Int_CargoRack_Size4_Class1", Category.INTERNAL, "Cargo Rack", null, 4, Rating.E));
        internalMap.put(128064342, new Module("Int_CargoRack_Size5_Class1", Category.INTERNAL, "Cargo Rack", null, 5, Rating.E));
        internalMap.put(128064343, new Module("Int_CargoRack_Size6_Class1", Category.INTERNAL, "Cargo Rack", null, 6, Rating.E));
        internalMap.put(128064344, new Module("Int_CargoRack_Size7_Class1", Category.INTERNAL, "Cargo Rack", null, 7, Rating.E));
        internalMap.put(128064345, new Module("Int_CargoRack_Size8_Class1", Category.INTERNAL, "Cargo Rack", null, 8, Rating.E));
        internalMap.put(128064346, new Module("Int_FuelTank_Size1_Class3", Category.STANDARD, "Fuel Tank", null, 1, Rating.C));
        internalMap.put(128064347, new Module("Int_FuelTank_Size2_Class3", Category.STANDARD, "Fuel Tank", null, 2, Rating.C));
        internalMap.put(128064348, new Module("Int_FuelTank_Size3_Class3", Category.STANDARD, "Fuel Tank", null, 3, Rating.C));
        internalMap.put(128064349, new Module("Int_FuelTank_Size4_Class3", Category.STANDARD, "Fuel Tank", null, 4, Rating.C));
        internalMap.put(128064350, new Module("Int_FuelTank_Size5_Class3", Category.STANDARD, "Fuel Tank", null, 5, Rating.C));
        internalMap.put(128064351, new Module("Int_FuelTank_Size6_Class3", Category.STANDARD, "Fuel Tank", null, 6, Rating.C));
        internalMap.put(128064352, new Module("Int_FuelTank_Size7_Class3", Category.STANDARD, "Fuel Tank", null, 7, Rating.C));
        internalMap.put(128064353, new Module("Int_FuelTank_Size8_Class3", Category.STANDARD, "Fuel Tank", null, 8, Rating.C));
        internalMap.put(128066402, new Module("Int_DroneControl_ResourceSiphon", Category.INTERNAL, "Limpet Control", null, 1, Rating.I));
        internalMap.put(128066532, new Module("Int_DroneControl_ResourceSiphon_Size1_Class1", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 1, Rating.E));
        internalMap.put(128066533, new Module("Int_DroneControl_ResourceSiphon_Size1_Class2", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 1, Rating.D));
        internalMap.put(128066534, new Module("Int_DroneControl_ResourceSiphon_Size1_Class3", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 1, Rating.C));
        internalMap.put(128066535, new Module("Int_DroneControl_ResourceSiphon_Size1_Class4", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 1, Rating.B));
        internalMap.put(128066536, new Module("Int_DroneControl_ResourceSiphon_Size1_Class5", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 1, Rating.A));
        internalMap.put(128066537, new Module("Int_DroneControl_ResourceSiphon_Size3_Class1", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 3, Rating.E));
        internalMap.put(128066538, new Module("Int_DroneControl_ResourceSiphon_Size3_Class2", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 3, Rating.D));
        internalMap.put(128066539, new Module("Int_DroneControl_ResourceSiphon_Size3_Class3", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 3, Rating.C));
        internalMap.put(128066540, new Module("Int_DroneControl_ResourceSiphon_Size3_Class4", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 3, Rating.B));
        internalMap.put(128066541, new Module("Int_DroneControl_ResourceSiphon_Size3_Class5", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 3, Rating.A));
        internalMap.put(128066542, new Module("Int_DroneControl_ResourceSiphon_Size5_Class1", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 5, Rating.E));
        internalMap.put(128066543, new Module("Int_DroneControl_ResourceSiphon_Size5_Class2", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 5, Rating.D));
        internalMap.put(128066544, new Module("Int_DroneControl_ResourceSiphon_Size5_Class3", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 5, Rating.C));
        internalMap.put(128066545, new Module("Int_DroneControl_ResourceSiphon_Size5_Class4", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 5, Rating.B));
        internalMap.put(128066546, new Module("Int_DroneControl_ResourceSiphon_Size5_Class5", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 5, Rating.A));
        internalMap.put(128066547, new Module("Int_DroneControl_ResourceSiphon_Size7_Class1", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 7, Rating.E));
        internalMap.put(128066548, new Module("Int_DroneControl_ResourceSiphon_Size7_Class2", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 7, Rating.D));
        internalMap.put(128066549, new Module("Int_DroneControl_ResourceSiphon_Size7_Class3", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 7, Rating.C));
        internalMap.put(128066550, new Module("Int_DroneControl_ResourceSiphon_Size7_Class4", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 7, Rating.B));
        internalMap.put(128066551, new Module("Int_DroneControl_ResourceSiphon_Size7_Class5", Category.INTERNAL, "Hatch Breaker Limpet Controller", null, 7, Rating.A));
        internalMap.put(128662520, new Module("Hpt_CargoScanner_Size0_Class1", Category.UTILITY, "Cargo Scanner", null, 0, Rating.E));
        internalMap.put(128662521, new Module("Hpt_CargoScanner_Size0_Class2", Category.UTILITY, "Cargo Scanner", null, 0, Rating.D));
        internalMap.put(128662522, new Module("Hpt_CargoScanner_Size0_Class3", Category.UTILITY, "Cargo Scanner", null, 0, Rating.C));
        internalMap.put(128662523, new Module("Hpt_CargoScanner_Size0_Class4", Category.UTILITY, "Cargo Scanner", null, 0, Rating.B));
        internalMap.put(128662524, new Module("Hpt_CargoScanner_Size0_Class5", Category.UTILITY, "Cargo Scanner", null, 0, Rating.A));
        internalMap.put(128662525, new Module("Hpt_CloudScanner_Size0_Class1", Category.UTILITY, "Frame Shift Wake Scanner", null, 0, Rating.E));
        internalMap.put(128662526, new Module("Hpt_CloudScanner_Size0_Class2", Category.UTILITY, "Frame Shift Wake Scanner", null, 0, Rating.D));
        internalMap.put(128662527, new Module("Hpt_CloudScanner_Size0_Class3", Category.UTILITY, "Frame Shift Wake Scanner", null, 0, Rating.C));
        internalMap.put(128662528, new Module("Hpt_CloudScanner_Size0_Class4", Category.UTILITY, "Frame Shift Wake Scanner", null, 0, Rating.B));
        internalMap.put(128662529, new Module("Hpt_CloudScanner_Size0_Class5", Category.UTILITY, "Frame Shift Wake Scanner", null, 0, Rating.A));
        internalMap.put(128662530, new Module("Hpt_CrimeScanner_Size0_Class1", Category.UTILITY, "Kill Warrant Scanner", null, 0, Rating.E));
        internalMap.put(128662531, new Module("Hpt_CrimeScanner_Size0_Class2", Category.UTILITY, "Kill Warrant Scanner", null, 0, Rating.D));
        internalMap.put(128662532, new Module("Hpt_CrimeScanner_Size0_Class3", Category.UTILITY, "Kill Warrant Scanner", null, 0, Rating.C));
        internalMap.put(128662533, new Module("Hpt_CrimeScanner_Size0_Class4", Category.UTILITY, "Kill Warrant Scanner", null, 0, Rating.B));
        internalMap.put(128662534, new Module("Hpt_CrimeScanner_Size0_Class5", Category.UTILITY, "Kill Warrant Scanner", null, 0, Rating.A));
        internalMap.put(128662535, new Module("Int_StellarBodyDiscoveryScanner_Standard", Category.INTERNAL, "Basic Discovery Scanner", null, 1, Rating.E));
        internalMap.put(128663560, new Module("Int_StellarBodyDiscoveryScanner_Intermediate", Category.INTERNAL, "Intermediate Discovery Scanner", null, 1, Rating.D));
        internalMap.put(128663561, new Module("Int_StellarBodyDiscoveryScanner_Advanced", Category.INTERNAL, "Advanced Discovery Scanner", null, 1, Rating.C));
        internalMap.put(128666634, new Module("Int_DetailedSurfaceScanner_Tiny", Category.INTERNAL, "Detailed Surface Scanner", null, 1, Rating.I));
        internalMap.put(128666635, new Module("Int_PowerPlant_Size2_Class1_free", Category.STANDARD, "Power Plant", null, 2, Rating.E));
        internalMap.put(128666636, new Module("Int_Engine_Size2_Class1_free", Category.STANDARD, "Thrusters", null, 2, Rating.E));
        internalMap.put(128666637, new Module("Int_Hyperdrive_Size2_Class1_free", Category.STANDARD, "Frame Shift Drive", null, 2, Rating.E));
        internalMap.put(128666638, new Module("Int_LifeSupport_Size1_Class1_free", Category.STANDARD, "Life Support", null, 1, Rating.E));
        internalMap.put(128666639, new Module("Int_PowerDistributor_Size1_Class1_free", Category.STANDARD, "Power Distributor", null, 1, Rating.E));
        internalMap.put(128666640, new Module("Int_Sensors_Size1_Class1_free", Category.STANDARD, "Sensors", null, 1, Rating.E));
        internalMap.put(128666641, new Module("Int_ShieldGenerator_Size2_Class1_free", Category.INTERNAL, "Shield Generator", null, 2, Rating.E));
        internalMap.put(128666642, new Module("Int_StellarBodyDiscoveryScanner_Standard_free", Category.INTERNAL, "Basic Discovery Scanner", null, 1, Rating.E));
        internalMap.put(128666643, new Module("Int_CargoRack_Size2_Class1_free", Category.INTERNAL, "Cargo Rack", null, 2, Rating.E));
        internalMap.put(128666644, new Module("Int_FuelScoop_Size1_Class1", Category.INTERNAL, "Fuel Scoop", null, 1, Rating.E));
        internalMap.put(128666645, new Module("Int_FuelScoop_Size2_Class1", Category.INTERNAL, "Fuel Scoop", null, 2, Rating.E));
        internalMap.put(128666646, new Module("Int_FuelScoop_Size3_Class1", Category.INTERNAL, "Fuel Scoop", null, 3, Rating.E));
        internalMap.put(128666647, new Module("Int_FuelScoop_Size4_Class1", Category.INTERNAL, "Fuel Scoop", null, 4, Rating.E));
        internalMap.put(128666648, new Module("Int_FuelScoop_Size5_Class1", Category.INTERNAL, "Fuel Scoop", null, 5, Rating.E));
        internalMap.put(128666649, new Module("Int_FuelScoop_Size6_Class1", Category.INTERNAL, "Fuel Scoop", null, 6, Rating.E));
        internalMap.put(128666650, new Module("Int_FuelScoop_Size7_Class1", Category.INTERNAL, "Fuel Scoop", null, 7, Rating.E));
        internalMap.put(128666651, new Module("Int_FuelScoop_Size8_Class1", Category.INTERNAL, "Fuel Scoop", null, 8, Rating.E));
        internalMap.put(128666652, new Module("Int_FuelScoop_Size1_Class2", Category.INTERNAL, "Fuel Scoop", null, 1, Rating.D));
        internalMap.put(128666653, new Module("Int_FuelScoop_Size2_Class2", Category.INTERNAL, "Fuel Scoop", null, 2, Rating.D));
        internalMap.put(128666654, new Module("Int_FuelScoop_Size3_Class2", Category.INTERNAL, "Fuel Scoop", null, 3, Rating.D));
        internalMap.put(128666655, new Module("Int_FuelScoop_Size4_Class2", Category.INTERNAL, "Fuel Scoop", null, 4, Rating.D));
        internalMap.put(128666656, new Module("Int_FuelScoop_Size5_Class2", Category.INTERNAL, "Fuel Scoop", null, 5, Rating.D));
        internalMap.put(128666657, new Module("Int_FuelScoop_Size6_Class2", Category.INTERNAL, "Fuel Scoop", null, 6, Rating.D));
        internalMap.put(128666658, new Module("Int_FuelScoop_Size7_Class2", Category.INTERNAL, "Fuel Scoop", null, 7, Rating.D));
        internalMap.put(128666659, new Module("Int_FuelScoop_Size8_Class2", Category.INTERNAL, "Fuel Scoop", null, 8, Rating.D));
        internalMap.put(128666660, new Module("Int_FuelScoop_Size1_Class3", Category.INTERNAL, "Fuel Scoop", null, 1, Rating.C));
        internalMap.put(128666661, new Module("Int_FuelScoop_Size2_Class3", Category.INTERNAL, "Fuel Scoop", null, 2, Rating.C));
        internalMap.put(128666662, new Module("Int_FuelScoop_Size3_Class3", Category.INTERNAL, "Fuel Scoop", null, 3, Rating.C));
        internalMap.put(128666663, new Module("Int_FuelScoop_Size4_Class3", Category.INTERNAL, "Fuel Scoop", null, 4, Rating.C));
        internalMap.put(128666664, new Module("Int_FuelScoop_Size5_Class3", Category.INTERNAL, "Fuel Scoop", null, 5, Rating.C));
        internalMap.put(128666665, new Module("Int_FuelScoop_Size6_Class3", Category.INTERNAL, "Fuel Scoop", null, 6, Rating.C));
        internalMap.put(128666666, new Module("Int_FuelScoop_Size7_Class3", Category.INTERNAL, "Fuel Scoop", null, 7, Rating.C));
        internalMap.put(128666667, new Module("Int_FuelScoop_Size8_Class3", Category.INTERNAL, "Fuel Scoop", null, 8, Rating.C));
        internalMap.put(128666668, new Module("Int_FuelScoop_Size1_Class4", Category.INTERNAL, "Fuel Scoop", null, 1, Rating.B));
        internalMap.put(128666669, new Module("Int_FuelScoop_Size2_Class4", Category.INTERNAL, "Fuel Scoop", null, 2, Rating.B));
        internalMap.put(128666670, new Module("Int_FuelScoop_Size3_Class4", Category.INTERNAL, "Fuel Scoop", null, 3, Rating.B));
        internalMap.put(128666671, new Module("Int_FuelScoop_Size4_Class4", Category.INTERNAL, "Fuel Scoop", null, 4, Rating.B));
        internalMap.put(128666672, new Module("Int_FuelScoop_Size5_Class4", Category.INTERNAL, "Fuel Scoop", null, 5, Rating.B));
        internalMap.put(128666673, new Module("Int_FuelScoop_Size6_Class4", Category.INTERNAL, "Fuel Scoop", null, 6, Rating.B));
        internalMap.put(128666674, new Module("Int_FuelScoop_Size7_Class4", Category.INTERNAL, "Fuel Scoop", null, 7, Rating.B));
        internalMap.put(128666675, new Module("Int_FuelScoop_Size8_Class4", Category.INTERNAL, "Fuel Scoop", null, 8, Rating.B));
        internalMap.put(128666676, new Module("Int_FuelScoop_Size1_Class5", Category.INTERNAL, "Fuel Scoop", null, 1, Rating.A));
        internalMap.put(128666677, new Module("Int_FuelScoop_Size2_Class5", Category.INTERNAL, "Fuel Scoop", null, 2, Rating.A));
        internalMap.put(128666678, new Module("Int_FuelScoop_Size3_Class5", Category.INTERNAL, "Fuel Scoop", null, 3, Rating.A));
        internalMap.put(128666679, new Module("Int_FuelScoop_Size4_Class5", Category.INTERNAL, "Fuel Scoop", null, 4, Rating.A));
        internalMap.put(128666680, new Module("Int_FuelScoop_Size5_Class5", Category.INTERNAL, "Fuel Scoop", null, 5, Rating.A));
        internalMap.put(128666681, new Module("Int_FuelScoop_Size6_Class5", Category.INTERNAL, "Fuel Scoop", null, 6, Rating.A));
        internalMap.put(128666682, new Module("Int_FuelScoop_Size7_Class5", Category.INTERNAL, "Fuel Scoop", null, 7, Rating.A));
        internalMap.put(128666683, new Module("Int_FuelScoop_Size8_Class5", Category.INTERNAL, "Fuel Scoop", null, 8, Rating.A));
        internalMap.put(128666684, new Module("Int_Refinery_Size1_Class1", Category.INTERNAL, "Refinery", null, 1, Rating.E));
        internalMap.put(128666685, new Module("Int_Refinery_Size2_Class1", Category.INTERNAL, "Refinery", null, 2, Rating.E));
        internalMap.put(128666686, new Module("Int_Refinery_Size3_Class1", Category.INTERNAL, "Refinery", null, 3, Rating.E));
        internalMap.put(128666687, new Module("Int_Refinery_Size4_Class1", Category.INTERNAL, "Refinery", null, 4, Rating.E));
        internalMap.put(128666688, new Module("Int_Refinery_Size1_Class2", Category.INTERNAL, "Refinery", null, 1, Rating.D));
        internalMap.put(128666689, new Module("Int_Refinery_Size2_Class2", Category.INTERNAL, "Refinery", null, 2, Rating.D));
        internalMap.put(128666690, new Module("Int_Refinery_Size3_Class2", Category.INTERNAL, "Refinery", null, 3, Rating.D));
        internalMap.put(128666691, new Module("Int_Refinery_Size4_Class2", Category.INTERNAL, "Refinery", null, 4, Rating.D));
        internalMap.put(128666692, new Module("Int_Refinery_Size1_Class3", Category.INTERNAL, "Refinery", null, 1, Rating.C));
        internalMap.put(128666693, new Module("Int_Refinery_Size2_Class3", Category.INTERNAL, "Refinery", null, 2, Rating.C));
        internalMap.put(128666694, new Module("Int_Refinery_Size3_Class3", Category.INTERNAL, "Refinery", null, 3, Rating.C));
        internalMap.put(128666695, new Module("Int_Refinery_Size4_Class3", Category.INTERNAL, "Refinery", null, 4, Rating.C));
        internalMap.put(128666696, new Module("Int_Refinery_Size1_Class4", Category.INTERNAL, "Refinery", null, 1, Rating.B));
        internalMap.put(128666697, new Module("Int_Refinery_Size2_Class4", Category.INTERNAL, "Refinery", null, 2, Rating.B));
        internalMap.put(128666698, new Module("Int_Refinery_Size3_Class4", Category.INTERNAL, "Refinery", null, 3, Rating.B));
        internalMap.put(128666699, new Module("Int_Refinery_Size4_Class4", Category.INTERNAL, "Refinery", null, 4, Rating.B));
        internalMap.put(128666700, new Module("Int_Refinery_Size1_Class5", Category.INTERNAL, "Refinery", null, 1, Rating.A));
        internalMap.put(128666701, new Module("Int_Refinery_Size2_Class5", Category.INTERNAL, "Refinery", null, 2, Rating.A));
        internalMap.put(128666702, new Module("Int_Refinery_Size3_Class5", Category.INTERNAL, "Refinery", null, 3, Rating.A));
        internalMap.put(128666703, new Module("Int_Refinery_Size4_Class5", Category.INTERNAL, "Refinery", null, 4, Rating.A));
        internalMap.put(128666704, new Module("Int_FSDInterdictor_Size1_Class1", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 1, Rating.E));
        internalMap.put(128666705, new Module("Int_FSDInterdictor_Size2_Class1", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 2, Rating.E));
        internalMap.put(128666706, new Module("Int_FSDInterdictor_Size3_Class1", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 3, Rating.E));
        internalMap.put(128666707, new Module("Int_FSDInterdictor_Size4_Class1", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 4, Rating.E));
        internalMap.put(128666708, new Module("Int_FSDInterdictor_Size1_Class2", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 1, Rating.D));
        internalMap.put(128666709, new Module("Int_FSDInterdictor_Size2_Class2", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 2, Rating.D));
        internalMap.put(128666710, new Module("Int_FSDInterdictor_Size3_Class2", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 3, Rating.D));
        internalMap.put(128666711, new Module("Int_FSDInterdictor_Size4_Class2", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 4, Rating.D));
        internalMap.put(128666712, new Module("Int_FSDInterdictor_Size1_Class3", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 1, Rating.C));
        internalMap.put(128666713, new Module("Int_FSDInterdictor_Size2_Class3", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 2, Rating.C));
        internalMap.put(128666714, new Module("Int_FSDInterdictor_Size3_Class3", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 3, Rating.C));
        internalMap.put(128666715, new Module("Int_FSDInterdictor_Size4_Class3", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 4, Rating.C));
        internalMap.put(128666716, new Module("Int_FSDInterdictor_Size1_Class4", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 1, Rating.B));
        internalMap.put(128666717, new Module("Int_FSDInterdictor_Size2_Class4", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 2, Rating.B));
        internalMap.put(128666718, new Module("Int_FSDInterdictor_Size3_Class4", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 3, Rating.B));
        internalMap.put(128666719, new Module("Int_FSDInterdictor_Size4_Class4", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 4, Rating.B));
        internalMap.put(128666720, new Module("Int_FSDInterdictor_Size1_Class5", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 1, Rating.A));
        internalMap.put(128666721, new Module("Int_FSDInterdictor_Size2_Class5", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 2, Rating.A));
        internalMap.put(128666722, new Module("Int_FSDInterdictor_Size3_Class5", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 3, Rating.A));
        internalMap.put(128666723, new Module("Int_FSDInterdictor_Size4_Class5", Category.INTERNAL, "Frame Shift Drive Interdictor", null, 4, Rating.A));
        internalMap.put(128666724, new Module("Hpt_DumbfireMissileRack_Fixed_Small", Category.HARDPOINT, "Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 1, Rating.B));
        internalMap.put(128666725, new Module("Hpt_DumbfireMissileRack_Fixed_Medium", Category.HARDPOINT, "Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 2, Rating.B));
        internalMap.put(128667018, new Module("Int_FuelTank_Size1_Class3_free", Category.STANDARD, "Fuel Tank", null, 1, Rating.C));
        internalMap.put(128667598, new Module("Int_Repairer_Size1_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 1, Rating.E));
        internalMap.put(128667599, new Module("Int_Repairer_Size2_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 2, Rating.E));
        internalMap.put(128667600, new Module("Int_Repairer_Size3_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 3, Rating.E));
        internalMap.put(128667601, new Module("Int_Repairer_Size4_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 4, Rating.E));
        internalMap.put(128667602, new Module("Int_Repairer_Size5_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 5, Rating.E));
        internalMap.put(128667603, new Module("Int_Repairer_Size6_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 6, Rating.E));
        internalMap.put(128667604, new Module("Int_Repairer_Size7_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 7, Rating.E));
        internalMap.put(128667605, new Module("Int_Repairer_Size8_Class1", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 8, Rating.E));
        internalMap.put(128667606, new Module("Int_Repairer_Size1_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 1, Rating.D));
        internalMap.put(128667607, new Module("Int_Repairer_Size2_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 2, Rating.D));
        internalMap.put(128667608, new Module("Int_Repairer_Size3_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 3, Rating.D));
        internalMap.put(128667609, new Module("Int_Repairer_Size4_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 4, Rating.D));
        internalMap.put(128667610, new Module("Int_Repairer_Size5_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 5, Rating.D));
        internalMap.put(128667611, new Module("Int_Repairer_Size6_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 6, Rating.D));
        internalMap.put(128667612, new Module("Int_Repairer_Size7_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 7, Rating.D));
        internalMap.put(128667613, new Module("Int_Repairer_Size8_Class2", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 8, Rating.D));
        internalMap.put(128667614, new Module("Int_Repairer_Size1_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 1, Rating.C));
        internalMap.put(128667615, new Module("Int_Repairer_Size2_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 2, Rating.C));
        internalMap.put(128667616, new Module("Int_Repairer_Size3_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 3, Rating.C));
        internalMap.put(128667617, new Module("Int_Repairer_Size4_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 4, Rating.C));
        internalMap.put(128667618, new Module("Int_Repairer_Size5_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 5, Rating.C));
        internalMap.put(128667619, new Module("Int_Repairer_Size6_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 6, Rating.C));
        internalMap.put(128667620, new Module("Int_Repairer_Size7_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 7, Rating.C));
        internalMap.put(128667621, new Module("Int_Repairer_Size8_Class3", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 8, Rating.C));
        internalMap.put(128667622, new Module("Int_Repairer_Size1_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 1, Rating.B));
        internalMap.put(128667623, new Module("Int_Repairer_Size2_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 2, Rating.B));
        internalMap.put(128667624, new Module("Int_Repairer_Size3_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 3, Rating.B));
        internalMap.put(128667625, new Module("Int_Repairer_Size4_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 4, Rating.B));
        internalMap.put(128667626, new Module("Int_Repairer_Size5_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 5, Rating.B));
        internalMap.put(128667627, new Module("Int_Repairer_Size6_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 6, Rating.B));
        internalMap.put(128667628, new Module("Int_Repairer_Size7_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 7, Rating.B));
        internalMap.put(128667629, new Module("Int_Repairer_Size8_Class4", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 8, Rating.B));
        internalMap.put(128667630, new Module("Int_Repairer_Size1_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 1, Rating.A));
        internalMap.put(128667631, new Module("Int_Repairer_Size2_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 2, Rating.A));
        internalMap.put(128667632, new Module("Int_Repairer_Size3_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 3, Rating.A));
        internalMap.put(128667633, new Module("Int_Repairer_Size4_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 4, Rating.A));
        internalMap.put(128667634, new Module("Int_Repairer_Size5_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 5, Rating.A));
        internalMap.put(128667635, new Module("Int_Repairer_Size6_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 6, Rating.A));
        internalMap.put(128667636, new Module("Int_Repairer_Size7_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 7, Rating.A));
        internalMap.put(128667637, new Module("Int_Repairer_Size8_Class5", Category.INTERNAL, "Auto Field-Maintenance Unit", null, 8, Rating.A));
        internalMap.put(128668532, new Module("Hpt_ShieldBooster_Size0_Class1", Category.UTILITY, "Shield Booster", null, 0, Rating.E));
        internalMap.put(128668533, new Module("Hpt_ShieldBooster_Size0_Class2", Category.UTILITY, "Shield Booster", null, 0, Rating.D));
        internalMap.put(128668534, new Module("Hpt_ShieldBooster_Size0_Class3", Category.UTILITY, "Shield Booster", null, 0, Rating.C));
        internalMap.put(128668535, new Module("Hpt_ShieldBooster_Size0_Class4", Category.UTILITY, "Shield Booster", null, 0, Rating.B));
        internalMap.put(128668536, new Module("Hpt_ShieldBooster_Size0_Class5", Category.UTILITY, "Shield Booster", null, 0, Rating.A));
        internalMap.put(128668537, new Module("Int_HullReinforcement_Size1_Class1", Category.INTERNAL, "Hull Reinforcement Package", null, 1, Rating.E));
        internalMap.put(128668538, new Module("Int_HullReinforcement_Size1_Class2", Category.INTERNAL, "Hull Reinforcement Package", null, 1, Rating.D));
        internalMap.put(128668539, new Module("Int_HullReinforcement_Size2_Class1", Category.INTERNAL, "Hull Reinforcement Package", null, 2, Rating.E));
        internalMap.put(128668540, new Module("Int_HullReinforcement_Size2_Class2", Category.INTERNAL, "Hull Reinforcement Package", null, 2, Rating.D));
        internalMap.put(128668541, new Module("Int_HullReinforcement_Size3_Class1", Category.INTERNAL, "Hull Reinforcement Package", null, 3, Rating.E));
        internalMap.put(128668542, new Module("Int_HullReinforcement_Size3_Class2", Category.INTERNAL, "Hull Reinforcement Package", null, 3, Rating.D));
        internalMap.put(128668543, new Module("Int_HullReinforcement_Size4_Class1", Category.INTERNAL, "Hull Reinforcement Package", null, 4, Rating.E));
        internalMap.put(128668544, new Module("Int_HullReinforcement_Size4_Class2", Category.INTERNAL, "Hull Reinforcement Package", null, 4, Rating.D));
        internalMap.put(128668545, new Module("Int_HullReinforcement_Size5_Class1", Category.INTERNAL, "Hull Reinforcement Package", null, 5, Rating.E));
        internalMap.put(128668546, new Module("Int_HullReinforcement_Size5_Class2", Category.INTERNAL, "Hull Reinforcement Package", null, 5, Rating.D));
        internalMap.put(128671120, new Module("Hpt_Cannon_Gimbal_Large", Category.HARDPOINT, "Cannon", Mount.GIMBALLED, null, 3, Rating.C));
        internalMap.put(128671218, new Module("DiamondBack_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128671217, 1, Rating.I));
        internalMap.put(128671219, new Module("DiamondBack_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128671217, 1, Rating.I));
        internalMap.put(128671220, new Module("DiamondBack_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128671217, 1, Rating.I));
        internalMap.put(128671221, new Module("DiamondBack_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128671217, 1, Rating.I));
        internalMap.put(128671222, new Module("DiamondBack_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128671217, 1, Rating.I));
        internalMap.put(128671224, new Module("Empire_Courier_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128671223, 1, Rating.I));
        internalMap.put(128671225, new Module("Empire_Courier_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128671223, 1, Rating.I));
        internalMap.put(128671226, new Module("Empire_Courier_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128671223, 1, Rating.I));
        internalMap.put(128671227, new Module("Empire_Courier_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128671223, 1, Rating.I));
        internalMap.put(128671228, new Module("Empire_Courier_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128671223, 1, Rating.I));
        internalMap.put(128671229, new Module("Int_DroneControl_Collection_Size1_Class1", Category.INTERNAL, "Collector Limpet Controller", null, 1, Rating.E));
        internalMap.put(128671230, new Module("Int_DroneControl_Collection_Size1_Class2", Category.INTERNAL, "Collector Limpet Controller", null, 1, Rating.D));
        internalMap.put(128671231, new Module("Int_DroneControl_Collection_Size1_Class3", Category.INTERNAL, "Collector Limpet Controller", null, 1, Rating.C));
        internalMap.put(128671232, new Module("Int_DroneControl_Collection_Size1_Class4", Category.INTERNAL, "Collector Limpet Controller", null, 1, Rating.B));
        internalMap.put(128671233, new Module("Int_DroneControl_Collection_Size1_Class5", Category.INTERNAL, "Collector Limpet Controller", null, 1, Rating.A));
        internalMap.put(128671234, new Module("Int_DroneControl_Collection_Size3_Class1", Category.INTERNAL, "Collector Limpet Controller", null, 3, Rating.E));
        internalMap.put(128671235, new Module("Int_DroneControl_Collection_Size3_Class2", Category.INTERNAL, "Collector Limpet Controller", null, 3, Rating.D));
        internalMap.put(128671236, new Module("Int_DroneControl_Collection_Size3_Class3", Category.INTERNAL, "Collector Limpet Controller", null, 3, Rating.C));
        internalMap.put(128671237, new Module("Int_DroneControl_Collection_Size3_Class4", Category.INTERNAL, "Collector Limpet Controller", null, 3, Rating.B));
        internalMap.put(128671238, new Module("Int_DroneControl_Collection_Size3_Class5", Category.INTERNAL, "Collector Limpet Controller", null, 3, Rating.A));
        internalMap.put(128671239, new Module("Int_DroneControl_Collection_Size5_Class1", Category.INTERNAL, "Collector Limpet Controller", null, 5, Rating.E));
        internalMap.put(128671240, new Module("Int_DroneControl_Collection_Size5_Class2", Category.INTERNAL, "Collector Limpet Controller", null, 5, Rating.D));
        internalMap.put(128671241, new Module("Int_DroneControl_Collection_Size5_Class3", Category.INTERNAL, "Collector Limpet Controller", null, 5, Rating.C));
        internalMap.put(128671242, new Module("Int_DroneControl_Collection_Size5_Class4", Category.INTERNAL, "Collector Limpet Controller", null, 5, Rating.B));
        internalMap.put(128671243, new Module("Int_DroneControl_Collection_Size5_Class5", Category.INTERNAL, "Collector Limpet Controller", null, 5, Rating.A));
        internalMap.put(128671244, new Module("Int_DroneControl_Collection_Size7_Class1", Category.INTERNAL, "Collector Limpet Controller", null, 7, Rating.E));
        internalMap.put(128671245, new Module("Int_DroneControl_Collection_Size7_Class2", Category.INTERNAL, "Collector Limpet Controller", null, 7, Rating.D));
        internalMap.put(128671246, new Module("Int_DroneControl_Collection_Size7_Class3", Category.INTERNAL, "Collector Limpet Controller", null, 7, Rating.C));
        internalMap.put(128671247, new Module("Int_DroneControl_Collection_Size7_Class4", Category.INTERNAL, "Collector Limpet Controller", null, 7, Rating.B));
        internalMap.put(128671248, new Module("Int_DroneControl_Collection_Size7_Class5", Category.INTERNAL, "Collector Limpet Controller", null, 7, Rating.A));
        internalMap.put(128671249, new Module("Int_DroneControl_FuelTransfer_Size1_Class1", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 1, Rating.E));
        internalMap.put(128671250, new Module("Int_DroneControl_FuelTransfer_Size1_Class2", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 1, Rating.D));
        internalMap.put(128671251, new Module("Int_DroneControl_FuelTransfer_Size1_Class3", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 1, Rating.C));
        internalMap.put(128671252, new Module("Int_DroneControl_FuelTransfer_Size1_Class4", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 1, Rating.B));
        internalMap.put(128671253, new Module("Int_DroneControl_FuelTransfer_Size1_Class5", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 1, Rating.A));
        internalMap.put(128671254, new Module("Int_DroneControl_FuelTransfer_Size3_Class1", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 3, Rating.E));
        internalMap.put(128671255, new Module("Int_DroneControl_FuelTransfer_Size3_Class2", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 3, Rating.D));
        internalMap.put(128671256, new Module("Int_DroneControl_FuelTransfer_Size3_Class3", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 3, Rating.C));
        internalMap.put(128671257, new Module("Int_DroneControl_FuelTransfer_Size3_Class4", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 3, Rating.B));
        internalMap.put(128671258, new Module("Int_DroneControl_FuelTransfer_Size3_Class5", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 3, Rating.A));
        internalMap.put(128671259, new Module("Int_DroneControl_FuelTransfer_Size5_Class1", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 5, Rating.E));
        internalMap.put(128671260, new Module("Int_DroneControl_FuelTransfer_Size5_Class2", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 5, Rating.D));
        internalMap.put(128671261, new Module("Int_DroneControl_FuelTransfer_Size5_Class3", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 5, Rating.C));
        internalMap.put(128671262, new Module("Int_DroneControl_FuelTransfer_Size5_Class4", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 5, Rating.B));
        internalMap.put(128671263, new Module("Int_DroneControl_FuelTransfer_Size5_Class5", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 5, Rating.A));
        internalMap.put(128671264, new Module("Int_DroneControl_FuelTransfer_Size7_Class1", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 7, Rating.E));
        internalMap.put(128671265, new Module("Int_DroneControl_FuelTransfer_Size7_Class2", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 7, Rating.D));
        internalMap.put(128671266, new Module("Int_DroneControl_FuelTransfer_Size7_Class3", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 7, Rating.C));
        internalMap.put(128671267, new Module("Int_DroneControl_FuelTransfer_Size7_Class4", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 7, Rating.B));
        internalMap.put(128671268, new Module("Int_DroneControl_FuelTransfer_Size7_Class5", Category.INTERNAL, "Fuel Transfer Limpet Controller", null, 7, Rating.A));
        internalMap.put(128671269, new Module("Int_DroneControl_Prospector_Size1_Class1", Category.INTERNAL, "Prospector Limpet Controller", null, 1, Rating.E));
        internalMap.put(128671270, new Module("Int_DroneControl_Prospector_Size1_Class2", Category.INTERNAL, "Prospector Limpet Controller", null, 1, Rating.D));
        internalMap.put(128671271, new Module("Int_DroneControl_Prospector_Size1_Class3", Category.INTERNAL, "Prospector Limpet Controller", null, 1, Rating.C));
        internalMap.put(128671272, new Module("Int_DroneControl_Prospector_Size1_Class4", Category.INTERNAL, "Prospector Limpet Controller", null, 1, Rating.B));
        internalMap.put(128671273, new Module("Int_DroneControl_Prospector_Size1_Class5", Category.INTERNAL, "Prospector Limpet Controller", null, 1, Rating.A));
        internalMap.put(128671274, new Module("Int_DroneControl_Prospector_Size3_Class1", Category.INTERNAL, "Prospector Limpet Controller", null, 3, Rating.E));
        internalMap.put(128671275, new Module("Int_DroneControl_Prospector_Size3_Class2", Category.INTERNAL, "Prospector Limpet Controller", null, 3, Rating.D));
        internalMap.put(128671276, new Module("Int_DroneControl_Prospector_Size3_Class3", Category.INTERNAL, "Prospector Limpet Controller", null, 3, Rating.C));
        internalMap.put(128671277, new Module("Int_DroneControl_Prospector_Size3_Class4", Category.INTERNAL, "Prospector Limpet Controller", null, 3, Rating.B));
        internalMap.put(128671278, new Module("Int_DroneControl_Prospector_Size3_Class5", Category.INTERNAL, "Prospector Limpet Controller", null, 3, Rating.A));
        internalMap.put(128671279, new Module("Int_DroneControl_Prospector_Size5_Class1", Category.INTERNAL, "Prospector Limpet Controller", null, 5, Rating.E));
        internalMap.put(128671280, new Module("Int_DroneControl_Prospector_Size5_Class2", Category.INTERNAL, "Prospector Limpet Controller", null, 5, Rating.D));
        internalMap.put(128671281, new Module("Int_DroneControl_Prospector_Size5_Class3", Category.INTERNAL, "Prospector Limpet Controller", null, 5, Rating.C));
        internalMap.put(128671282, new Module("Int_DroneControl_Prospector_Size5_Class4", Category.INTERNAL, "Prospector Limpet Controller", null, 5, Rating.B));
        internalMap.put(128671283, new Module("Int_DroneControl_Prospector_Size5_Class5", Category.INTERNAL, "Prospector Limpet Controller", null, 5, Rating.A));
        internalMap.put(128671284, new Module("Int_DroneControl_Prospector_Size7_Class1", Category.INTERNAL, "Prospector Limpet Controller", null, 7, Rating.E));
        internalMap.put(128671285, new Module("Int_DroneControl_Prospector_Size7_Class2", Category.INTERNAL, "Prospector Limpet Controller", null, 7, Rating.D));
        internalMap.put(128671286, new Module("Int_DroneControl_Prospector_Size7_Class3", Category.INTERNAL, "Prospector Limpet Controller", null, 7, Rating.C));
        internalMap.put(128671287, new Module("Int_DroneControl_Prospector_Size7_Class4", Category.INTERNAL, "Prospector Limpet Controller", null, 7, Rating.B));
        internalMap.put(128671288, new Module("Int_DroneControl_Prospector_Size7_Class5", Category.INTERNAL, "Prospector Limpet Controller", null, 7, Rating.A));
        internalMap.put(128671321, new Module("Hpt_Slugshot_Gimbal_Large", Category.HARDPOINT, "Fragment Cannon", Mount.GIMBALLED, null, 3, Rating.C));
        internalMap.put(128671322, new Module("Hpt_Slugshot_Turret_Large", Category.HARDPOINT, "Fragment Cannon", Mount.TURRETED, null, 3, Rating.C));
        internalMap.put(128671323, new Module("Int_ShieldGenerator_Size1_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 1, Rating.A));
        internalMap.put(128671324, new Module("Int_ShieldGenerator_Size2_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 2, Rating.A));
        internalMap.put(128671325, new Module("Int_ShieldGenerator_Size3_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 3, Rating.A));
        internalMap.put(128671326, new Module("Int_ShieldGenerator_Size4_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 4, Rating.A));
        internalMap.put(128671327, new Module("Int_ShieldGenerator_Size5_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 5, Rating.A));
        internalMap.put(128671328, new Module("Int_ShieldGenerator_Size6_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 6, Rating.A));
        internalMap.put(128671329, new Module("Int_ShieldGenerator_Size7_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 7, Rating.A));
        internalMap.put(128671330, new Module("Int_ShieldGenerator_Size8_Class5_Strong", Category.INTERNAL, "Prismatic Shield Generator", null, 8, Rating.A));
        internalMap.put(128671331, new Module("Int_ShieldGenerator_Size1_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 1, Rating.C));
        internalMap.put(128671332, new Module("Int_ShieldGenerator_Size2_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 2, Rating.C));
        internalMap.put(128671333, new Module("Int_ShieldGenerator_Size3_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 3, Rating.C));
        internalMap.put(128671334, new Module("Int_ShieldGenerator_Size4_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 4, Rating.C));
        internalMap.put(128671335, new Module("Int_ShieldGenerator_Size5_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 5, Rating.C));
        internalMap.put(128671336, new Module("Int_ShieldGenerator_Size6_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 6, Rating.C));
        internalMap.put(128671337, new Module("Int_ShieldGenerator_Size7_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 7, Rating.C));
        internalMap.put(128671338, new Module("Int_ShieldGenerator_Size8_Class3_Fast", Category.INTERNAL, "Bi-Weave Shield Generator", null, 8, Rating.C));
        internalMap.put(128671339, new Module("Hpt_PlasmaAccelerator_Fixed_Large_Advanced", Category.HARDPOINT, "Advanced Plasma Accelerator", Mount.FIXED, null, 3, Rating.B));
        internalMap.put(128671340, new Module("Hpt_MiningLaser_Fixed_Small_Advanced", Category.HARDPOINT, "Mining Lance", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128671341, new Module("Hpt_Railgun_Fixed_Medium_Burst", Category.HARDPOINT, "Imperial Hammer Rail Gun", Mount.FIXED, null, 2, Rating.B));
        internalMap.put(128671342, new Module("Hpt_PulseLaser_Fixed_Medium_Disruptor", Category.HARDPOINT, "Pulse Disruptor Laser", Mount.FIXED, null, 2, Rating.E));
        internalMap.put(128671343, new Module("Hpt_Slugshot_Fixed_Large_Range", Category.HARDPOINT, "Pacifier Frag-Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128671344, new Module("Hpt_DrunkMissileRack_Fixed_Medium", Category.HARDPOINT, "Pack-Hound Missile Rack", Mount.FIXED, Guidance.SWARM, null, 2, Rating.B));
        internalMap.put(128671345, new Module("Hpt_MultiCannon_Fixed_Small_Strong", Category.HARDPOINT, "Enforcer Cannon", Mount.FIXED, null, 1, Rating.F));
        internalMap.put(128671346, new Module("Hpt_BeamLaser_Fixed_Small_Heat", Category.HARDPOINT, "Retributor Beam Laser", Mount.FIXED, null, 1, Rating.E));
        internalMap.put(128671448, new Module("Hpt_MineLauncher_Fixed_Small_Impulse", Category.HARDPOINT, "Shock Mine Launcher", Mount.FIXED, null, 1, Rating.I));
        internalMap.put(128671449, new Module("Hpt_PulseLaserBurst_Fixed_Small_Scatter", Category.HARDPOINT, "Cytoscrambler Burst Laser", Mount.FIXED, null, 1, Rating.F));
        internalMap.put(128671832, new Module("DiamondBackXL_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128671831, 1, Rating.I));
        internalMap.put(128671833, new Module("DiamondBackXL_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128671831, 1, Rating.I));
        internalMap.put(128671834, new Module("DiamondBackXL_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128671831, 1, Rating.I));
        internalMap.put(128671835, new Module("DiamondBackXL_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128671831, 1, Rating.I));
        internalMap.put(128671836, new Module("DiamondBackXL_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128671831, 1, Rating.I));
        internalMap.put(128672140, new Module("Empire_Eagle_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672138, 1, Rating.I));
        internalMap.put(128672141, new Module("Empire_Eagle_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672138, 1, Rating.I));
        internalMap.put(128672142, new Module("Empire_Eagle_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672138, 1, Rating.I));
        internalMap.put(128672143, new Module("Empire_Eagle_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672138, 1, Rating.I));
        internalMap.put(128672144, new Module("Empire_Eagle_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672138, 1, Rating.I));
        internalMap.put(128672147, new Module("Federation_Dropship_MkII_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672145, 1, Rating.I));
        internalMap.put(128672148, new Module("Federation_Dropship_MkII_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672145, 1, Rating.I));
        internalMap.put(128672149, new Module("Federation_Dropship_MkII_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672145, 1, Rating.I));
        internalMap.put(128672150, new Module("Federation_Dropship_MkII_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672145, 1, Rating.I));
        internalMap.put(128672151, new Module("Federation_Dropship_MkII_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672145, 1, Rating.I));
        internalMap.put(128672154, new Module("Federation_Gunship_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672152, 1, Rating.I));
        internalMap.put(128672155, new Module("Federation_Gunship_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672152, 1, Rating.I));
        internalMap.put(128672156, new Module("Federation_Gunship_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672152, 1, Rating.I));
        internalMap.put(128672157, new Module("Federation_Gunship_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672152, 1, Rating.I));
        internalMap.put(128672158, new Module("Federation_Gunship_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672152, 1, Rating.I));
        internalMap.put(128672257, new Module("Viper_MkIV_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672255, 1, Rating.I));
        internalMap.put(128672258, new Module("Viper_MkIV_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672255, 1, Rating.I));
        internalMap.put(128672259, new Module("Viper_MkIV_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672255, 1, Rating.I));
        internalMap.put(128672260, new Module("Viper_MkIV_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672255, 1, Rating.I));
        internalMap.put(128672261, new Module("Viper_MkIV_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672255, 1, Rating.I));
        internalMap.put(128672264, new Module("CobraMkIV_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672262, 1, Rating.I));
        internalMap.put(128672265, new Module("CobraMkIV_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672262, 1, Rating.I));
        internalMap.put(128672266, new Module("CobraMkIV_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672262, 1, Rating.I));
        internalMap.put(128672267, new Module("CobraMkIV_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672262, 1, Rating.I));
        internalMap.put(128672268, new Module("CobraMkIV_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672262, 1, Rating.I));
        internalMap.put(128672271, new Module("Independant_Trader_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672269, 1, Rating.I));
        internalMap.put(128672272, new Module("Independant_Trader_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672269, 1, Rating.I));
        internalMap.put(128672273, new Module("Independant_Trader_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672269, 1, Rating.I));
        internalMap.put(128672274, new Module("Independant_Trader_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672269, 1, Rating.I));
        internalMap.put(128672275, new Module("Independant_Trader_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672269, 1, Rating.I));
        internalMap.put(128672278, new Module("Asp_Scout_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128672276, 1, Rating.I));
        internalMap.put(128672279, new Module("Asp_Scout_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128672276, 1, Rating.I));
        internalMap.put(128672280, new Module("Asp_Scout_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128672276, 1, Rating.I));
        internalMap.put(128672281, new Module("Asp_Scout_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128672276, 1, Rating.I));
        internalMap.put(128672282, new Module("Asp_Scout_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128672276, 1, Rating.I));
        internalMap.put(128672288, new Module("Int_BuggyBay_Size2_Class1", Category.INTERNAL, "Planetary Vehicle Hangar", null, 2, Rating.H));
        internalMap.put(128672289, new Module("Int_BuggyBay_Size2_Class2", Category.INTERNAL, "Planetary Vehicle Hangar", null, 2, Rating.G));
        internalMap.put(128672290, new Module("Int_BuggyBay_Size4_Class1", Category.INTERNAL, "Planetary Vehicle Hangar", null, 4, Rating.H));
        internalMap.put(128672291, new Module("Int_BuggyBay_Size4_Class2", Category.INTERNAL, "Planetary Vehicle Hangar", null, 4, Rating.G));
        internalMap.put(128672292, new Module("Int_BuggyBay_Size6_Class1", Category.INTERNAL, "Planetary Vehicle Hangar", null, 6, Rating.H));
        internalMap.put(128672293, new Module("Int_BuggyBay_Size6_Class2", Category.INTERNAL, "Planetary Vehicle Hangar", null, 6, Rating.G));
        internalMap.put(128672317, new Module("Int_PlanetApproachSuite", Category.INTERNAL, "Planetary Approach Suite", null, 1, Rating.I));
        internalMap.put(128681641, new Module("Int_CorrosionProofCargoRack_Size1_Class1", Category.INTERNAL, "Corrosion Resistant Cargo Rack", null, 1, Rating.E));
        internalMap.put(128681992, new Module("Int_CorrosionProofCargoRack_Size1_Class2", Category.INTERNAL, "Corrosion Resistant Cargo Rack", null, 1, Rating.F));
        internalMap.put(128681994, new Module("Hpt_BeamLaser_Gimbal_Huge", Category.HARDPOINT, "Beam Laser", Mount.GIMBALLED, null, 4, Rating.A));
        internalMap.put(128681995, new Module("Hpt_PulseLaser_Gimbal_Huge", Category.HARDPOINT, "Pulse Laser", Mount.GIMBALLED, null, 4, Rating.A));
        internalMap.put(128681996, new Module("Hpt_MultiCannon_Gimbal_Huge", Category.HARDPOINT, "Multi-Cannon", Mount.GIMBALLED, null, 4, Rating.A));
        internalMap.put(128682013, new Module("Int_Engine_Size3_Class5_Fast", Category.STANDARD, "Enhanced Performance Thrusters", null, 3, Rating.A));
        internalMap.put(128682014, new Module("Int_Engine_Size2_Class5_Fast", Category.STANDARD, "Enhanced Performance Thrusters", null, 2, Rating.A));
        internalMap.put(128727920, new Module("Hpt_PulseLaserBurst_Gimbal_Huge", Category.HARDPOINT, "Burst Laser", Mount.GIMBALLED, null, 4, Rating.E));
        internalMap.put(128727922, new Module("Int_PassengerCabin_Size4_Class1", Category.INTERNAL, "Economy Class Passenger Cabin", null, 4, Rating.E));
        internalMap.put(128727923, new Module("Int_PassengerCabin_Size4_Class2", Category.INTERNAL, "Business Class Passenger Cabin", null, 4, Rating.D));
        internalMap.put(128727924, new Module("Int_PassengerCabin_Size4_Class3", Category.INTERNAL, "First Class Passenger Cabin", null, 4, Rating.C));
        internalMap.put(128727925, new Module("Int_PassengerCabin_Size5_Class4", Category.INTERNAL, "Luxury Class Passenger Cabin", null, 5, Rating.B));
        internalMap.put(128727926, new Module("Int_PassengerCabin_Size6_Class1", Category.INTERNAL, "Economy Class Passenger Cabin", null, 6, Rating.E));
        internalMap.put(128727927, new Module("Int_PassengerCabin_Size6_Class2", Category.INTERNAL, "Business Class Passenger Cabin", null, 6, Rating.D));
        internalMap.put(128727928, new Module("Int_PassengerCabin_Size6_Class3", Category.INTERNAL, "First Class Passenger Cabin", null, 6, Rating.C));
        internalMap.put(128727929, new Module("Int_PassengerCabin_Size6_Class4", Category.INTERNAL, "Luxury Class Passenger Cabin", null, 6, Rating.B));
        internalMap.put(128727930, new Module("Int_FighterBay_Size5_Class1", Category.INTERNAL, "Fighter Hangar", null, 5, Rating.D));
        internalMap.put(128727931, new Module("Int_FighterBay_Size6_Class1", Category.INTERNAL, "Fighter Hangar", null, 6, Rating.D));
        internalMap.put(128727932, new Module("Int_FighterBay_Size7_Class1", Category.INTERNAL, "Fighter Hangar", null, 7, Rating.D));
        internalMap.put(128732552, new Module("Hpt_DumbfireMissileRack_Fixed_Medium_Lasso", Category.HARDPOINT, "Rocket Propelled FSD Disruptor", Mount.FIXED, Guidance.DUMBFIRE, null, 2, Rating.B));
        internalMap.put(128734690, new Module("Int_PassengerCabin_Size2_Class1", Category.INTERNAL, "Economy Class Passenger Cabin", null, 2, Rating.E));
        internalMap.put(128734691, new Module("Int_PassengerCabin_Size3_Class1", Category.INTERNAL, "Economy Class Passenger Cabin", null, 3, Rating.E));
        internalMap.put(128734692, new Module("Int_PassengerCabin_Size3_Class2", Category.INTERNAL, "Business Class Passenger Cabin", null, 3, Rating.D));
        internalMap.put(128734693, new Module("Int_PassengerCabin_Size5_Class1", Category.INTERNAL, "Economy Class Passenger Cabin", null, 5, Rating.E));
        internalMap.put(128734694, new Module("Int_PassengerCabin_Size5_Class2", Category.INTERNAL, "Business Class Passenger Cabin", null, 5, Rating.D));
        internalMap.put(128734695, new Module("Int_PassengerCabin_Size5_Class3", Category.INTERNAL, "First Class Passenger Cabin", null, 5, Rating.C));
        internalMap.put(128737270, new Module("Int_ModuleReinforcement_Size1_Class1", Category.INTERNAL, "Module Reinforcement Package", null, 1, Rating.E));
        internalMap.put(128737271, new Module("Int_ModuleReinforcement_Size1_Class2", Category.INTERNAL, "Module Reinforcement Package", null, 1, Rating.D));
        internalMap.put(128737272, new Module("Int_ModuleReinforcement_Size2_Class1", Category.INTERNAL, "Module Reinforcement Package", null, 2, Rating.E));
        internalMap.put(128737273, new Module("Int_ModuleReinforcement_Size2_Class2", Category.INTERNAL, "Module Reinforcement Package", null, 2, Rating.D));
        internalMap.put(128737274, new Module("Int_ModuleReinforcement_Size3_Class1", Category.INTERNAL, "Module Reinforcement Package", null, 3, Rating.E));
        internalMap.put(128737275, new Module("Int_ModuleReinforcement_Size3_Class2", Category.INTERNAL, "Module Reinforcement Package", null, 3, Rating.D));
        internalMap.put(128737276, new Module("Int_ModuleReinforcement_Size4_Class1", Category.INTERNAL, "Module Reinforcement Package", null, 4, Rating.E));
        internalMap.put(128737277, new Module("Int_ModuleReinforcement_Size4_Class2", Category.INTERNAL, "Module Reinforcement Package", null, 4, Rating.D));
        internalMap.put(128737278, new Module("Int_ModuleReinforcement_Size5_Class1", Category.INTERNAL, "Module Reinforcement Package", null, 5, Rating.E));
        internalMap.put(128737279, new Module("Int_ModuleReinforcement_Size5_Class2", Category.INTERNAL, "Module Reinforcement Package", null, 5, Rating.D));
        internalMap.put(128740819, new Module("Hpt_MiningLaser_Turret_Small", Category.HARDPOINT, "Mining Laser", Mount.TURRETED, null, 1, Rating.D));
        internalMap.put(128740820, new Module("Hpt_MiningLaser_Turret_Medium", Category.HARDPOINT, "Mining Laser", Mount.TURRETED, null, 2, Rating.D));
        internalMap.put(128771884, new Module("Hpt_AntiUnknownShutdown_Tiny", Category.UTILITY, "Shutdown Field Neutraliser", null, 0, Rating.F));
        internalMap.put(128777327, new Module("Int_DroneControl_Repair_Size1_Class1", Category.INTERNAL, "Repair Limpet Controller", null, 1, Rating.E));
        internalMap.put(128777328, new Module("Int_DroneControl_Repair_Size1_Class2", Category.INTERNAL, "Repair Limpet Controller", null, 1, Rating.D));
        internalMap.put(128777329, new Module("Int_DroneControl_Repair_Size1_Class3", Category.INTERNAL, "Repair Limpet Controller", null, 1, Rating.C));
        internalMap.put(128777330, new Module("Int_DroneControl_Repair_Size1_Class4", Category.INTERNAL, "Repair Limpet Controller", null, 1, Rating.B));
        internalMap.put(128777331, new Module("Int_DroneControl_Repair_Size1_Class5", Category.INTERNAL, "Repair Limpet Controller", null, 1, Rating.A));
        internalMap.put(128777332, new Module("Int_DroneControl_Repair_Size3_Class1", Category.INTERNAL, "Repair Limpet Controller", null, 3, Rating.E));
        internalMap.put(128777333, new Module("Int_DroneControl_Repair_Size3_Class2", Category.INTERNAL, "Repair Limpet Controller", null, 3, Rating.D));
        internalMap.put(128777334, new Module("Int_DroneControl_Repair_Size3_Class3", Category.INTERNAL, "Repair Limpet Controller", null, 3, Rating.C));
        internalMap.put(128777335, new Module("Int_DroneControl_Repair_Size3_Class4", Category.INTERNAL, "Repair Limpet Controller", null, 3, Rating.B));
        internalMap.put(128777336, new Module("Int_DroneControl_Repair_Size3_Class5", Category.INTERNAL, "Repair Limpet Controller", null, 3, Rating.A));
        internalMap.put(128777337, new Module("Int_DroneControl_Repair_Size5_Class1", Category.INTERNAL, "Repair Limpet Controller", null, 5, Rating.E));
        internalMap.put(128777338, new Module("Int_DroneControl_Repair_Size5_Class2", Category.INTERNAL, "Repair Limpet Controller", null, 5, Rating.D));
        internalMap.put(128777339, new Module("Int_DroneControl_Repair_Size5_Class3", Category.INTERNAL, "Repair Limpet Controller", null, 5, Rating.C));
        internalMap.put(128777340, new Module("Int_DroneControl_Repair_Size5_Class4", Category.INTERNAL, "Repair Limpet Controller", null, 5, Rating.B));
        internalMap.put(128777341, new Module("Int_DroneControl_Repair_Size5_Class5", Category.INTERNAL, "Repair Limpet Controller", null, 5, Rating.A));
        internalMap.put(128777342, new Module("Int_DroneControl_Repair_Size7_Class1", Category.INTERNAL, "Repair Limpet Controller", null, 7, Rating.E));
        internalMap.put(128777343, new Module("Int_DroneControl_Repair_Size7_Class2", Category.INTERNAL, "Repair Limpet Controller", null, 7, Rating.D));
        internalMap.put(128777344, new Module("Int_DroneControl_Repair_Size7_Class3", Category.INTERNAL, "Repair Limpet Controller", null, 7, Rating.C));
        internalMap.put(128777345, new Module("Int_DroneControl_Repair_Size7_Class4", Category.INTERNAL, "Repair Limpet Controller", null, 7, Rating.B));
        internalMap.put(128777346, new Module("Int_DroneControl_Repair_Size7_Class5", Category.INTERNAL, "Repair Limpet Controller", null, 7, Rating.A));
        internalMap.put(128785621, new Module("Type9_Military_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128785619, 1, Rating.I));
        internalMap.put(128785622, new Module("Type9_Military_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128785619, 1, Rating.I));
        internalMap.put(128785623, new Module("Type9_Military_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128785619, 1, Rating.I));
        internalMap.put(128785624, new Module("Type9_Military_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128785619, 1, Rating.I));
        internalMap.put(128785625, new Module("Type9_Military_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128785619, 1, Rating.I));
        internalMap.put(128785626, new Module("Hpt_FlakMortar_Fixed_Medium", Category.HARDPOINT, "Remote Release Flak Launcher", Mount.FIXED, null, 2, Rating.B));
        internalMap.put(128788699, new Module("Hpt_ATDumbfireMissile_Fixed_Medium", Category.HARDPOINT, "AX Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 2, Rating.B));
        internalMap.put(128788700, new Module("Hpt_ATDumbfireMissile_Fixed_Large", Category.HARDPOINT, "AX Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 3, Rating.A));
        internalMap.put(128788701, new Module("Hpt_ATMultiCannon_Fixed_Medium", Category.HARDPOINT, "AX Multi-Cannon", Mount.FIXED, null, 2, Rating.E));
        internalMap.put(128788702, new Module("Hpt_ATMultiCannon_Fixed_Large", Category.HARDPOINT, "AX Multi-Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128788704, new Module("Hpt_ATDumbfireMissile_Turret_Medium", Category.HARDPOINT, "AX Missile Rack", Mount.TURRETED, Guidance.DUMBFIRE, null, 2, Rating.B));
        internalMap.put(128788705, new Module("Hpt_ATDumbfireMissile_Turret_Large", Category.HARDPOINT, "AX Missile Rack", Mount.TURRETED, Guidance.DUMBFIRE, null, 3, Rating.A));
        internalMap.put(128793058, new Module("Hpt_FlakMortar_Turret_Medium", Category.HARDPOINT, "Remote Release Flak Launcher", Mount.TURRETED, null, 2, Rating.B));
        internalMap.put(128793059, new Module("Hpt_ATMultiCannon_Turret_Medium", Category.HARDPOINT, "AX Multi-Cannon", Mount.TURRETED, null, 2, Rating.F));
        internalMap.put(128793060, new Module("Hpt_ATMultiCannon_Turret_Large", Category.HARDPOINT, "AX Multi-Cannon", Mount.TURRETED, null, 3, Rating.E));
        internalMap.put(128793115, new Module("Hpt_XenoScanner_Basic_Tiny", Category.UTILITY, "Xeno Scanner", null, 0, Rating.E));
        internalMap.put(128793116, new Module("Int_DroneControl_UnkVesselResearch", Category.INTERNAL, "Research Limpet Controller", null, 1, Rating.E));
        internalMap.put(128793117, new Module("Int_MetaAlloyHullReinforcement_Size1_Class1", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 1, Rating.E));
        internalMap.put(128793118, new Module("Int_MetaAlloyHullReinforcement_Size1_Class2", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 1, Rating.D));
        internalMap.put(128793119, new Module("Int_MetaAlloyHullReinforcement_Size2_Class1", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 2, Rating.E));
        internalMap.put(128793120, new Module("Int_MetaAlloyHullReinforcement_Size2_Class2", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 2, Rating.D));
        internalMap.put(128793121, new Module("Int_MetaAlloyHullReinforcement_Size3_Class1", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 3, Rating.E));
        internalMap.put(128793122, new Module("Int_MetaAlloyHullReinforcement_Size3_Class2", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 3, Rating.D));
        internalMap.put(128793123, new Module("Int_MetaAlloyHullReinforcement_Size4_Class1", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 4, Rating.E));
        internalMap.put(128793124, new Module("Int_MetaAlloyHullReinforcement_Size4_Class2", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 4, Rating.D));
        internalMap.put(128793125, new Module("Int_MetaAlloyHullReinforcement_Size5_Class1", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 5, Rating.E));
        internalMap.put(128793126, new Module("Int_MetaAlloyHullReinforcement_Size5_Class2", Category.INTERNAL, "Meta Alloy Hull Reinforcement", null, 5, Rating.D));
        internalMap.put(128793941, new Module("Int_DroneControl_Decontamination_Size1_Class1", Category.INTERNAL, "Decontamination Limpet Controller", null, 1, Rating.E));
        internalMap.put(128793942, new Module("Int_DroneControl_Decontamination_Size3_Class1", Category.INTERNAL, "Decontamination Limpet Controller", null, 3, Rating.E));
        internalMap.put(128793943, new Module("Int_DroneControl_Decontamination_Size5_Class1", Category.INTERNAL, "Decontamination Limpet Controller", null, 5, Rating.E));
        internalMap.put(128793944, new Module("Int_DroneControl_Decontamination_Size7_Class1", Category.INTERNAL, "Decontamination Limpet Controller", null, 7, Rating.E));
        internalMap.put(128808878, new Module("Hpt_XenoScannerMk2_Basic_Tiny", Category.UTILITY, "Enhanced Xeno Scanner", null, 0, Rating.C));
        internalMap.put(128816569, new Module("Krait_MkII_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128816567, 1, Rating.I));
        internalMap.put(128816570, new Module("Krait_MkII_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128816567, 1, Rating.I));
        internalMap.put(128816571, new Module("Krait_MkII_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128816567, 1, Rating.I));
        internalMap.put(128816572, new Module("Krait_MkII_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128816567, 1, Rating.I));
        internalMap.put(128816573, new Module("Krait_MkII_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128816567, 1, Rating.I));
        internalMap.put(128816576, new Module("TypeX_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128816574, 1, Rating.I));
        internalMap.put(128816577, new Module("TypeX_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128816574, 1, Rating.I));
        internalMap.put(128816578, new Module("TypeX_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128816574, 1, Rating.I));
        internalMap.put(128816579, new Module("TypeX_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128816574, 1, Rating.I));
        internalMap.put(128816580, new Module("TypeX_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128816574, 1, Rating.I));
        internalMap.put(128816583, new Module("TypeX_2_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128816581, 1, Rating.I));
        internalMap.put(128816584, new Module("TypeX_2_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128816581, 1, Rating.I));
        internalMap.put(128816585, new Module("TypeX_2_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128816581, 1, Rating.I));
        internalMap.put(128816586, new Module("TypeX_2_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128816581, 1, Rating.I));
        internalMap.put(128816587, new Module("TypeX_2_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128816581, 1, Rating.I));
        internalMap.put(128816590, new Module("TypeX_3_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128816588, 1, Rating.I));
        internalMap.put(128816591, new Module("TypeX_3_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128816588, 1, Rating.I));
        internalMap.put(128816592, new Module("TypeX_3_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128816588, 1, Rating.I));
        internalMap.put(128816593, new Module("TypeX_3_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128816588, 1, Rating.I));
        internalMap.put(128816594, new Module("TypeX_3_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128816588, 1, Rating.I));
        internalMap.put(128833687, new Module("Hpt_Guardian_GaussCannon_Fixed_Medium", Category.HARDPOINT, "Guardian Gauss Cannon", Mount.FIXED, null, 2, Rating.B));
        internalMap.put(128833944, new Module("Int_CorrosionProofCargoRack_Size4_Class1", Category.INTERNAL, "Corrosion Resistant Cargo Rack", null, 4, Rating.E));
        internalMap.put(128833945, new Module("Int_GuardianHullReinforcement_Size1_Class1", Category.INTERNAL, "Guardian Hull Reinforcement", null, 1, Rating.E));
        internalMap.put(128833946, new Module("Int_GuardianHullReinforcement_Size1_Class2", Category.INTERNAL, "Guardian Hull Reinforcement", null, 1, Rating.D));
        internalMap.put(128833947, new Module("Int_GuardianHullReinforcement_Size2_Class1", Category.INTERNAL, "Guardian Hull Reinforcement", null, 2, Rating.E));
        internalMap.put(128833948, new Module("Int_GuardianHullReinforcement_Size2_Class2", Category.INTERNAL, "Guardian Hull Reinforcement", null, 2, Rating.D));
        internalMap.put(128833949, new Module("Int_GuardianHullReinforcement_Size3_Class1", Category.INTERNAL, "Guardian Hull Reinforcement", null, 3, Rating.E));
        internalMap.put(128833950, new Module("Int_GuardianHullReinforcement_Size3_Class2", Category.INTERNAL, "Guardian Hull Reinforcement", null, 3, Rating.D));
        internalMap.put(128833951, new Module("Int_GuardianHullReinforcement_Size4_Class1", Category.INTERNAL, "Guardian Hull Reinforcement", null, 4, Rating.E));
        internalMap.put(128833952, new Module("Int_GuardianHullReinforcement_Size4_Class2", Category.INTERNAL, "Guardian Hull Reinforcement", null, 4, Rating.D));
        internalMap.put(128833953, new Module("Int_GuardianHullReinforcement_Size5_Class1", Category.INTERNAL, "Guardian Hull Reinforcement", null, 5, Rating.E));
        internalMap.put(128833954, new Module("Int_GuardianHullReinforcement_Size5_Class2", Category.INTERNAL, "Guardian Hull Reinforcement", null, 5, Rating.D));
        internalMap.put(128833955, new Module("Int_GuardianModuleReinforcement_Size1_Class1", Category.INTERNAL, "Guardian Module Reinforcement", null, 1, Rating.E));
        internalMap.put(128833956, new Module("Int_GuardianModuleReinforcement_Size1_Class2", Category.INTERNAL, "Guardian Module Reinforcement", null, 1, Rating.D));
        internalMap.put(128833957, new Module("Int_GuardianModuleReinforcement_Size2_Class1", Category.INTERNAL, "Guardian Module Reinforcement", null, 2, Rating.E));
        internalMap.put(128833958, new Module("Int_GuardianModuleReinforcement_Size2_Class2", Category.INTERNAL, "Guardian Module Reinforcement", null, 2, Rating.D));
        internalMap.put(128833959, new Module("Int_GuardianModuleReinforcement_Size3_Class1", Category.INTERNAL, "Guardian Module Reinforcement", null, 3, Rating.E));
        internalMap.put(128833960, new Module("Int_GuardianModuleReinforcement_Size3_Class2", Category.INTERNAL, "Guardian Module Reinforcement", null, 3, Rating.D));
        internalMap.put(128833961, new Module("Int_GuardianModuleReinforcement_Size4_Class1", Category.INTERNAL, "Guardian Module Reinforcement", null, 4, Rating.E));
        internalMap.put(128833962, new Module("Int_GuardianModuleReinforcement_Size4_Class2", Category.INTERNAL, "Guardian Module Reinforcement", null, 4, Rating.D));
        internalMap.put(128833963, new Module("Int_GuardianModuleReinforcement_Size5_Class1", Category.INTERNAL, "Guardian Module Reinforcement", null, 5, Rating.E));
        internalMap.put(128833964, new Module("Int_GuardianModuleReinforcement_Size5_Class2", Category.INTERNAL, "Guardian Module Reinforcement", null, 5, Rating.D));
        internalMap.put(128833965, new Module("Int_GuardianShieldReinforcement_Size1_Class1", Category.INTERNAL, "Guardian Shield Reinforcement", null, 1, Rating.E));
        internalMap.put(128833966, new Module("Int_GuardianShieldReinforcement_Size1_Class2", Category.INTERNAL, "Guardian Shield Reinforcement", null, 1, Rating.D));
        internalMap.put(128833967, new Module("Int_GuardianShieldReinforcement_Size2_Class1", Category.INTERNAL, "Guardian Shield Reinforcement", null, 2, Rating.E));
        internalMap.put(128833968, new Module("Int_GuardianShieldReinforcement_Size2_Class2", Category.INTERNAL, "Guardian Shield Reinforcement", null, 2, Rating.D));
        internalMap.put(128833969, new Module("Int_GuardianShieldReinforcement_Size3_Class1", Category.INTERNAL, "Guardian Shield Reinforcement", null, 3, Rating.E));
        internalMap.put(128833970, new Module("Int_GuardianShieldReinforcement_Size3_Class2", Category.INTERNAL, "Guardian Shield Reinforcement", null, 3, Rating.D));
        internalMap.put(128833971, new Module("Int_GuardianShieldReinforcement_Size4_Class1", Category.INTERNAL, "Guardian Shield Reinforcement", null, 4, Rating.E));
        internalMap.put(128833972, new Module("Int_GuardianShieldReinforcement_Size4_Class2", Category.INTERNAL, "Guardian Shield Reinforcement", null, 4, Rating.D));
        internalMap.put(128833973, new Module("Int_GuardianShieldReinforcement_Size5_Class1", Category.INTERNAL, "Guardian Shield Reinforcement", null, 5, Rating.E));
        internalMap.put(128833974, new Module("Int_GuardianShieldReinforcement_Size5_Class2", Category.INTERNAL, "Guardian Shield Reinforcement", null, 5, Rating.D));
        internalMap.put(128833975, new Module("Int_GuardianFSDBooster_Size1", Category.INTERNAL, "Guardian FSD Booster", null, 1, Rating.H));
        internalMap.put(128833976, new Module("Int_GuardianFSDBooster_Size2", Category.INTERNAL, "Guardian FSD Booster", null, 2, Rating.H));
        internalMap.put(128833977, new Module("Int_GuardianFSDBooster_Size3", Category.INTERNAL, "Guardian FSD Booster", null, 3, Rating.H));
        internalMap.put(128833978, new Module("Int_GuardianFSDBooster_Size4", Category.INTERNAL, "Guardian FSD Booster", null, 4, Rating.H));
        internalMap.put(128833979, new Module("Int_GuardianFSDBooster_Size5", Category.INTERNAL, "Guardian FSD Booster", null, 5, Rating.H));
        internalMap.put(128833980, new Module("Int_GuardianPowerDistributor_Size1", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 1, Rating.A));
        internalMap.put(128833981, new Module("Int_GuardianPowerDistributor_Size2", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 2, Rating.A));
        internalMap.put(128833982, new Module("Int_GuardianPowerDistributor_Size3", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 3, Rating.A));
        internalMap.put(128833983, new Module("Int_GuardianPowerDistributor_Size4", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 4, Rating.A));
        internalMap.put(128833984, new Module("Int_GuardianPowerDistributor_Size5", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 5, Rating.A));
        internalMap.put(128833985, new Module("Int_GuardianPowerDistributor_Size6", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 6, Rating.A));
        internalMap.put(128833986, new Module("Int_GuardianPowerDistributor_Size7", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 7, Rating.A));
        internalMap.put(128833987, new Module("Int_GuardianPowerDistributor_Size8", Category.INTERNAL, "Guardian Hybrid Power Distributor", null, 8, Rating.A));
        internalMap.put(128833988, new Module("Int_GuardianPowerplant_Size2", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 2, Rating.A));
        internalMap.put(128833989, new Module("Int_GuardianPowerplant_Size3", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 3, Rating.A));
        internalMap.put(128833990, new Module("Int_GuardianPowerplant_Size4", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 4, Rating.A));
        internalMap.put(128833991, new Module("Int_GuardianPowerplant_Size5", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 5, Rating.A));
        internalMap.put(128833992, new Module("Int_GuardianPowerplant_Size6", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 6, Rating.A));
        internalMap.put(128833993, new Module("Int_GuardianPowerplant_Size7", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 7, Rating.A));
        internalMap.put(128833994, new Module("Int_GuardianPowerplant_Size8", Category.INTERNAL, "Guardian Hybrid Power Plant", null, 8, Rating.A));
        internalMap.put(128833995, new Module("Hpt_CausticMissile_Fixed_Medium", Category.HARDPOINT, "Enzyme Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 2, Rating.B));
        internalMap.put(128833996, new Module("Hpt_FlechetteLauncher_Fixed_Medium", Category.HARDPOINT, "Remote Release Flechette Launcher", Mount.FIXED, null, 2, Rating.B));
        internalMap.put(128833997, new Module("Hpt_FlechetteLauncher_Turret_Medium", Category.HARDPOINT, "Remote Release Flechette Launcher", Mount.TURRETED, null, 2, Rating.B));
        internalMap.put(128833998, new Module("Hpt_Guardian_PlasmaLauncher_Fixed_Medium", Category.HARDPOINT, "Guardian Plasma Charger", Mount.FIXED, null, 2, Rating.B));
        internalMap.put(128833999, new Module("Hpt_Guardian_PlasmaLauncher_Turret_Medium", Category.HARDPOINT, "Guardian Plasma Charger", Mount.TURRETED, null, 2, Rating.E));
        internalMap.put(128834000, new Module("Hpt_Guardian_ShardCannon_Fixed_Medium", Category.HARDPOINT, "Guardian Shard Cannon", Mount.FIXED, null, 2, Rating.A));
        internalMap.put(128834001, new Module("Hpt_Guardian_ShardCannon_Turret_Medium", Category.HARDPOINT, "Guardian Shard Cannon", Mount.TURRETED, null, 2, Rating.D));
        internalMap.put(128834002, new Module("Hpt_PlasmaShockCannon_Fixed_Medium", Category.HARDPOINT, "Shock Cannon", Mount.FIXED, null, 2, Rating.D));
        internalMap.put(128834003, new Module("Hpt_PlasmaShockCannon_Gimbal_Medium", Category.HARDPOINT, "Shock Cannon", Mount.GIMBALLED, null, 2, Rating.D));
        internalMap.put(128834004, new Module("Hpt_PlasmaShockCannon_Turret_Medium", Category.HARDPOINT, "Shock Cannon", Mount.TURRETED, null, 2, Rating.E));
        internalMap.put(128834778, new Module("Hpt_Guardian_ShardCannon_Fixed_Large", Category.HARDPOINT, "Guardian Shard Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128834779, new Module("Hpt_Guardian_ShardCannon_Turret_Large", Category.HARDPOINT, "Guardian Shard Cannon", Mount.TURRETED, null, 3, Rating.D));
        internalMap.put(128834780, new Module("Hpt_PlasmaShockCannon_Fixed_Large", Category.HARDPOINT, "Shock Cannon", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128834781, new Module("Hpt_PlasmaShockCannon_Gimbal_Large", Category.HARDPOINT, "Shock Cannon", Mount.GIMBALLED, null, 3, Rating.C));
        internalMap.put(128834782, new Module("Hpt_PlasmaShockCannon_Turret_Large", Category.HARDPOINT, "Shock Cannon", Mount.TURRETED, null, 3, Rating.D));
        internalMap.put(128834783, new Module("Hpt_Guardian_PlasmaLauncher_Fixed_Large", Category.HARDPOINT, "Guardian Plasma Charger", Mount.FIXED, null, 3, Rating.C));
        internalMap.put(128834784, new Module("Hpt_Guardian_PlasmaLauncher_Turret_Large", Category.HARDPOINT, "Guardian Plasma Charger", Mount.TURRETED, null, 3, Rating.D));
        internalMap.put(128837858, new Module("Int_DroneControl_Recon_Size1_Class1", Category.INTERNAL, "Recon Limpet Controller", null, 1, Rating.E));
        internalMap.put(128839283, new Module("Krait_Light_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128839281, 1, Rating.I));
        internalMap.put(128839284, new Module("Krait_Light_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128839281, 1, Rating.I));
        internalMap.put(128839285, new Module("Krait_Light_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128839281, 1, Rating.I));
        internalMap.put(128839286, new Module("Krait_Light_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128839281, 1, Rating.I));
        internalMap.put(128839287, new Module("Krait_Light_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128839281, 1, Rating.I));
        internalMap.put(128841592, new Module("Int_DroneControl_Recon_Size3_Class1", Category.INTERNAL, "Recon Limpet Controller", null, 3, Rating.E));
        internalMap.put(128841593, new Module("Int_DroneControl_Recon_Size5_Class1", Category.INTERNAL, "Recon Limpet Controller", null, 5, Rating.E));
        internalMap.put(128841594, new Module("Int_DroneControl_Recon_Size7_Class1", Category.INTERNAL, "Recon Limpet Controller", null, 7, Rating.E));
        internalMap.put(128891602, new Module("Hpt_DumbfireMissileRack_Fixed_Large", Category.HARDPOINT, "Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 3, Rating.A));
        internalMap.put(128891603, new Module("Hpt_PlasmaShockCannon_Turret_Small", Category.HARDPOINT, "Shock Cannon", Mount.TURRETED, null, 1, Rating.F));
        internalMap.put(128891604, new Module("Hpt_PlasmaShockCannon_Gimbal_Small", Category.HARDPOINT, "Shock Cannon", Mount.GIMBALLED, null, 1, Rating.E));
        internalMap.put(128891605, new Module("Hpt_PlasmaShockCannon_Fixed_Small", Category.HARDPOINT, "Shock Cannon", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128891606, new Module("Hpt_Guardian_PlasmaLauncher_Turret_Small", Category.HARDPOINT, "Guardian Plasma Charger", Mount.TURRETED, null, 1, Rating.F));
        internalMap.put(128891607, new Module("Hpt_Guardian_PlasmaLauncher_Fixed_Small", Category.HARDPOINT, "Guardian Plasma Charger", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128891608, new Module("Hpt_Guardian_ShardCannon_Turret_Small", Category.HARDPOINT, "Guardian Shard Cannon", Mount.TURRETED, null, 1, Rating.F));
        internalMap.put(128891609, new Module("Hpt_Guardian_ShardCannon_Fixed_Small", Category.HARDPOINT, "Guardian Shard Cannon", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128891610, new Module("Hpt_Guardian_GaussCannon_Fixed_Small", Category.HARDPOINT, "Guardian Gauss Cannon", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128915454, new Module("Hpt_Mining_SubSurfDispMisle_Fixed_Small", Category.HARDPOINT, "Sub-Surface Displacement Missile", Mount.FIXED, Guidance.SEEKER, null, 1, Rating.B));
        internalMap.put(128915455, new Module("Hpt_Mining_SubSurfDispMisle_Turret_Small", Category.HARDPOINT, "Sub-Surface Displacement Missile", Mount.TURRETED, Guidance.SEEKER, null, 1, Rating.B));
        internalMap.put(128915456, new Module("Hpt_Mining_SubSurfDispMisle_Fixed_Medium", Category.HARDPOINT, "Sub-Surface Displacement Missile", Mount.FIXED, Guidance.SEEKER, null, 2, Rating.B));
        internalMap.put(128915457, new Module("Hpt_Mining_SubSurfDispMisle_Turret_Medium", Category.HARDPOINT, "Sub-Surface Displacement Missile", Mount.TURRETED, Guidance.SEEKER, null, 2, Rating.B));
        internalMap.put(128915458, new Module("Hpt_Mining_AbrBlstr_Fixed_Small", Category.HARDPOINT, "Abrasion Blaster", Mount.FIXED, null, 1, Rating.D));
        internalMap.put(128915459, new Module("Hpt_Mining_AbrBlstr_Turret_Small", Category.HARDPOINT, "Abrasion Blaster", Mount.TURRETED, null, 1, Rating.D));
        internalMap.put(128915460, new Module("Hpt_Mining_SeismChrgWarhd_Fixed_Medium", Category.HARDPOINT, "Seismic Charge Launcher", Mount.FIXED, Guidance.SEEKER, null, 2, Rating.B));
        internalMap.put(128915461, new Module("Hpt_Mining_SeismChrgWarhd_Turret_Medium", Category.HARDPOINT, "Seismic Charge Launcher", Mount.TURRETED, Guidance.SEEKER, null, 2, Rating.B));
        internalMap.put(128915718, new Module("Hpt_MRAScanner_Size0_Class1", Category.UTILITY, "Pulse Wave Analyser", null, 0, Rating.E));
        internalMap.put(128915719, new Module("Hpt_MRAScanner_Size0_Class2", Category.UTILITY, "Pulse Wave Analyser", null, 0, Rating.D));
        internalMap.put(128915720, new Module("Hpt_MRAScanner_Size0_Class3", Category.UTILITY, "Pulse Wave Analyser", null, 0, Rating.C));
        internalMap.put(128915721, new Module("Hpt_MRAScanner_Size0_Class4", Category.UTILITY, "Pulse Wave Analyser", null, 0, Rating.B));
        internalMap.put(128915722, new Module("Hpt_MRAScanner_Size0_Class5", Category.UTILITY, "Pulse Wave Analyser", null, 0, Rating.A));
        internalMap.put(128915981, new Module("Mamba_Armour_Grade1", Category.STANDARD, "Lightweight Alloy", 128915979, 1, Rating.I));
        internalMap.put(128915982, new Module("Mamba_Armour_Grade2", Category.STANDARD, "Reinforced Alloy", 128915979, 1, Rating.I));
        internalMap.put(128915983, new Module("Mamba_Armour_Grade3", Category.STANDARD, "Military Grade Composite", 128915979, 1, Rating.I));
        internalMap.put(128915984, new Module("Mamba_Armour_Mirrored", Category.STANDARD, "Mirrored Surface Composite", 128915979, 1, Rating.I));
        internalMap.put(128915985, new Module("Mamba_Armour_Reactive", Category.STANDARD, "Reactive Surface Composite", 128915979, 1, Rating.I));
        internalMap.put(128932273, new Module("Int_SupercruiseAssist", Category.INTERNAL, "Supercruise Assist", null, 1, Rating.E));
        internalMap.put(128935155, new Module("Int_DockingComputer_Advanced", Category.INTERNAL, "Advanced Docking Computer", null, 1, Rating.E));
        internalMap.put(128935980, new Module("Hpt_MultiCannon_Fixed_Medium_Advanced", Category.HARDPOINT, "Advanced Multi-Cannon", Mount.FIXED, null, 2, Rating.E));
        internalMap.put(128935981, new Module("Hpt_MultiCannon_Fixed_Small_Advanced", Category.HARDPOINT, "Advanced Multi-Cannon", Mount.FIXED, null, 1, Rating.F));
        internalMap.put(128935982, new Module("Hpt_DumbfireMissileRack_Fixed_Small_Advanced", Category.HARDPOINT, "Advanced Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 1, Rating.B));
        internalMap.put(128935983, new Module("Hpt_DumbfireMissileRack_Fixed_Medium_Advanced", Category.HARDPOINT, "Advanced Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 2, Rating.B));
        internalMap.put(128975719, new Module("Int_PlanetApproachSuite_Advanced", Category.INTERNAL, "Advanced Planetary Approach Suite", null, 1, Rating.I));
        internalMap.put(129001921, new Module("Int_MultiDroneControl_Mining_Size3_Class1", Category.INTERNAL, "Mining Multi Limpet Controller", null, 3, Rating.E));
        internalMap.put(129001922, new Module("Int_MultiDroneControl_Mining_Size3_Class3", Category.INTERNAL, "Mining Multi Limpet Controller", null, 3, Rating.C));
        internalMap.put(129001923, new Module("Int_MultiDroneControl_Operations_Size3_Class3", Category.INTERNAL, "Operations Multi Limpet Controller", null, 3, Rating.C));
        internalMap.put(129001924, new Module("Int_MultiDroneControl_Operations_Size3_Class4", Category.INTERNAL, "Operations Multi Limpet Controller", null, 3, Rating.B));
        internalMap.put(129001925, new Module("Int_MultiDroneControl_Rescue_Size3_Class2", Category.INTERNAL, "Rescue Multi Limpet Controller", null, 3, Rating.D));
        internalMap.put(129001926, new Module("Int_MultiDroneControl_Rescue_Size3_Class3", Category.INTERNAL, "Rescue Multi Limpet Controller", null, 3, Rating.C));
        internalMap.put(129001927, new Module("Int_MultiDroneControl_Xeno_Size3_Class3", Category.INTERNAL, "Xeno Multi Limpet Controller", null, 3, Rating.C));
        internalMap.put(129001928, new Module("Int_MultiDroneControl_Xeno_Size3_Class4", Category.INTERNAL, "Xeno Multi Limpet Controller", null, 3, Rating.B));
        internalMap.put(129001929, new Module("Int_MultiDroneControl_Universal_Size7_Class3", Category.INTERNAL, "Universal Multi Limpet Controller", null, 7, Rating.C));
        internalMap.put(129001930, new Module("Int_MultiDroneControl_Universal_Size7_Class5", Category.INTERNAL, "Universal Multi Limpet Controller", null, 7, Rating.A));
        internalMap.put(129019260, new Module("Int_ExpModuleStabiliser_Size3_Class3", Category.INTERNAL, "Experimental Weapon Stabiliser", null, 3, Rating.F));
        internalMap.put(129019261, new Module("Int_ExpModuleStabiliser_Size5_Class3", Category.INTERNAL, "Experimental Weapon Stabiliser", null, 5, Rating.F));
        internalMap.put(129019262, new Module("Hpt_CausticSinkLauncher_Turret_Tiny", Category.UTILITY, "Caustic Sink Launcher", null, 0, Rating.I));
        internalMap.put(129022079, new Module("Hpt_ATDumbfireMissile_Fixed_Large_V2", Category.HARDPOINT, "Enhanced AX Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 3, Rating.B));
        internalMap.put(129022080, new Module("Hpt_ATMultiCannon_Fixed_Medium_V2", Category.HARDPOINT, "Enhanced AX Multi-Cannon", Mount.FIXED, null, 2, Rating.D));
        internalMap.put(129022081, new Module("Hpt_ATDumbfireMissile_Fixed_Medium_V2", Category.HARDPOINT, "Enhanced AX Missile Rack", Mount.FIXED, Guidance.DUMBFIRE, null, 2, Rating.D));
        internalMap.put(129022082, new Module("Hpt_ATDumbfireMissile_Turret_Large_V2", Category.HARDPOINT, "Enhanced AX Missile Rack", Mount.TURRETED, Guidance.DUMBFIRE, null, 3, Rating.D));
        internalMap.put(129022083, new Module("Hpt_ATDumbfireMissile_Turret_Medium_V2", Category.HARDPOINT, "Enhanced AX Missile Rack", Mount.TURRETED, Guidance.DUMBFIRE, null, 2, Rating.E));
        internalMap.put(129022084, new Module("Hpt_ATMultiCannon_Fixed_Large_V2", Category.HARDPOINT, "Enhanced AX Multi-Cannon", Mount.FIXED, null, 3, Rating.B));
        internalMap.put(129022085, new Module("Hpt_ATMultiCannon_Turret_Large_V2", Category.HARDPOINT, "Enhanced AX Multi-Cannon", Mount.TURRETED, null, 3, Rating.D));
        internalMap.put(129022086, new Module("Hpt_ATMultiCannon_Turret_Medium_V2", Category.HARDPOINT, "Enhanced AX Multi-Cannon", Mount.TURRETED, null, 2, Rating.E));
        internalMap.put(129022088, new Module("Hpt_ATMultiCannon_Gimbal_Large", Category.HARDPOINT, "Enhanced AX Multi-Cannon", Mount.GIMBALLED, null, 3, Rating.C));
        internalMap.put(129022089, new Module("Hpt_ATMultiCannon_Gimbal_Medium", Category.HARDPOINT, "Enhanced AX Multi-Cannon", Mount.GIMBALLED, null, 2, Rating.E));
        internalMap.put(129022663, new Module("Hpt_AntiUnknownShutdown_Tiny_V2", Category.UTILITY, "Thargoid Pulse Neutraliser", null, 0, Rating.E));
        return UnalterableMap.unalterableMap(internalMap);
    }

    public static Outfitting.Module getFromId(int id)
    {
        return map.get(id);
    }

    public static Function<ICarrierModule, Module> ToModule = m -> getFromId(m.getFdevId());
}
