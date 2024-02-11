/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.enums;

public enum StarClass
{
    Main_Sequence("O", "B", "A", "F", "G", "K", "M", "L", "T", "Y"),
    Proto_Star("TTS", "AeBe"),
    Wolf$Rayet("W", "WN", "WNC", "WC", "WO"),
    Carbon_Star("CS", "C", "CN", "CJ", "CH", "CHd", "MS", "S"),
    White_Dwarfs("D", "DA", "DAB", "DAO", "DAZ", "DAV", "DB", "DBZ", "DBV", "DO", "DOV", "DQ", "DC", "DCV", "DX"),
    Neutron("N"),
    Black_Hole("H"),
    Exotic("X"),
    Super_Massive_Black_Hole("SuperMassiveBlackHole"),
    A_Blue_White_Super_Giant("A_BlueWhiteSuperGiant"),
    F_White_Super_Giant("F_WhiteSuperGiant"),
    M_RedSuper_Giant("M_RedSuperGiant"),
    M_Red_Giant("M_RedGiant"),
    K_Orange_Giant("K_OrangeGiant"),
    Rogue_Planet("RoguePlanet"),
    Nebula("Nebula"),
    Stellar_Remnant_Nebula("StellarRemnantNebula");

    private final String[] identifiers;

    StarClass(String... identifiers)
    {
        this.identifiers = identifiers;
    }

    /**
     * Gets the star class identifiers.
     *
     * @return the star class identifiers
     */
    public String[] getStarClassIdentifiers()
    {
        return this.identifiers;
    }

    /**
     * Gets the star class name.
     *
     * @param  identifier
     *                        the identifier
     * 
     * @return            the star class name
     */
    public String getStarClassName(String identifier)
    {
        String name = "null";
        for (StarClass starClass : values())
        {
            for (String ident : starClass.getStarClassIdentifiers())
            {
                if (ident.equals(identifier))
                {
                    name = starClass.name().replaceAll("_", " ").replaceAll("\\$", "-");
                    break;
                }
            }
        }
        return name;
    }
}
