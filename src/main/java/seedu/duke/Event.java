package seedu.duke;

public class Event extends Task {

    protected DukeDate at;

    public Event(String description, DukeDate at) throws DukeException {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.outputDate() + ")";
    }
}