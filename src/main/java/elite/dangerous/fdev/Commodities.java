package elite.dangerous.fdev;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import space.tscg.collections.map.UnalterableMap;

@Getter
public class Commodities
{
    private volatile static Commodities instance;
    private Map<Integer, Commodity> map;
    private Map<String, String>     toLowerCaseSymbolMap;
    
    private static Commodities _instance()
    {
        if (instance == null) {
            synchronized (Commodities.class) {
                if (instance == null) {
                    instance = new Commodities();
                }
            }
        }
        return instance;
    }
    
    private Commodities()
    {
        this.toLowerCaseSymbolMap = new LinkedHashMap<>();
        this.map = this.buildMap();
        this.map.forEach((t, u) -> {
            this.toLowerCaseSymbolMap.put(u.symbol.toLowerCase(), u.name);
        });
    }

    private Map<Integer, Commodity> buildMap()
    {
        var internalMap = new HashMap<Integer, Commodity>();
        internalMap.put(128049152, new Commodity("Platinum", "Metals", "Platinum"));
        internalMap.put(128049153, new Commodity("Palladium", "Metals", "Palladium"));
        internalMap.put(128049154, new Commodity("Gold", "Metals", "Gold"));
        internalMap.put(128049155, new Commodity("Silver", "Metals", "Silver"));
        internalMap.put(128049156, new Commodity("Bertrandite", "Minerals", "Bertrandite "));
        internalMap.put(128049157, new Commodity("Indite", "Minerals", "Indite"));
        internalMap.put(128049158, new Commodity("Gallite", "Minerals", "Gallite "));
        internalMap.put(128049159, new Commodity("Coltan", "Minerals", "Coltan"));
        internalMap.put(128049160, new Commodity("Uraninite", "Minerals", "Uraninite"));
        internalMap.put(128049161, new Commodity("Lepidolite", "Minerals", "Lepidolite"));
        internalMap.put(128049162, new Commodity("Cobalt", "Metals", "Cobalt"));
        internalMap.put(128049163, new Commodity("Rutile", "Minerals", "Rutile"));
        internalMap.put(128049165, new Commodity("Bauxite", "Minerals", "Bauxite "));
        internalMap.put(128049166, new Commodity("Water", "Chemicals", "Water"));
        internalMap.put(128049168, new Commodity("Beryllium", "Metals", "Beryllium"));
        internalMap.put(128049169, new Commodity("Indium", "Metals", "Indium"));
        internalMap.put(128049170, new Commodity("Gallium", "Metals", "Gallium "));
        internalMap.put(128049171, new Commodity("Tantalum", "Metals", "Tantalum"));
        internalMap.put(128049172, new Commodity("Uranium", "Metals", "Uranium "));
        internalMap.put(128049173, new Commodity("Lithium", "Metals", "Lithium "));
        internalMap.put(128049174, new Commodity("Titanium", "Metals", "Titanium"));
        internalMap.put(128049175, new Commodity("Copper", "Metals", "Copper"));
        internalMap.put(128049176, new Commodity("Aluminium", "Metals", "Aluminium"));
        internalMap.put(128049177, new Commodity("Algae", "Foods", "Algae"));
        internalMap.put(128049178, new Commodity("FruitAndVegetables", "Foods", "Fruit and Vegetables"));
        internalMap.put(128049180, new Commodity("Grain", "Foods", "Grain"));
        internalMap.put(128049182, new Commodity("Animalmeat", "Foods", "Animal Meat "));
        internalMap.put(128049183, new Commodity("Fish", "Foods", "Fish"));
        internalMap.put(128049184, new Commodity("FoodCartridges", "Foods", "Food Cartridges "));
        internalMap.put(128049185, new Commodity("SyntheticMeat", "Foods", "Synthetic Meat"));
        internalMap.put(128049188, new Commodity("Tea", "Foods", "Tea "));
        internalMap.put(128049189, new Commodity("Coffee", "Foods", "Coffee"));
        internalMap.put(128049190, new Commodity("Leather", "Textiles", "Leather "));
        internalMap.put(128049191, new Commodity("NaturalFabrics", "Textiles", "Natural Fabrics "));
        internalMap.put(128049193, new Commodity("SyntheticFabrics", "Textiles", "Synthetic Fabrics"));
        internalMap.put(128049197, new Commodity("Polymers", "Industrial Materials", "Polymers"));
        internalMap.put(128049199, new Commodity("Semiconductors", "Industrial Materials", "Semiconductors"));
        internalMap.put(128049200, new Commodity("Superconductors", "Industrial Materials", "Superconductors "));
        internalMap.put(128049202, new Commodity("HydrogenFuel", "Chemicals", "Hydrogen Fuel"));
        internalMap.put(128049203, new Commodity("MineralOil", "Chemicals", "Mineral Oil "));
        internalMap.put(128049204, new Commodity("Explosives", "Chemicals", "Explosives"));
        internalMap.put(128049205, new Commodity("Pesticides", "Chemicals", "Pesticides"));
        internalMap.put(128049208, new Commodity("AgriculturalMedicines", "Medicines", "Agri-Medicines"));
        internalMap.put(128049209, new Commodity("PerformanceEnhancers", "Medicines", "Performance Enhancers"));
        internalMap.put(128049210, new Commodity("BasicMedicines", "Medicines", "Basic Medicines "));
        internalMap.put(128049212, new Commodity("BasicNarcotics", "Legal Drugs", "Narcotics"));
        internalMap.put(128049213, new Commodity("Tobacco", "Legal Drugs", "Tobacco "));
        internalMap.put(128049214, new Commodity("Beer", "Legal Drugs", "Beer"));
        internalMap.put(128049215, new Commodity("Wine", "Legal Drugs", "Wine"));
        internalMap.put(128049216, new Commodity("Liquor", "Legal Drugs", "Liquor"));
        internalMap.put(128049217, new Commodity("PowerGenerators", "Machinery", "Power Generators"));
        internalMap.put(128049218, new Commodity("WaterPurifiers", "Machinery", "Water Purifiers "));
        internalMap.put(128049220, new Commodity("HeliostaticFurnaces", "Machinery", "Microbial Furnaces"));
        internalMap.put(128049221, new Commodity("MineralExtractors", "Machinery", "Mineral Extractors"));
        internalMap.put(128049222, new Commodity("CropHarvesters", "Machinery", "Crop Harvesters "));
        internalMap.put(128049223, new Commodity("MarineSupplies", "Machinery", "Marine Equipment"));
        internalMap.put(128049225, new Commodity("ComputerComponents", "Technology", "Computer Components "));
        internalMap.put(128049226, new Commodity("HazardousEnvironmentSuits", "Technology", "H.E. Suits"));
        internalMap.put(128049227, new Commodity("Robotics", "Technology", "Robotics"));
        internalMap.put(128049228, new Commodity("AutoFabricators", "Technology", "Auto-Fabricators"));
        internalMap.put(128049229, new Commodity("AnimalMonitors", "Technology", "Animal Monitors "));
        internalMap.put(128049230, new Commodity("AquaponicSystems", "Technology", "Aquaponic Systems"));
        internalMap.put(128049231, new Commodity("AdvancedCatalysers", "Technology", "Advanced Catalysers "));
        internalMap.put(128049232, new Commodity("TerrainEnrichmentSystems", "Technology", "Land Enrichment Systems "));
        internalMap.put(128049233, new Commodity("PersonalWeapons", "Weapons", "Personal Weapons"));
        internalMap.put(128049234, new Commodity("BattleWeapons", "Weapons", "Battle Weapons"));
        internalMap.put(128049235, new Commodity("ReactiveArmour", "Weapons", "Reactive Armour "));
        internalMap.put(128049236, new Commodity("NonLethalWeapons", "Weapons", "Non-Lethal Weapons"));
        internalMap.put(128049238, new Commodity("DomesticAppliances", "Consumer Items", "Domestic Appliances "));
        internalMap.put(128049240, new Commodity("ConsumerTechnology", "Consumer Items", "Consumer Technology "));
        internalMap.put(128049241, new Commodity("Clothing", "Consumer Items", "Clothing"));
        internalMap.put(128049243, new Commodity("Slaves", "Slavery", "Slaves"));
        internalMap.put(128049244, new Commodity("Biowaste", "Waste", "Biowaste"));
        internalMap.put(128049245, new Commodity("ToxicWaste", "Waste", "Toxic Waste "));
        internalMap.put(128049246, new Commodity("ChemicalWaste", "Waste", "Chemical Waste"));
        internalMap.put(128049248, new Commodity("Scrap", "Waste", "Scrap"));
        internalMap.put(128049669, new Commodity("ProgenitorCells", "Medicines", "Progenitor Cells"));
        internalMap.put(128049670, new Commodity("CombatStabilisers", "Medicines", "Combat Stabilisers"));
        internalMap.put(128049671, new Commodity("ResonatingSeparators", "Technology", "Resonating Separators"));
        internalMap.put(128049672, new Commodity("BioReducingLichen", "Technology", "Bioreducing Lichen"));
        internalMap.put(128064028, new Commodity("AtmosphericExtractors", "Machinery", "Atmospheric Processors"));
        internalMap.put(128066403, new Commodity("Drones", "NonMarketable", "Limpets "));
        internalMap.put(128666752, new Commodity("USSCargoBlackBox", "Salvage", "Black Box"));
        internalMap.put(128666754, new Commodity("USSCargoTradeData", "Salvage", "Trade Data"));
        internalMap.put(128666755, new Commodity("USSCargoMilitaryPlans", "Salvage", "Military Plans"));
        internalMap.put(128666756, new Commodity("USSCargoAncientArtefact", "Salvage", "Ancient Artefact"));
        internalMap.put(128666757, new Commodity("USSCargoRareArtwork", "Salvage", "Rare Artwork"));
        internalMap.put(128666758, new Commodity("USSCargoExperimentalChemicals", "Salvage", "Experimental Chemicals"));
        internalMap.put(128666759, new Commodity("USSCargoRebelTransmissions", "Salvage", "Rebel Transmissions "));
        internalMap.put(128666760, new Commodity("USSCargoPrototypeTech", "Salvage", "Prototype Tech"));
        internalMap.put(128666761, new Commodity("USSCargoTechnicalBlueprints", "Salvage", "Technical Blueprints"));
        internalMap.put(128667728, new Commodity("ImperialSlaves", "Slavery", "Imperial Slaves "));
        internalMap.put(128668547, new Commodity("UnknownArtifact", "Salvage", "Thargoid Sensor "));
        internalMap.put(128668548, new Commodity("AiRelics", "Salvage", "AI Relics"));
        internalMap.put(128668549, new Commodity("Hafnium178", "Metals", "Hafnium 178 "));
        internalMap.put(128668550, new Commodity("Painite", "Minerals", "Painite "));
        internalMap.put(128668551, new Commodity("Antiquities", "Salvage", "Antiquities "));
        internalMap.put(128668552, new Commodity("MilitaryIntelligence", "Salvage", "Military Intelligence"));
        internalMap.put(128671118, new Commodity("Osmium", "Metals", "Osmium"));
        internalMap.put(128671443, new Commodity("SAP8CoreContainer", "Salvage", "SAP 8 Core Container"));
        internalMap.put(128671444, new Commodity("TrinketsOfFortune", "Consumer Items", "Trinkets of Hidden Fortune"));
        internalMap.put(128672123, new Commodity("WreckageComponents", "Salvage", "Wreckage Components "));
        internalMap.put(128672124, new Commodity("EncriptedDataStorage", "Salvage", "Encrypted Data Storage"));
        internalMap.put(128672125, new Commodity("OccupiedCryoPod", "Salvage", "Occupied Escape Pod "));
        internalMap.put(128672126, new Commodity("PersonalEffects", "Salvage", "Personal Effects"));
        internalMap.put(128672127, new Commodity("ComercialSamples", "Salvage", "Commercial Samples"));
        internalMap.put(128672128, new Commodity("TacticalData", "Salvage", "Tactical Data"));
        internalMap.put(128672129, new Commodity("AssaultPlans", "Salvage", "Assault Plans"));
        internalMap.put(128672130, new Commodity("EncryptedCorrespondence", "Salvage", "Encrypted Correspondence"));
        internalMap.put(128672131, new Commodity("DiplomaticBag", "Salvage", "Diplomatic Bag"));
        internalMap.put(128672132, new Commodity("ScientificResearch", "Salvage", "Scientific Research "));
        internalMap.put(128672133, new Commodity("ScientificSamples", "Salvage", "Scientific Samples"));
        internalMap.put(128672134, new Commodity("PoliticalPrisoner", "Salvage", "Political Prisoners "));
        internalMap.put(128672135, new Commodity("Hostage", "Salvage", "Hostages"));
        internalMap.put(128672136, new Commodity("LargeExplorationDataCash", "Salvage", "Large Survey Data Cache "));
        internalMap.put(128672137, new Commodity("SmallExplorationDataCash", "Salvage", "Small Survey Data Cache "));
        internalMap.put(128672159, new Commodity("AntiqueJewellery", "Salvage", "Antique Jewellery"));
        internalMap.put(128672160, new Commodity("PreciousGems", "Salvage", "Precious Gems"));
        internalMap.put(128672161, new Commodity("EarthRelics", "Salvage", "Earth Relics"));
        internalMap.put(128672162, new Commodity("GeneBank", "Salvage", "Gene Bank"));
        internalMap.put(128672163, new Commodity("TimeCapsule", "Salvage", "Time Capsule"));
        internalMap.put(128672294, new Commodity("Cryolite", "Minerals", "Cryolite"));
        internalMap.put(128672295, new Commodity("Goslarite", "Minerals", "Goslarite"));
        internalMap.put(128672296, new Commodity("Moissanite", "Minerals", "Moissanite"));
        internalMap.put(128672297, new Commodity("Pyrophyllite", "Minerals", "Pyrophyllite"));
        internalMap.put(128672298, new Commodity("Lanthanum", "Metals", "Lanthanum"));
        internalMap.put(128672299, new Commodity("Thallium", "Metals", "Thallium"));
        internalMap.put(128672300, new Commodity("Bismuth", "Metals", "Bismuth "));
        internalMap.put(128672301, new Commodity("Thorium", "Metals", "Thorium "));
        internalMap.put(128672302, new Commodity("CeramicComposites", "Industrial Materials", "Ceramic Composites"));
        internalMap.put(128672303, new Commodity("SyntheticReagents", "Chemicals", "Synthetic Reagents"));
        internalMap.put(128672304, new Commodity("NerveAgents", "Chemicals", "Nerve Agents"));
        internalMap.put(128672305, new Commodity("SurfaceStabilisers", "Chemicals", "Surface Stabilisers "));
        internalMap.put(128672306, new Commodity("BootlegLiquor", "Legal Drugs", "Bootleg Liquor"));
        internalMap.put(128672307, new Commodity("GeologicalEquipment", "Machinery", "Geological Equipment"));
        internalMap.put(128672308, new Commodity("ThermalCoolingUnits", "Machinery", "Thermal Cooling Units"));
        internalMap.put(128672309, new Commodity("BuildingFabricators", "Machinery", "Building Fabricators"));
        internalMap.put(128672310, new Commodity("MuTomImager", "Technology", "Muon Imager "));
        internalMap.put(128672311, new Commodity("StructuralRegulators", "Technology", "Structural Regulators"));
        internalMap.put(128672312, new Commodity("Landmines", "Weapons", "Landmines"));
        internalMap.put(128672313, new Commodity("SkimerComponents", "Machinery", "Skimmer Components"));
        internalMap.put(128672314, new Commodity("EvacuationShelter", "Consumer Items", "Evacuation Shelter"));
        internalMap.put(128672315, new Commodity("GeologicalSamples", "Salvage", "Geological Samples"));
        internalMap.put(128672701, new Commodity("MetaAlloys", "Industrial Materials", "Meta-Alloys "));
        internalMap.put(128672775, new Commodity("Taaffeite", "Minerals", "Taaffeite"));
        internalMap.put(128672776, new Commodity("Jadeite", "Minerals", "Jadeite "));
        internalMap.put(128672810, new Commodity("UnstableDataCore", "Salvage", "Unstable Data Core"));
        internalMap.put(128672811, new Commodity("DamagedEscapePod", "Salvage", "Damaged Escape Pod"));
        internalMap.put(128673845, new Commodity("Praseodymium", "Metals", "Praseodymium"));
        internalMap.put(128673846, new Commodity("Bromellite", "Minerals", "Bromellite"));
        internalMap.put(128673847, new Commodity("Samarium", "Metals", "Samarium"));
        internalMap.put(128673848, new Commodity("LowTemperatureDiamond", "Minerals", "Low Temperature Diamonds"));
        internalMap.put(128673850, new Commodity("HydrogenPeroxide", "Chemicals", "Hydrogen Peroxide"));
        internalMap.put(128673851, new Commodity("LiquidOxygen", "Chemicals", "Liquid oxygen"));
        internalMap.put(128673852, new Commodity("MethanolMonohydrateCrystals", "Minerals", "Methanol Monohydrate Crystals"));
        internalMap.put(128673853, new Commodity("LithiumHydroxide", "Minerals", "Lithium Hydroxide"));
        internalMap.put(128673854, new Commodity("MethaneClathrate", "Minerals", "Methane Clathrate"));
        internalMap.put(128673855, new Commodity("InsulatingMembrane", "Industrial Materials", "Insulating Membrane "));
        internalMap.put(128673856, new Commodity("CMMComposite", "Industrial Materials", "CMM Composite"));
        internalMap.put(128673857, new Commodity("CoolingHoses", "Industrial Materials", "Micro-weave Cooling Hoses"));
        internalMap.put(128673858, new Commodity("NeofabricInsulation", "Industrial Materials", "Neofabric Insulation"));
        internalMap.put(128673859, new Commodity("ArticulationMotors", "Machinery", "Articulation Motors "));
        internalMap.put(128673860, new Commodity("HNShockMount", "Machinery", "HN Shock Mount"));
        internalMap.put(128673861, new Commodity("EmergencyPowerCells", "Machinery", "Emergency Power Cells"));
        internalMap.put(128673862, new Commodity("PowerConverter", "Machinery", "Power Converter "));
        internalMap.put(128673863, new Commodity("PowerGridAssembly", "Machinery", "Energy Grid Assembly"));
        internalMap.put(128673864, new Commodity("PowerTransferConduits", "Machinery", "Power Transfer Bus"));
        internalMap.put(128673865, new Commodity("RadiationBaffle", "Machinery", "Radiation Baffle"));
        internalMap.put(128673866, new Commodity("ExhaustManifold", "Machinery", "Exhaust Manifold"));
        internalMap.put(128673867, new Commodity("ReinforcedMountingPlate", "Machinery", "Reinforced Mounting Plate"));
        internalMap.put(128673868, new Commodity("HeatsinkInterlink", "Machinery", "Heatsink Interlink"));
        internalMap.put(128673869, new Commodity("MagneticEmitterCoil", "Machinery", "Magnetic Emitter Coil"));
        internalMap.put(128673870, new Commodity("ModularTerminals", "Machinery", "Modular Terminals"));
        internalMap.put(128673871, new Commodity("Nanobreakers", "Technology", "Nanobreakers"));
        internalMap.put(128673872, new Commodity("TelemetrySuite", "Technology", "Telemetry Suite "));
        internalMap.put(128673873, new Commodity("MicroControllers", "Technology", "Micro Controllers"));
        internalMap.put(128673874, new Commodity("IonDistributor", "Machinery", "Ion Distributor "));
        internalMap.put(128673875, new Commodity("DiagnosticSensor", "Technology", "Hardware Diagnostic Sensor"));
        internalMap.put(128673876, new Commodity("UnknownArtifact2", "Salvage", "Thargoid Probe"));
        internalMap.put(128682044, new Commodity("ConductiveFabrics", "Textiles", "Conductive Fabrics"));
        internalMap.put(128682045, new Commodity("MilitaryGradeFabrics", "Textiles", "Military Grade Fabrics"));
        internalMap.put(128682046, new Commodity("AdvancedMedicines", "Medicines", "Advanced Medicines"));
        internalMap.put(128682047, new Commodity("MedicalDiagnosticEquipment", "Technology", "Medical Diagnostic Equipment"));
        internalMap.put(128682048, new Commodity("SurvivalEquipment", "Consumer Items", "Survival Equipment"));
        internalMap.put(128682049, new Commodity("DataCore", "Salvage", "Data Core"));
        internalMap.put(128682051, new Commodity("MysteriousIdol", "Salvage", "Mysterious Idol "));
        internalMap.put(128682052, new Commodity("ProhibitedResearchMaterials", "Salvage", "Prohibited Research Materials"));
        internalMap.put(128682053, new Commodity("AntimatterContainmentUnit", "Salvage", "Antimatter Containment Unit "));
        internalMap.put(128682054, new Commodity("SpacePioneerRelics", "Salvage", "Space Pioneer Relics"));
        internalMap.put(128682055, new Commodity("FossilRemnants", "Salvage", "Fossil Remnants "));
        internalMap.put(128732183, new Commodity("AncientRelic", "Salvage", "Guardian Relic"));
        internalMap.put(128732184, new Commodity("AncientOrb", "Salvage", "Guardian Orb"));
        internalMap.put(128732185, new Commodity("AncientCasket", "Salvage", "Guardian Casket "));
        internalMap.put(128732186, new Commodity("AncientTablet", "Salvage", "Guardian Tablet "));
        internalMap.put(128732187, new Commodity("AncientUrn", "Salvage", "Guardian Urn"));
        internalMap.put(128732188, new Commodity("AncientTotem", "Salvage", "Guardian Totem"));
        internalMap.put(128737287, new Commodity("UnknownResin", "Salvage", "Thargoid Resin"));
        internalMap.put(128737288, new Commodity("UnknownBiologicalMatter", "Salvage", "Thargoid Biological Matter"));
        internalMap.put(128737289, new Commodity("UnknownTechnologySamples", "Salvage", "Thargoid Technology Samples "));
        internalMap.put(128740752, new Commodity("UnknownArtifact3", "Salvage", "Thargoid Link"));
        internalMap.put(128793127, new Commodity("ThargoidHeart", "Salvage", "Thargoid Heart"));
        internalMap.put(128793128, new Commodity("ThargoidTissueSampleType1", "Salvage", "Thargoid Cyclops Tissue Sample"));
        internalMap.put(128793129, new Commodity("ThargoidTissueSampleType2", "Salvage", "Thargoid Basilisk Tissue Sample "));
        internalMap.put(128793130, new Commodity("ThargoidTissueSampleType3", "Salvage", "Thargoid Medusa Tissue Sample"));
        internalMap.put(128824468, new Commodity("ThargoidScoutTissueSample", "Salvage", "Thargoid Scout Tissue Sample"));
        internalMap.put(128888499, new Commodity("AncientKey", "Salvage", "Ancient Key "));
        internalMap.put(128902652, new Commodity("ThargoidTissueSampleType4", "Salvage", "Thargoid Hydra Tissue Sample"));
        internalMap.put(128922517, new Commodity("M_TissueSample_Fluid", "Salvage", "Mollusc Fluid"));
        internalMap.put(128922518, new Commodity("M_TissueSample_Soft", "Salvage", "Mollusc Soft Tissue "));
        internalMap.put(128922519, new Commodity("M_TissueSample_Nerves", "Salvage", "Mollusc Brain Tissue"));
        internalMap.put(128922520, new Commodity("S_TissueSample_Cells", "Salvage", "Pod Core Tissue "));
        internalMap.put(128922521, new Commodity("S_TissueSample_Surface", "Salvage", "Pod Dead Tissue "));
        internalMap.put(128922522, new Commodity("S_TissueSample_Core", "Salvage", "Pod Surface Tissue"));
        internalMap.put(128922523, new Commodity("P_ParticulateSample", "Salvage", "Anomaly Particles"));
        internalMap.put(128922781, new Commodity("S9_TissueSample_Shell", "Salvage", "Pod Tissue"));
        internalMap.put(128922782, new Commodity("M3_TissueSample_Membrane", "Salvage", "Mollusc Membrane"));
        internalMap.put(128922783, new Commodity("M3_TissueSample_Mycelium", "Salvage", "Mollusc Mycelium"));
        internalMap.put(128922784, new Commodity("M3_TissueSample_Spores", "Salvage", "Mollusc Spores"));
        internalMap.put(128922785, new Commodity("S6_TissueSample_Mesoglea", "Salvage", "Pod Mesoglea"));
        internalMap.put(128922786, new Commodity("S6_TissueSample_Cells", "Salvage", "Pod Outer Tissue"));
        internalMap.put(128922787, new Commodity("S6_TissueSample_Coenosarc", "Salvage", "Pod Shell Tissue"));
        internalMap.put(128924325, new Commodity("Rhodplumsite", "Minerals", "Rhodplumsite"));
        internalMap.put(128924326, new Commodity("Serendibite", "Minerals", "Serendibite "));
        internalMap.put(128924327, new Commodity("Monazite", "Minerals", "Monazite"));
        internalMap.put(128924328, new Commodity("Musgravite", "Minerals", "Musgravite"));
        internalMap.put(128924329, new Commodity("Benitoite", "Minerals", "Benitoite"));
        internalMap.put(128924330, new Commodity("Grandidierite", "Minerals", "Grandidierite"));
        internalMap.put(128924331, new Commodity("Alexandrite", "Minerals", "Alexandrite "));
        internalMap.put(128924332, new Commodity("Opal", "Minerals", "Void Opal"));
        internalMap.put(128924333, new Commodity("RockforthFertiliser", "Chemicals", "Rockforth Fertiliser"));
        internalMap.put(128924334, new Commodity("AgronomicTreatment", "Chemicals", "Agronomic Treatment "));
        internalMap.put(128961249, new Commodity("Tritium", "Chemicals", "Tritium "));
        internalMap.put(128983059, new Commodity("OnionHeadC", "Legal Drugs", "Onionhead Gamma Strain"));
        internalMap.put(129015433, new Commodity("AncientRelicTG", "Salvage", "Unclassified Relic"));
        internalMap.put(129019258, new Commodity("ThargoidTissueSampleType5", "Salvage", "Thargoid Orthrus Tissue Sample"));
        internalMap.put(129019259, new Commodity("ThargoidGeneratorTissueSample", "Salvage", "Caustic Tissue Sample"));
        internalMap.put(129022087, new Commodity("UnocuppiedEscapePod", "Salvage", "Unoccupied Escape Pod"));
        internalMap.put(129022395, new Commodity("ThargoidTissueSampleType6", "Salvage", "Thargoid Glaive Tissue Sample"));
        internalMap.put(129022396, new Commodity("ThargoidTissueSampleType7", "Salvage", "Thargoid Scythe Tissue Sample"));
        internalMap.put(129022398, new Commodity("ThargoidTissueSampleType9a", "Salvage", "Titan Deep Tissue Sample"));
        internalMap.put(129022399, new Commodity("ThargoidTissueSampleType9b", "Salvage", "Titan Tissue Sample "));
        internalMap.put(129022400, new Commodity("ThargoidTissueSampleType9c", "Salvage", "Titan Partial Tissue Sample "));
        internalMap.put(129022402, new Commodity("ThargoidTissueSampleType10a", "Salvage", "Titan Maw Deep Tissue Sample"));
        internalMap.put(129022403, new Commodity("ThargoidTissueSampleType10b", "Salvage", "Titan Maw Tissue Sample "));
        internalMap.put(129022404, new Commodity("ThargoidTissueSampleType10c", "Salvage", "Titan Maw Partial Tissue Sample "));
        internalMap.put(129022405, new Commodity("UnknownSack", "Salvage", "Protective Membrane Scrap"));
        internalMap.put(129022406, new Commodity("ThargoidPod", "Salvage", "Xenobiological Prison Pod"));
        internalMap.put(129022407, new Commodity("CoralSap", "Salvage", "Coral Sap"));
        return UnalterableMap.unalterableMap(internalMap);
    }

    @Getter
    private static class Commodity {
        private String                         symbol;
        private String                         category;
        private String                         name;

        private Commodity(String symbol, String category, String name)
        {
            this.symbol = symbol;
            this.category = category;
            this.name = name;
        }
    }
    
    public static Commodity getFromId(int id)
    {
        return _instance().map.get(id);
    }
    
    public static String getNameFromSymbol(String symbol)
    {
        return _instance().toLowerCaseSymbolMap.get(symbol.toLowerCase());
    }
}
