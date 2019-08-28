import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static void printLinebreak() {
        String linebreak = "    ____________________________________________________________";
        System.out.println(linebreak);
    }

    public static void printList(ArrayList<Task> list) {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("     " + (i+1) + "." + list.get(i).toString());
        }
    }

    public static void printLast(ArrayList<Task> list) {
        printMessage("Got it. I've added this task:");
        int n = list.size();
        printMessage(" " + list.get(n-1).toString());
        printMessage("Now you have " + Integer.toString(n) + " tasks in the list.");
    }

    public static void printMessage(String str) {
        System.out.println("     " + str);
    }

    public static String getInput(Scanner in) {
        System.out.println();
        return in.nextLine();
    }

    public static void printGreeting() {
        printLinebreak();
        printMessage("Hello! I'm Duke");
        printMessage("What can I do for you?");
        printLinebreak();
    }
}
