public class todoApp {

  String task;


  public static void main(String[] args) {
    printUsage();
//    addTask()

  }



//  public void addTask(String task) {
//    this.task = task;
//  }

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

