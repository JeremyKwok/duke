public class FindCommand extends Command {
    private String[] c;
    public FindCommand(String[] c) {
        this.c = c;
    }
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        TaskList filteredList = list.find(c[1]);
        ui.printList(filteredList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
