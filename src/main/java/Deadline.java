public class Deadline extends Task {

    protected DukeDate by;

    public Deadline(String description, String by) throws DukeException {
        super(description);
        this.by = DukeDate.formatDate(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.outputDate() + ")";
    }
}