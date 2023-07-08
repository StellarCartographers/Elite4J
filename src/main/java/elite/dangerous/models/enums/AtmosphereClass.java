/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models.enums;

/**
 * The Enum AtmosphereClass.
 */
public enum AtmosphereClass {
	No_Atmosphere("No atmosphere"), Suitable_for_water$based_Life("Suitable for water-based life"),
	Ammonia_and_Oxygen("Ammonia and oxygen"), Ammonia("Ammonia"), Water("Water"), Carbon_dioxide("Carbon dioxide"),
	Sulphur_dioxide("Sulphur dioxide"), Nitrogen("Nitrogen"), Water$rich("Water-rich"), Methane$rich("Methane-rich"),
	Ammonia$rich("Ammonia-rich"), Carbon_dioxide$rich("Carbon dioxide-rich"), Methane("Methane"), Helium("Helium"),
	Silicate_vapour("Silicate vapour"), Metallic_vapour("Metallic vapour"), Neaon$rich("Neon-rich"),
	Argon$rich("Argon-rich"), Neon("Neon"), Argon("Argon"), Oxygen("Oxygen");

	private final String identifier;

	AtmosphereClass(String identifier) {
		this.identifier = identifier;
	}

	/**
     * Gets the atmosphere class identifier.
     *
     * @return the atmosphere class identifier
     */
	public String getAtmosphereClassIdentifier() {
		return this.identifier;
	}

	/**
     * Gets the atmosphere class name.
     *
     * @param identifier the identifier
     * @return the atmosphere class name
     */
	public String getAtmosphereClassName(String identifier) {
		String name = "null";
		for (AtmosphereClass atmosphereClass : values()) {
			if (atmosphereClass.getAtmosphereClassIdentifier().equals(identifier)) {
				name = atmosphereClass.name().replace("_", " ").replaceAll("\\$", "-");
			}
		}
		return name;
	}
}
