import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class todoApp {

  String task;
  boolean completed;


  public static void main(String[] args) {
    printUsage();
    taskReader();
//    taskAdder(new String[]{"jóskafiú"});


  }


  public static void taskAdder(String[] args) {
    try {
      Path listPath = Paths.get("tasks.txt");
      List<String> lines = Files.readAllLines(listPath);
      lines.add(args[1]);
      Files.write(listPath, lines, Charset.defaultCharset());
    } catch (Exception e) {
      System.out.println("Uh-oh, could not write the file!");
    }
  }


  public static void taskReader() {
    try {
      Path listPath = Paths.get("tasks.txt");
      List<String> lines = Files.readAllLines(listPath);
      int taskNumber = 1;
      if (lines.get(0) != null) {
        for (int i = 0; i < lines.size(); i++) {
          System.out.println(taskNumber + " - " + lines.get(i));
          taskNumber++;
        }
      }
    } catch (Exception e) {
      System.out.println("No todos for today! :)");
    }
  }


  public static void printUsage() {
    System.out.println("Command Line Todo application\n"
        + "=============================\n"
        + "\n"
        + "Command line arguments:\n"
        + " -l   Lists all the tasks\n"
        + " -a   Adds a new task\n"
        + " -r   Removes an task\n"
        + " -c   Completes an task");
  }
}
