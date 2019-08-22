import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printGreeting();
        String str = getInput(in);
        while (!str.equals("bye")) {
            printLinebreak();
            String upToFiveCharacters = str.substring(0, Math.min(str.length(), 5));
            if (str.equals("list")) {
                printList(list);
            } else if (upToFiveCharacters.equals("done ")) {
                String remaining = str.substring(5, str.length());
                try {
                    int num = Integer.parseInt(remaining);
                    printMessage("Nice! I've marked this task as done:");
                    num -= 1;
                    list.get(num).markAsDone();
                    printMessage("  [" + "\u2713" + "] ");
                } catch (NumberFormatException e) {
                    list.add(new Task(str));
                    printMessage("added: "+ str);
                }
            } else {
                list.add(new Task(str));
                printMessage("added: "+ str);
            }

            printLinebreak();
            str = getInput(in);
        }
        printLinebreak();
        printMessage("Bye. Hope to see you again soon!");
        printLinebreak();
    }

    private static void printGreeting() {
        printLinebreak();
        printMessage("Hello! I'm Duke");
        printMessage("What can I do for you?");
        printLinebreak();
    }

    private static String getInput(Scanner in) {
        System.out.println();
        return in.nextLine();
    }

    private static void printList(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ".[" + list.get(i).getStatusIcon() + "] " + list.get(i).description);
        }
    }

    private static void printLinebreak() {
        String linebreak = "    ____________________________________________________________";
        System.out.println(linebreak);
    }

    private static void printMessage(String str) {
        System.out.println("     " + str);
    }


}
