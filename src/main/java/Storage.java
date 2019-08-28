import java.io.*;
import java.util.ArrayList;

public class Storage {

    public static void saveData(ArrayList<Task> list) throws DukeException {
        new File("../../../data").mkdirs();
        try {
            FileOutputStream fos = new FileOutputStream("../../../data/duke.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new DukeException("The file could not be generated to save data", e);

        } catch (IOException e) {
            throw new DukeException("There was an IOException", e);
        }

    }

    public static ArrayList<Task> loadData() throws DukeException {
        new File("../../../data").mkdirs();
        try {
            FileInputStream fis = new FileInputStream("../../../data/duke.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Task> list = (ArrayList<Task>) ois.readObject();
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
