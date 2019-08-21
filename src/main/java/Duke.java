import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

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
            printMessage(str);
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

    private static void printLinebreak() {
        String linebreak = "    ____________________________________________________________";
        System.out.println(linebreak);
    }

    private static void printMessage(String str) {
        System.out.println("     " + str);
    }


}
