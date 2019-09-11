package seedu.duke;
/**
 * Represents a Command to mark Tasks as done in the Task list. A <code>DoneCommand</code> object corresponds to
 * a command represented by a string.
 * e.g., <code>"deadline submit assignment /by  11/9/2019 2359"</code>
 */
public class DoneCommand extends Command {
    private String[] cmdString;

    public DoneCommand(String[] c) {
        this.cmdString = c;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        try {
            int num = Integer.parseInt(cmdString[1]);
            ui.printMessage("Nice! I've marked this task as done:");
            num -= 1;
            if (num < 0 || num >= list.getSize()) {
                throw new DukeException("The specified index is not avaliable.");
            }
            list.at(num).markAsDone();
            ui.printMessage("  " + list.at(num).toString());
            ui.showTaskListSize(list);
            storage.saveData(list);
        } catch (NumberFormatException e) {
            throw new DukeException("The number specified is not in the right format.", e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
