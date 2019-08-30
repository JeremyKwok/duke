import java.util.ArrayList;

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
