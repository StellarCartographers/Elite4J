package elite.dangerous.events.stationservices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import elite.dangerous.EliteAPI;
import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.market.MarketItem;
import elite.dangerous.utils.GameFiles;

/**
 * The Class Market.
 */
public class Market extends Event implements Trigger {
    /**
     * The station name.
     */
    public String stationName;

    /**
     * The star system.
     */
    public String starSystem;

    /**
     * The station type.
     */
    public String stationType;

    /**
     * The carrier docking access.
     */
    public String carrierDockingAccess;

    /**
     * The market ID.
     */
    public Integer marketID;

    /**
     * The items.
     */
    public List<MarketItem> items;

    public static Market loadFromFile() {
        Market marketEvent = null;
        var   marketFile  = GameFiles.getExistingInstance().getMarketFile();
        if ((marketFile != null) && marketFile.exists()) {
            try {
                marketEvent = EliteAPI.getEvent(String.join("", Files.readAllLines(marketFile.toPath(), StandardCharsets.UTF_8)), Market.class);
            } catch (IOException ignored) {}
        }
        return marketEvent;
    }
}
