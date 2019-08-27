package Module;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOp {
    private static String path = ".\\src\\main\\java\\Data\\duke.txt";
    private static Scanner fileInput;
    private static ArrayList<item> list = new ArrayList<>();

    public static ArrayList<item> loadFile() {
        File f = new File(path);
        try {
            fileInput = new Scanner(f);
            int cnt = 1;
            while (fileInput.hasNextLine()) { //do something

                String type, info;
                Boolean stat;
                type = fileInput.next();
                stat = (fileInput.nextInt() == 1);
                info = fileInput.nextLine();
                String[] data = info.split("|");

                switch (type) {
                    case "D":
                        item deadline = new Deadline(data[0], stat, cnt++, data[1]);
                        list.add(deadline);
                        break;

                    case "E":
                        item event = new Event(data[0], stat, cnt++, data[1]);
                        list.add(event);
                        break;

                    case "T":
                        item todo = new ToDo(data[0], stat, cnt++);
                        list.add(todo);
                        break;
                }
                fileInput.close();
                return list;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("\"\\u2639 OOPS!!! The file does not exist");
        }
        return null;
    }
}
