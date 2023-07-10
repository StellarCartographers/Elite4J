package elite.dangerous.events.onfoot;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;

/**
 * The Class ScanOrganic.
 */
public class ScanOrganic extends Event implements Trigger {

	/**
     * The scan type.
     */
	public ScanType scanType;
	
	/**
     * The genus.
     */
	public String genus;
	
	/**
     * The species.
     */
	public String species;
	
	/**
     * The system address.
     */
	public Long systemAddress;
	
	/**
     * The body.
     */
	public Long body;

	/**
     * The Enum ScanType.
     */
	public enum ScanType {
		Log, Sample, Analyse
	}
}
