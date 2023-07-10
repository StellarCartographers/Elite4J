package elite.dangerous.events.startup;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import elite.dangerous.EliteAPI;
import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.CargoItem;
import elite.dangerous.utils.GameFiles;

/**
 * The Class Cargo.
 */
public class Cargo extends Event implements Trigger {
    /**
     * The vessel.
     */
    public String vessel;

    /**
     * The count.
     */
    public Integer count;

    /**
     * The inventory.
     */
    public List<CargoItem> inventory;

    public static Cargo loadFromFile() {
        Cargo cargoEvent = null;
        var   cargoFile  = GameFiles.getExistingInstance().getCargoFile();
        if ((cargoFile != null) && cargoFile.exists()) {
            try {
                cargoEvent = EliteAPI.getEvent(String.join("", Files.readAllLines(cargoFile.toPath(), StandardCharsets.UTF_8)), Cargo.class);
            } catch (IOException ignored) {}
        }
        return cargoEvent;
    }
}
