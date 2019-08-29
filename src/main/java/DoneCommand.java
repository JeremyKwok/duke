import java.util.ArrayList;

public class DoneCommand extends Command {
    private String[] c;

    public DoneCommand (String[] c) {
        this.c = c;
    }

    @Override
    public void execute(ArrayList<Task> list, Ui ui, Storage storage) throws DukeException {
        try {
            int num = Integer.parseInt(c[1]);
            ui.printMessage("Nice! I've marked this task as done:");
            num -= 1;
            list.get(num).markAsDone();
            Ui.printMessage("  " + list.get(num).toString());
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
