import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    Scanner in;

    public Ui () {
        in = new Scanner(System.in);
    }

    public void showTaskListSize(TaskList list) {
        printMessage("Now you have " + Integer.toString(list.getSize()) + " tasks in the list.");
    }

    public void showLoadingError() {
        System.out.println("There was an error loading the old tasks. Creating a new Tasklist.");
    }

    public static void printLinebreak() {
        String linebreak = "    ____________________________________________________________";
        System.out.println(linebreak);
    }

    public void printList(TaskList list) {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("     " + (i+1) + "." + list.at(i).toString());
        }
    }

    public static void printLast(TaskList list) {
        printMessage("Got it. I've added this task:");
        int n = list.getSize();
        printMessage(" " + list.at(n-1).toString());
        printMessage("Now you have " + Integer.toString(n) + " tasks in the list.");
    }

    public static void printMessage(String str) {
        System.out.println("     " + str);
    }

    public String readCommand() {
        System.out.println();
        return in.nextLine();
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLinebreak();
        printMessage("Hello! I'm Duke");
        printMessage("What can I do for you?");
        printLinebreak();
    }
    public void showLine() {
        printLinebreak();
    }
}
