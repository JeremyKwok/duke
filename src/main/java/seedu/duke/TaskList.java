package seedu.duke;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public boolean addTask(Task t) throws DukeException {
        if (list.add(t)) {
            return true;
        } else {
            throw new DukeException("The task could not be added");
        }
    }

    public void doneTask(int index) throws DukeException {
        list.get(index).markAsDone();
    }

    public void deleteTask(int index) {
        list.remove(index);
    }

    public int getSize() {
        return list.size();
    }

    public Task at(int index) {
        return list.get(index);
    }

    public TaskList find(String keyword) throws DukeException {
        TaskList filteredList = new TaskList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).description.contains(keyword)) {
                filteredList.addTask(list.get(i));
            }
        }
        return filteredList;
    }

}
