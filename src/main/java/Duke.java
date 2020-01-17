import java.util.Scanner;

public class Duke {
    private static String indentation = "    ";
    private static String hori_line = "______________________________________";
    private Task[] task_list;
    private int num_tasks;

    public static void main(String[] args) {

        // Init Duke
        Duke d = new Duke();

        // Greet user on start
        d.Greet();
        // Duke's behaviour loop
        d.Loop();
    }

    private static void PrintWithIndent(String toPrint) {
        System.out.println(indentation + toPrint);
    }

    Duke() {
        // Assume there will be <= 100 tasks at any given time
        task_list = new Task[100];
        num_tasks = 0;
    }

    private void Greet() {
        PrintWithIndent(hori_line);
        PrintWithIndent("Hello! I'm Duke");
        PrintWithIndent("What can I do for you?");
        PrintWithIndent(hori_line);
    }

    private void Exit() {
        PrintWithIndent(hori_line);
        PrintWithIndent("Bye. Hope to see you again soon!");
        PrintWithIndent(hori_line);
    }

    private void Loop() {
        Scanner in = new Scanner(System.in);
        String input = "";
        boolean is_exiting = false;

        do {
            input = in.next();
            //is_exiting = input.compareToIgnoreCase("bye") == 0;
            switch (input.toLowerCase()) {
                case "list":
                    ShowList();
                    break;
                case "bye":
                    is_exiting = true;
                    break;
                case "done":
                    int doneTaskNum = in.nextInt();
                    DoneATask(doneTaskNum - 1);
                    break;
                default:
                    AddToList(input + in.nextLine()); // nextLine for handling multi-word tasks
                    break;
            }
        } while (!is_exiting);

        Exit();
    }

    private void AddToList(String newTask) {
        task_list[num_tasks++] = new Task(newTask);
        PrintWithIndent(hori_line);
        PrintWithIndent("added: " + newTask);
        PrintWithIndent(hori_line);
    }

    private void ShowList() {
        PrintWithIndent(hori_line);
        if (num_tasks > 0) {
            for (int i = 1; i <= num_tasks; i++) {
                PrintWithIndent(i + "." + task_list[i - 1].toString());
            }
        } else {
            PrintWithIndent("Empty List. You are currently free! Upz lah!");
        }
        PrintWithIndent(hori_line);
    }

    private void DoneATask(int task_index) {
        if (task_index < num_tasks && task_index >= 0) {
            task_list[task_index].MarkAsDone();
            PrintWithIndent(hori_line);
            PrintWithIndent("Nice! I've marked this task as done:");
            PrintWithIndent(task_list[task_index].toString());
            PrintWithIndent(hori_line);
        } else {
            // Task does not exist
            PrintWithIndent(hori_line);
            PrintWithIndent("Sorry, mate! No such task.");
            PrintWithIndent(hori_line);
        }

    }
}
