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