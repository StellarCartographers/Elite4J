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
 * Lists the contents of the backpack, in a separate backpack.json file
 */
public class Backpack extends Event implements Trigger {

    public List<BackpackItem> items;

    public List<BackpackItem> components;

    public List<BackpackItem> consumables;

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
