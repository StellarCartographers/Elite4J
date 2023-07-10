package elite.dangerous.models;

import java.util.List;

/**
 * The Class Engineering.
 */
public class Engineering {

	/**
     * The experimental effect localised.
     */
	public String engineer, blueprintName, experimentalEffect, experimentalEffectLocalised;
	
	/**
     * The level.
     */
	public Integer engineerID, blueprintID, level;
	
	/**
     * The quality.
     */
	public Double quality;
	
	/**
     * The modifications.
     */
	public List<Modification> modifications;
}
