/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.enums;

public enum VolcanismClass
{
    None("None"),
    Water_Magma("Water Magma"),
    Sulphur_Dioxide_Magma("Sulphur Dioxide Magma"),
    Ammonia_Magma("Ammonia Magma"),
    Methane_Magma("Methane Magma"),
    Nitrogen_Magma("Nitrogen Magma"),
    Silicate_Magma("Silicate Magma"),
    Metallic_Magma("Metallic Magma"),
    Water_Geysers("Water Geysers"),
    Carbon_dioxide_Geysers("Carbon Dioxide Geysers"),
    Ammonia_Geysers("Ammonia Geysers"),
    Methane_Geysers("Methane Geysers"),
    Nitrogen_Geysers("Nitrogen Geysers"),
    Helium_Geysers("Helium Geysers"),
    Silicate_Vapour_Geysers("Silicate Vapour Geysers");

    private final String identifier;

    VolcanismClass(String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * Gets the volcanism class identifier.
     *
     * @return the volcanism class identifier
     */
    public String getVolcanismClassIdentifier()
    {
        return this.identifier;
    }

    /**
     * Gets the volcanism class name.
     *
     * @param  identifier
     *                        the identifier
     * 
     * @return            the volcanism class name
     */
    public String getVolcanismClassName(String identifier)
    {
        String name = "null";
        for (VolcanismClass volcanismClass : values())
        {
            if (volcanismClass.getVolcanismClassIdentifier().equals(identifier))
            {
                name = volcanismClass.name().replaceAll("_", " ").replaceAll("\\$", "-");
            }
        }
        return name;
    }
}
