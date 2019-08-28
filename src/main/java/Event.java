public class Event extends Task {

    protected DukeDate at;

    public Event(String description, String at) throws DukeException {
        super(description);
        this.at = DukeDate.formatDate(at);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.outputDate() + ")";
    }
}