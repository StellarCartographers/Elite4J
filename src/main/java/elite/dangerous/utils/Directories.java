package elite.dangerous.utils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;

public enum Directories {
    USER(System.getProperty("user.home")),
    DESKTOP(USER, "Desktop"),
    DOCUMENTS(USER, "Documents"),
    DOWNLOADS(USER, "Downloads"),
    MUSIC(USER, "Music"),
    PICTURES(USER, "Pictures"),
    VIDEOS(USER, "Videos");
    
    private Path dirPath;

    Directories(Directories parent, String path) {
        this.dirPath = Path.of(parent.dirPath.toString(), path);
    }

    Directories(String path) {
        this.dirPath = Path.of(path);
    }

    public SafeFile getFile(String filename, String... subPaths)
    {    
        var first = subPaths[0];
        var linked = new LinkedList<>(Arrays.asList(subPaths));
        linked.remove(0);
        return new SafeFile(dirPath.resolve(Path.of(first, linked.toArray(new String[0]))).toString());
    }
}
