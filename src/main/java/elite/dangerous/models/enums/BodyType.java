/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models.enums;

/**
 * The Enum BodyType.
 */
public enum BodyType {
	Null("Null"), Star("Star"), Planet("Planet"), Planetary_Ring("PlanetaryRing"), Stellar_Ring("StellarRing"),
	Station("Station"), Asteroid_Cluster("AsteroidCluster");

	private final String identifier;

	BodyType(String identifier) {
		this.identifier = identifier;
	}

	/**
     * Gets the body type identifier.
     *
     * @return the body type identifier
     */
	public String getBodyTypeIdentifier() {
		return this.identifier;
	}

	/**
     * Gets the body type name.
     *
     * @param identifier the identifier
     * @return the body type name
     */
	public String getBodyTypeName(String identifier) {
		String name = "null";
		for (BodyType bodyType : values()) {
			if (bodyType.getBodyTypeIdentifier().equals(identifier)) {
				name = bodyType.name().replaceAll("_", " ").replaceAll("\\$", "-");
			}
		}
		return name;
	}
}
