package elite.dangerous.events.stationservices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import elite.dangerous.EliteAPI;
import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.utils.GameFiles;

/**
 * The Class Outfitting.
 */
public class Outfitting extends Event implements Trigger {
    /**
     * The market ID.
     */
    public Long marketID;

    /**
     * The star system.
     */
    public String stationName, starSystem;

    public static Outfitting loadFromFile() {
        Outfitting outfittingEvent = null;
        var       outfittingFile  = GameFiles.getExistingInstance().getOutfittingFile();
        if ((outfittingFile != null) && outfittingFile.exists()) {
            try {
                outfittingEvent = EliteAPI.getEvent(String.join("", Files.readAllLines(outfittingFile.toPath(), StandardCharsets.UTF_8)), Outfitting.class);
            } catch (IOException ignored) {}
        }
        return outfittingEvent;
    }
}
