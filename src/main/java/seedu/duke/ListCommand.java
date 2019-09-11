package seedu.duke;

public class ListCommand extends Command {



    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        ui.printList(list);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
