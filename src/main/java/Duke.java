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
    private TaskList list;
    private Storage storage;
    private Ui ui;

    public Duke(String filePath) {
        try {
            ui = new Ui();
            storage = new Storage(filePath);
            list = storage.loadData();
        } catch (DukeException e) {
            ui.showLoadingError();
            list = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command myCmd = Parser.parse(fullCommand);
                myCmd.execute(list, ui, storage);
                isExit = myCmd.isExit();
            } catch (DukeException e) {
                System.out.println(e);
            } finally {
                ui.showLine();
            }
        }
    }
    public static void main(String[] args) {
        new Duke("../../../data").run();
    }
}
