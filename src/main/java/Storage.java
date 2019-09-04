import java.io.*;
import java.util.ArrayList;

public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void saveData(TaskList list) throws DukeException {
        new File(filePath).mkdirs();
        try {
            FileOutputStream fos = new FileOutputStream(filePath + "/duke.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new DukeException("The file could not be generated to save data", e);

        } catch (IOException e) {
            throw new DukeException("There was an IOException", e);
        }

    }

    public TaskList loadData() throws DukeException {
        new File(filePath).mkdirs();
        try {
            FileInputStream fis = new FileInputStream(filePath + "/duke.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            TaskList list = (TaskList) ois.readObject();
            ois.close();
            return list;
        } catch (FileNotFoundException e) {
            throw new DukeException("The file could not be generated to save data", e);
        } catch (IOException e) {
            throw new DukeException("There was an IOException", e);
        } catch (ClassNotFoundException e) {
            throw new DukeException("The supporting Duke Classes could not be found", e);
        }
    }
}
