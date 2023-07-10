package elite.dangerous.utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JournalFileHandler {
    
    private volatile static JournalFileHandler instance;

    private JournalFileHandler() {}

    public static JournalFileHandler get() {
        if (instance == null) {
            synchronized (JournalFileHandler.class) {
                if (instance == null) {
                    instance = new JournalFileHandler();
                }
            }
        }
        return instance;
    }
    
    public List<JsonObject> retrieveEventsFromLog(SafeFile file)
    {
        List<JsonObject> lines = new ArrayList<>();
        var rAccessFile = file.toRandomAccessFile();
        for (var line = read(rAccessFile); line != null; line = read(rAccessFile)) {
            JsonParser.parseString(new String(line.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();
        }
        return lines;
    }
    
    private String read(RandomAccessFile file)
    {
        try {
            return file.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}
