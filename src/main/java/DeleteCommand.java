import java.util.ArrayList;

public class DeleteCommand extends Command {
    private String[] c;

    public DeleteCommand(String[] c) {
        this.c = c;
    }


    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        try {
            int num = Integer.parseInt(c[1]);
            ui.printMessage("Noted. I've removed this task:");
            num -= 1;
            if (num < 0 || num >= list.getSize()) {
                throw new DukeException("The specified index is not avaliable.");
            }
            ui.printMessage("  " + list.at(num).toString());
            list.deleteTask(num);
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
