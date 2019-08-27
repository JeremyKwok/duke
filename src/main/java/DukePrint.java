import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DukePrint {
    public static void printLinebreak() {
        String linebreak = "    ____________________________________________________________";
        System.out.println(linebreak);
    }

    public static void printList(ArrayList<Task> list) {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("     " + (i+1) + "." + list.get(i).toString());
        }
    }

    public static void printLast(ArrayList<Task> list) {
        printMessage("Got it. I've added this task:");
        int n = list.size();
        printMessage(" " + list.get(n-1).toString());
        printMessage("Now you have " + Integer.toString(n) + " tasks in the list.");
    }

    public static void printMessage(String str) {
        System.out.println("     " + str);
    }

    public static String getInput(Scanner in) {
        System.out.println();
        return in.nextLine();
    }

    public static void printGreeting() {
        printLinebreak();
        printMessage("Hello! I'm Duke");
        printMessage("What can I do for you?");
        printLinebreak();
    }
    public static void saveData(ArrayList<Task> list){
        new File("../../../data").mkdirs();
        try {
            FileOutputStream fos = new FileOutputStream("../../../data/duke.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }

    public static ArrayList<Task> loadData(){
        new File("../../../data").mkdirs();
        try {
            FileInputStream fis = new FileInputStream("../../../data/duke.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Task> list = (ArrayList<Task>) ois.readObject();
            ois.close();
            return list;
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        return null;
    }

}
