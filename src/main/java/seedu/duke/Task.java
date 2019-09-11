package seedu.duke;

import java.io.Serializable;
/**
 * Represents a Task in the Task list. A <code>Task</code> object corresponds to
 * a task the user has to do and whether it is done represented by a string and a boolean value.
 * e.g., <code>"gg wellplayed" false</code>
 */
public class Task implements Serializable {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "+" : "-"); //"\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
    //...
}