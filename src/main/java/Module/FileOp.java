package Module;


import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOp {
    private static String path = ".\\src\\main\\java\\Data\\duke.txt";
    private static Scanner fileInput;
    private static ArrayList<item> list = new ArrayList<>();
    private static File f = new File(path);



    public static ArrayList<item> loadFile() {

        try {
            fileInput = new Scanner(f);
            while (fileInput.hasNextLine()) { //do something
                String type, info;
                Boolean stat;
                String s1 = fileInput.nextLine();
                String[] data = s1.split(",");
                type = data[0];
                stat = (data[1].equals("1"));

                switch (type) {
                    case "D":
                        item deadline = new Deadline(data[0], stat, data[1]);
                        list.add(deadline);
                        break;

                    case "E":
                        item event = new Event(data[0], stat, data[1]);
                        list.add(event);
                        break;

                    case "T":
                        item todo = new ToDo(data[2], stat);
                        list.add(todo);
                        break;
                }
            }
            fileInput.close();
            return list;
        }
        catch (FileNotFoundException e) {
            return null;
        }
    }

    public void saveFile (String type, item e, String date) {
        try {
            if (type.equals("T")) {
                FileWriter fileWriter = new FileWriter(f, true);
                fileWriter.write(type + "," + e.checkStatus() + "," + e.getInfo() + "\n");
                fileWriter.close();
            }
            else  {
                FileWriter fileWriter = new FileWriter(f, true);

                fileWriter.write(type + "," + e.checkStatus() + "," + e.getInfo() + "," +date+ "\n");
                fileWriter.close();
            }
        }
        catch (IOException io) {
            System.out.println("File not found:" + io.getMessage());
        }
    }
}
