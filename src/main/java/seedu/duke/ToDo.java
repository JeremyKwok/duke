package seedu.duke;
/**
 * Represents a ToDo Task in the Task list. A <code>ToDo</code> object corresponds to
 * a task the user has to do and whether it is done represented by a string and a boolean value.
 * e.g., <code>"todo gg wellplayed" false</code>
 */
public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}