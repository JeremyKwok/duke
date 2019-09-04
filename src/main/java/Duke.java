import java.util.Scanner;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;



public class Duke {

    private String prefix = "     ";

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
