// package elite.dangerous;
//
// import java.io.*;
// import java.nio.charset.StandardCharsets;
//
// import elite.dangerous.journal.Event;
// import elite.dangerous.journal.events.backpack.BackpackChange;
//
// public class Gen
// {
// static String repl = "elite.dangerous.journal.events.";
//
// public static void main(String[] args) throws IOException
// {
// String removedJson = "{ \"timestamp\":\"2023-11-14T05:55:24Z\", \"event\":\"BackpackChange\", \"Removed\":[ {
// \"Name\":\"largecapacitypowerregulator\", \"Name_Localised\":\"Power Regulator\", \"OwnerID\":0,
// \"MissionID\":945537343, \"Count\":1, \"Type\":\"Item\" } ] }";
// String addedJson = "{ \"timestamp\":\"2023-11-14T06:42:07Z\", \"event\":\"BackpackChange\", \"Added\":[ {
// \"Name\":\"microhydraulics\", \"Name_Localised\":\"Micro Hydraulics\", \"OwnerID\":0, \"Count\":1,
// \"Type\":\"Component\" } ] }";
// var event = Elite4J.Journal.parse(removedJson).get();
//
// BackpackChange change = (BackpackChange) event;
//
// System.out.println(change.removed() != null);
// System.out.println(change.added() != null);
// System.out.println(change.removed().get(0).name());
// }
//
// private static boolean createTestClass(Class<?> clazz) throws IOException
// {
// System.out.println("journal\\" + clazz.getName().replace(repl, "").replaceAll("\\.", "\\\\") + ".java");
// var file = new File("journal\\" + clazz.getName().replace(repl, "").replaceAll("\\.", "\\\\") + ".java");
// boolean completed;
// file.getParentFile().mkdirs();
// file.createNewFile();
// try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8))
// {
// writer.write(classTemplate.formatted(
// clazz.getName().replace(repl, "").split("\\.")[0],
// clazz.getName(),
// clazz.getSimpleName(),
// clazz.getSimpleName()
// )
// );
// } finally {
// completed = file.exists();
// }
// return completed;
// }
//
// private static String classTemplate = """
// package elite.dangerous.journal.%s;
//
// import static org.junit.jupiter.api.Assertions.*;
//
// import org.junit.jupiter.api.*;
//
// import %s;
//
// class %sTest
// {
//
// private static %s event;
//
// @BeforeAll
// static void setupTest() throws Exception
// {
// }
//
// @Disabled @Test
// void test()
// {
// fail("Not yet implemented");
// }
// }
// """;
// }
