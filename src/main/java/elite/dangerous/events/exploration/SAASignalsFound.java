/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.events.exploration;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import elite.dangerous.base.Event;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * The Class SAASignalsFound.
 */
@SuperBuilder
@Jacksonized
public class SAASignalsFound extends Event 
{

    /**
     * The body name.
     */
    @SerializedName("BodyName")
    public String       bodyName;
    /**
     * The system address.
     */
    @SerializedName("SystemAddress")
    public long         systemAddress;
    /**
     * The body ID.
     */
    @SerializedName("BodyID")
    public long         bodyID;
    /**
     * The signals.
     */
    @SerializedName("Signals")
    public List<Signal> signals;
    /**
     * The genuses.
     */
    @SerializedName("Genuses")
    public List<Genus>  genuses;

    public List<String> getGenuses()
    {
        return genuses.stream().map(Genus::getName).toList();
    }

    /**
     * The Class Signal.
     */
    public static class Signal
    {

        /**
         * The type.
         */
        @SerializedName("Type")
        public String type;
        /**
         * The type localised.
         */
        @SerializedName("Type_Localised")
        public String typeLocalised;
        /**
         * The count.
         */
        @SerializedName("Count")
        public long   count;
    }

    /**
     * The Class Genus.
     */
    public static class Genus
    {

        /**
         * The genus.
         */
        @SerializedName("Genus")
        public String genus;
        /**
         * The genus localised.
         */
        @SerializedName("Genus_Localised")
        public String genusLocalised;

        public String getName()
        {
            return genusLocalised;
        }
    }
}
