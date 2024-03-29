/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.enums;

public enum CrimeType
{
    Assault("Assault"),
    Murder("Murder"),
    Piracy("Piracy"),
    Interdiction("Interdiction"),
    Illegal_Cargo("IllegalCargo"),
    Disobey_Police("DisobeyPolice"),
    Fire_In_No_FireZone("FireInNoFireZone"),
    Fire_In_Station("FireInStation"),
    Dumping_Dangerous("DumpingDangerous"),
    Dumping_Near_Station("DumpingNearStation"),
    Docking_Minor_Blocking_Airlock("DockingMinor_BlockingAirlock"),
    Docking_Major_Blocking_Airlock("DockingMajor_BlockingAirlock"),
    Docking_Minor_Blocking_LandingPa("DockingMinor_BlockingLandingPad"),
    Docking_Major_Blocking_LandingPad("DockingMajor_BlockingLandingPad"),
    Docking_Minor_Trespass("DockingMinor_Trespass"),
    Docking_Major_Trespass("DockingMajor_Trespass"),
    Collided_At_Speed_In_No_FireZone("CollidedAtSpeedInNoFireZone"),
    Collided_At_Speed_In_No_FireZone_HullDamage("CollidedAtSpeedInNoFireZone_HullDamage");

    private final String identifier;

    CrimeType(String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * Gets the crime type identifier.
     *
     * @return the crime type identifier
     */
    public String getCrimeTypeIdentifier()
    {
        return this.identifier;
    }

    /**
     * Gets the crime type name.
     *
     * @param  identifier
     *                        the identifier
     * 
     * @return            the crime type name
     */
    public String getCrimeTypeName(String identifier)
    {
        String name = "null";
        for (CrimeType crimeType : values())
        {
            if (crimeType.getCrimeTypeIdentifier().equals(identifier))
            {
                name = crimeType.name().replaceAll("_", " ").replaceAll("\\$", "-");
            }
        }
        return name;
    }
}
