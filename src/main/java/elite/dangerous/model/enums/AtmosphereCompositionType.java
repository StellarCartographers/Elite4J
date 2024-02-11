/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.enums;

public enum AtmosphereCompositionType
{
    Water,
    Oxygen,
    CarbonDioxide,
    SulphurDioxide,
    Ammonia,
    Methane,
    Nitrogen,
    Hydrogen,
    Helium,
    Neon,
    Argon,
    Silicates,
    Iron;

    /**
     * Gets the atmosphere composition type name.
     *
     * @param  identifier
     *                        the identifier
     * 
     * @return            the atmosphere composition type name
     */
    public String getAtmosphereCompositionTypeName(String identifier)
    {
        String name = "null";
        for (AtmosphereCompositionType atmosphereCompositionType : values())
        {
            if (atmosphereCompositionType.toString().equals(identifier))
            {
                name = atmosphereCompositionType.toString();
            }
        }
        return name;
    }
}
