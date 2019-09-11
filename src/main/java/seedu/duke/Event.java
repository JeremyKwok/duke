package seedu.duke;
/**
 * Represents an Event in the Task list. A <code>Event</code> object corresponds to
 * a task the user has to do and whether it is done and the timing the event occurs at
 * represented by a string and a boolean value and a DukeDate Object.
 * e.g., <code>"event gg wellplayed" false "24th December 2019 11:59 am - 11.59 pm"</code>
 */
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