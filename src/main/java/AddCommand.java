import java.util.ArrayList;

public class AddCommand extends Command {
    private String[] cmdString;

    public AddCommand(String[] c) {
        this.cmdString = c;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        switch (cmdString[0]) {
        case "todo":
            list.addTask(new ToDo(cmdString[1]));
            break;
        case "event":
            list.addTask(new Event(cmdString[1], new DukeDate(cmdString[2], cmdString[3],
                    cmdString[4], cmdString[5])));
            break;
        case "deadline":
            list.addTask(new Deadline(cmdString[1], new DukeDate(cmdString[2], cmdString[3],
                    cmdString[4], cmdString[5])));
            break;
        default:
            throw new DukeException("Unable to add task of type " + cmdString[0] + ".");
        }
        ui.printLast(list);
        storage.saveData(list);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
