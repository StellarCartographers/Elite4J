/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.onfoot;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class ScanOrganic.
 */
@SuperBuilder
@Jacksonized
public class ScanOrganic extends Event 
{

    /**
     * The scan type.
     */
    public ScanType scanType;
    /**
     * The genus.
     */
    public String   genus;
    /**
     * The species.
     */
    public String   species;
    /**
     * The system address.
     */
    public Long     systemAddress;
    /**
     * The body.
     */
    public Long     body;

    /**
     * The Enum ScanType.
     */
    public enum ScanType
    {
        Log, Sample, Analyse
    }
}
