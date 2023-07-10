package elite.dangerous.events.startup;

import java.util.List;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.material.Encoded;
import elite.dangerous.models.material.Manufactured;
import elite.dangerous.models.material.Material;

/**
 * The Class Materials.
 */
public class Materials extends Event implements Trigger {

	/**
     * The raw.
     */
	public List<Material> raw;
	
	/**
     * The manufactured.
     */
	public List<Manufactured> manufactured;
	
	/**
     * The encoded.
     */
	public List<Encoded> encoded;

}
