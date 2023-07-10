package elite.dangerous.base;

/**
 * The Class CarrierPack.
 */
public abstract class CarrierPack extends Event {

	/**
     * The carrier ID.
     */
	public Long carrierID;
	
	/**
     * The operation.
     */
	public String operation;
	
	/**
     * The pack theme.
     */
	public String packTheme;
	
	/**
     * The pack tier.
     */
	public Integer packTier;
	
	/**
     * The cost.
     */
	public Integer cost;
}
