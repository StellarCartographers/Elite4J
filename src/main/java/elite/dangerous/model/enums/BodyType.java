/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.model.enums;

public enum BodyType
{
    Barycentre,
    Star,
    Ring,
    Planet,
    PlanetaryRing,
    StellarRing,
    Station,
    AsteroidCluster;

    /**
     * Gets the body type.
     *
     * @param  identifier
     *                        the identifier
     * 
     * @return            the body type name
     */
    public static BodyType fromString(String identifier)
    {
        return identifier.equals("Null") ? BodyType.Barycentre : BodyType.valueOf(identifier);
    }
}
