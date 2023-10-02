package elite.dangerous.journal.events.exploration;

import java.util.List;

import elite.dangerous.journal.Event;

/**
 * The Class SAASignalsFound.
 */
public class SAASignalsFound extends Event
{

    /**
     * The body name.
     */

    public String bodyName;

    /**
     * The system address.
     */

    public long systemAddress;

    /**
     * The body ID.
     */

    public long bodyID;

    /**
     * The signals.
     */

    public List<Signal> signals;

    /**
     * The genuses.
     */

    public List<Genus> genuses;

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

        public String type;

        /**
         * The type localised.
         */

        public String typeLocalised;

        /**
         * The count.
         */

        public long count;
    }

    /**
     * The Class Genus.
     */
    public static class Genus
    {

        /**
         * The genus.
         */

        public String genus;

        /**
         * The genus localised.
         */

        public String genusLocalised;

        public String getName()
        {
            return genusLocalised;
        }
    }
}
