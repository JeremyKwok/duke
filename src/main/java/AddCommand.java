import java.util.ArrayList;

public class AddCommand extends Command {
    private String[] c;

    public AddCommand (String[] c) {
        this.c = c;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        switch(c[0]) {
            case "todo":
                list.addTask(new ToDo(c[1]));
                break;
            case "event":
                list.addTask(new Event(c[1], new DukeDate(c[2], c[3], c[4], c[5])));
                break;
            case "deadline":
                list.addTask(new Deadline(c[1], new DukeDate(c[2], c[3], c[4], c[5])));
                break;
        }
        ui.printLast(list);
        storage.saveData(list);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
