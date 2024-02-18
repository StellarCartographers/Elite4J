package elite.dangerous;

import java.io.*;
import java.nio.charset.StandardCharsets;

import elite.dangerous.journal.Event;

public class Gen
{
    static String repl = "elite.dangerous.journal.events.";

    public static void main(String[] args) throws IOException
    {
        Elite4J.Journal.getJournalEvents().values().forEach(c -> {
            try
            {
                createTestClass(c);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
    }

    private static boolean createTestClass(Class<?> clazz) throws IOException
    {
        System.out.println("journal\\" + clazz.getName().replace(repl, "").replaceAll("\\.", "\\\\") + ".java");
        var file = new File("journal\\" + clazz.getName().replace(repl, "").replaceAll("\\.", "\\\\") + ".java");
        boolean completed;
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8))
        {
            writer.write(classTemplate.formatted(
                    clazz.getName().replace(repl, "").split("\\.")[0],
                    clazz.getName(),
                    clazz.getSimpleName(),
                    clazz.getSimpleName()
                )
            );
        } finally {
            completed = file.exists();
        }
        return completed;
    }

    private static String classTemplate = """
                                          package elite.dangerous.journal.%s;

                                          import static org.junit.jupiter.api.Assertions.*;

                                          import org.junit.jupiter.api.*;

                                          import %s;

                                          class %sTest
                                          {

                                              private static %s event;

                                              @BeforeAll
                                              static void setupTest() throws Exception
                                              {
                                              }

                                              @Disabled @Test
                                              void test()
                                              {
                                                  fail("Not yet implemented");
                                              }
                                          }
                                                                                    """;
}
