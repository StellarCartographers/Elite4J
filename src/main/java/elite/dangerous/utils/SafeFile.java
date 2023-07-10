package elite.dangerous.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class SafeFile {
    private File file;
    private Path path;
    
    public SafeFile(String absolutePath)
    {
        this.path = Paths.get(absolutePath);
        this.file = new File(absolutePath);
    }
    
    public RandomAccessFile toRandomAccessFile()
    {
        try {
            return new RandomAccessFile(this.file, "r");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File with path [%s] does not exist".formatted(this.path.toString()));
        }
    }
    
    @Override
    public String toString() {
        return this.file.exists() ? this.file.getName() : "File does not Exist";
    }
}
