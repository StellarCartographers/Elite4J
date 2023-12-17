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
