package seedu.duke;
/**
 * Represents a Command. A <code>AddCommand</code> object corresponds to
 * a command represented by a string. This is an abstract class.
 * e.g., <code>"deadline submit assignment /by  11/9/2019 2359"</code>
 */
public abstract class Command {
    public abstract void execute(TaskList list, Ui ui, Storage storage) throws DukeException;

    public abstract boolean isExit();
}
