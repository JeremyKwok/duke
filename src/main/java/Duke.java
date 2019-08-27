import java.util.Scanner;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
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
*/
    private ArrayList<Task> list;

    public Duke() {
        this.list = new ArrayList<Task>();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Duke myDuke = new Duke();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        DukePrint.printGreeting();
        String str = DukePrint.getInput(in);
        while (!str.equals("bye")) {
            DukePrint.printLinebreak();
            try {
                myDuke.runCmd(str);
            }
            catch (DukeException e){
                System.out.println(e);
            }

            DukePrint.printLinebreak();
            str = DukePrint.getInput(in);
        }
        DukePrint.printLinebreak();
        DukePrint.printMessage("Bye. Hope to see you again soon!");
        DukePrint.printLinebreak();
        return;
    }



    private void runCmd(String op) throws DukeException {
        if (op.equals("list")) {
            DukePrint.printList(this.list);
            return;
        }
        String opType;
        if (op.equals("todo") || op.equals("event") || op.equals("deadline")) {
            throw new DukeException("☹ OOPS!!! The description of a " + op + " cannot be empty.");
        }
        else if (op.indexOf(" ") > -1){
            opType = op.split(" ", 2)[1];
            op = op.split(" ",2)[0];
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        int i;
        if (opType.equals("todo")) {

            Task t = new ToDo(op);
            this.list.add(t);
            DukePrint.printLast(this.list);
        } else if (opType.equals("deadline")) {
            i = op.indexOf(" /by ");
            String opTime = "NULL";
            if (i > -1) {
                opTime = op.substring(i+5);
                op = op.substring(0, i);
            }
            list.add(new Deadline(op, opTime));
            DukePrint.printLast(list);
        } else if (opType.equals("event")) {
            i = op.indexOf(" /at ");
            String opTime = "NULL";
            if (i > -1) {
                opTime = op.substring(i+5);
                op = op.substring(0, i);
            }
            list.add(new Event(op, opTime));
            DukePrint.printLast(list);
        } else if (opType.equals("done")) {
            try {
                int num = Integer.parseInt(op);
                DukePrint.printMessage("Nice! I've marked this task as done:");
                num -= 1;
                list.get(num).markAsDone();
                DukePrint.printMessage("  " + list.get(num).toString());
            } catch (NumberFormatException e) {
                list.add(new Task(op));
                DukePrint.printMessage("added: "+ op);
            }
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }


    }










}
