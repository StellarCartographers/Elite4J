package elite.dangerous.events.startup;

import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.toreadable.ReputationName;

/**
 * The Class Reputation.
 */
public class Reputation extends Event implements Trigger {

	/**
     * The independent.
     */
	public Double empire, federation, alliance, independent;

	public String getEmpireReputationReadable() {
		return ReputationName.getReadableName(this.empire);
	}

	public String getFederationReputationReadable() {
		return ReputationName.getReadableName(this.federation);
	}

	public String getAllianceReputationReadable() {
		return ReputationName.getReadableName(this.alliance);
	}

	public String getIndependentReputationReadable() {
		return ReputationName.getReadableName(independent);
	}
}
