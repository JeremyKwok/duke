package seedu.duke;
/**
 * Represents a Command to find Tasks in the Task list. A <code>FindCommand</code> object corresponds to
 * a command represented by a string.
 * e.g., <code>"find submit"</code>
 */
public class FindCommand extends Command {
    private String[] cmdString;

    public FindCommand(String[] c) {
        this.cmdString = c;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        TaskList filteredList = list.find(cmdString[1]);
        ui.printList(filteredList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
