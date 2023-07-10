package elite.dangerous.events.stationservices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import elite.dangerous.EliteAPI;
import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.utils.GameFiles;

/**
 * The Class Shipyard.
 */
public class Shipyard extends Event implements Trigger {
    /**
     * The market ID.
     */
    public Long marketID;

    /**
     * The star system.
     */
    public String stationName, starSystem;

    /**
     * The horizons.
     */
    public Boolean horizons;

    /**
     * The allow cobra mk IV.
     */
    public Boolean allowCobraMkIV;

    /**
     * The price list.
     */
    public List<PriceItem> priceList;

    public static Shipyard loadFromFile() {
        Shipyard shipyardEvent = null;
        var     shipyardFile  = GameFiles.getExistingInstance().getShipyardFile();
        if ((shipyardFile != null) && shipyardFile.exists()) {
            try {
                shipyardEvent = EliteAPI.getEvent(String.join("", Files.readAllLines(shipyardFile.toPath(), StandardCharsets.UTF_8)), Shipyard.class);
            } catch (IOException ignored) {}
        }
        return shipyardEvent;
    }

    /**
     * The Class PriceItem.
     */
    public static class PriceItem {
        /**
         * The id.
         */
        public Long id;

        /**
         * The ship type.
         */
        public String shipType;

        /**
         * The ship type localised.
         */
        public String shipTypeLocalised;

        /**
         * The ship price.
         */
        public Long shipPrice;
    }
}
