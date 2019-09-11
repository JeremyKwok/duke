package seedu.duke;
/**
 * Represents a Command to exit the program. A <code>ExitCommand</code> object corresponds to
 * a command represented by a string.
 * e.g., <code>"bye"</code>
 */
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        ui.printMessage("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
