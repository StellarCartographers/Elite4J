package elite.dangerous.events.other;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.AsteroidMaterial;

/**
 * The Class ProspectedAsteroid.
 */
public class ProspectedAsteroid extends Event implements Trigger {

	/**
     * The Constant CONTENTS.
     */
	public static final String[] CONTENTS = { "High", "Medium", "Low" };

	/**
     * The materials.
     */
	public List<AsteroidMaterial> materials;
	
	/**
     * The content.
     */
	public String content;
	
	/**
     * The motherlode material.
     */
	public String motherlodeMaterial;
	
	/**
     * The remaining.
     */
	public Float remaining;

}
