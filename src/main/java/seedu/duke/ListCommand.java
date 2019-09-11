package seedu.duke;
/**
 * Represents a Command to list Tasks in the Task list. A <code>ListCommand</code> object corresponds to
 * a command represented by a string.
 * e.g., <code>"list"</code>
 */
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
