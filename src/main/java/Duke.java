import java.util.Scanner;

import java.util.ArrayList;
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;*/



public class Duke {//extends Application {
    //private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    //private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    private String prefix = "     ";

    /*private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    public Duke() {
        this.list = new ArrayList<Task>();
    }


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
                    printMessage("  " + list.get(num).toString());
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
        return;
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
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("     " + (i+1) + "." + list.get(i).toString());
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
