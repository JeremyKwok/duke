package seedu.duke;
/**
 * Represents a Deadline in the Task list. A <code>Deadline</code> object corresponds to
 * a task the user has to do and whether it is done and the timing the deadline has to be met
 * represented by a string and a boolean value and a DukeDate Object.
 * e.g., <code>"deadline gg wellplayed" false "24th December 2019 11:59 am"</code>
 */
public class Deadline extends Task {

    protected DukeDate by;

    public Deadline(String description, DukeDate by) throws DukeException {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.outputDate() + ")";
    }
}