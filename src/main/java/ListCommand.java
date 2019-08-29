import java.util.ArrayList;

public class ListCommand extends Command {



    @Override
    public void execute(ArrayList<Task> list, Ui ui, Storage storage) throws DukeException {
        ui.printList(list);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
