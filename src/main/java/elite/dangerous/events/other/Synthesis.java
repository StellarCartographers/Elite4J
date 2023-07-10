package elite.dangerous.events.other;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.material.Material;

/**
 * The Class Synthesis.
 */
public class Synthesis extends Event implements Trigger {

	/**
     * The name.
     */
	public String name;
	
	/**
     * The materials.
     */
	public List<Material> materials;

}
