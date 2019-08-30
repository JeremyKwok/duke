import java.util.ArrayList;

abstract public class Command {
    abstract public void execute (TaskList list, Ui ui, Storage storage) throws DukeException;
    abstract public boolean isExit();
}
