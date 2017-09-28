import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class todoApp {

  // if args.equals("-h") sout blbla.

  public static void main(String[] args) {
    if (args.length == 0) {
      printUsage();
    } else if (args.length != 0 && args[0].equals("-l")) {
      taskReader();
    } else if (args.length != 0 && args[0].equals("-a")) {
      taskAdder(args);
    }
  }

  public static void taskAdder(String[] args) {
    try {
      Path listPath = Paths.get("../tasks.txt");
      List<String> lines = Files.readAllLines(listPath);
      lines.add(args[1]);
      Files.write(listPath, lines);
    } catch (Exception e) {
      System.out.println("Unable to add: no task provided!");
    }
  }


  public static void taskReader() {
    try {
      Path listPath = Paths.get("../tasks.txt");
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
