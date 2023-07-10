package elite.dangerous.utils;

import java.io.File;
import java.nio.file.Paths;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public final class Constant
{
    public static final String PARENT = "elite.dangerous.events";

    public static final File GAME_FILE_DIR = Paths.get(System.getProperty("user.home") + "/Saved Games/Frontier Developments/Elite Dangerous/").toFile();
    
    public static final Reflections R = new Reflections(
        new ConfigurationBuilder()
          .forPackages(PARENT)
          .filterInputsBy(new FilterBuilder().includePackage(PARENT).excludePackage("elite.dangerous.base"))
          .setScanners(Scanners.SubTypes));
}
