package elite.dangerous.events.backpack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import elite.dangerous.EliteAPI;
import elite.dangerous.Trigger;
import elite.dangerous.base.Event;
import elite.dangerous.models.backpack.BackpackItem;
import elite.dangerous.utils.GameFiles;

/**
 * The Class Backpack.
 */
public class Backpack extends Event implements Trigger {
    /**
     * The items.
     */
    public List<BackpackItem> items;

    /**
     * The components.
     */
    public List<BackpackItem> components;

    /**
     * The consumables.
     */
    public List<BackpackItem> consumables;

    /**
     * The data.
     */
    public List<BackpackItem> data;

    public static Backpack loadFromFile() {
        Backpack backpackEvent = null;
        var      backpackFile  = GameFiles.getExistingInstance().getBackpackFile();
        if ((backpackFile != null) && backpackFile.exists()) {
            try {
                backpackEvent = EliteAPI.getEvent(String.join("", Files.readAllLines(backpackFile.toPath(), StandardCharsets.UTF_8)), Backpack.class);
            } catch (IOException ignored) {}
        }
        return backpackEvent;
    }
}
