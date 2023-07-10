package elite.dangerous.models.enums;

/**
 * The Enum AtmosphereCompositionType.
 */
public enum AtmosphereCompositionType {
	Water("Water"), Oxygen("Oxygen"), Carbon_Dioxide("CarbonDioxide"), Sulphur_Dioxide("SulphurDioxide"),
	Ammonia("Ammonia"), Methane("Methane"), Nitrogen("Nitrogen"), Hydrogen("Hydrogen"), Helium("Helium"), Neon("Neon"),
	Argon("Argon"), Silicates("Silicates"), Iron("Iron");

	private final String identifier;

	AtmosphereCompositionType(String identifier) {
		this.identifier = identifier;
	}

	/**
     * Gets the atmosphere composition type identifier.
     *
     * @return the atmosphere composition type identifier
     */
	public String getAtmosphereCompositionTypeIdentifier() {
		return this.identifier;
	}

	/**
     * Gets the atmosphere composition type name.
     *
     * @param identifier the identifier
     * @return the atmosphere composition type name
     */
	public String getAtmosphereCompositionTypeName(String identifier) {
		String name = "null";
		for (AtmosphereCompositionType atmosphereCompositionType : values()) {
			if (atmosphereCompositionType.getAtmosphereCompositionTypeIdentifier().equals(identifier)) {
				name = atmosphereCompositionType.name().replaceAll("_", " ").replaceAll("\\$", "-");
			}
		}
		return name;
	}
}
