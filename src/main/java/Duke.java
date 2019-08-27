import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.lang.StringIndexOutOfBoundsException;
import java.lang.NullPointerException;
import Module.*;

public class Duke {
    public static void main(String[] args) throws DukeException {

        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");


        ArrayList<item> list = new ArrayList<>();
        try { //load previous file
            list.addAll(Objects.requireNonNull(FileOp.loadFile()));
        }
        catch (NullPointerException e) {
            System.out.println("No previous list");
        }
        while(true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (input.equals("list")) {
                int count = 1;
                for (item i: list) {
                    System.out.println(count++ +"."+ i.toString());
                }
            }

            else if (input.contains("done")) {
                try {
                    int index = Integer.parseInt(input.substring(5)) - 1;
                    list.get(index).changeStatus();
                    System.out.println("Nice! I've marked this task as done:\n " +
                            list.get(index).toString());
                    FileOp save = new FileOp();
                    save.updateFile(list);
                }
                catch (NullPointerException e) {
                    System.out.println("\u2639 OOPS!!! The following task does not exist!");
                }

            }

            else if (input.contains("todo")) {
                try {
                    String info = input.substring(5);
                    item todo = new ToDo(info, false);
                    list.add(todo);
                    System.out.println("Got it. I've added this task:\n " +
                            list.get(list.size() - 1).toString()+"\n" +
                            "Now you have " + (list.size()) + " tasks in the list.");
                    FileOp save = new FileOp();
                    save.saveFile("T", todo, "");
                }
                catch(StringIndexOutOfBoundsException e) {
                    System.out.println("\u2639 OOPS!!! The description of a todo cannot be empty.");
                }

            }

            else if (input.contains("deadline")) {
                try {
                    int index = input.indexOf("/by");
                    String info = input.substring(9, index);
                    String endDate = input.substring(index + 4);
                    Deadline deadline = new Deadline(info, false, endDate);
                    list.add(deadline);
                    System.out.println("Got it. I've added this task:\n " +
                            list.get(list.size() - 1).toString() + "\n" +
                            "Now you have " + (list.size()) + " tasks in the list.");
                    FileOp save = new FileOp();
                    save.saveFile("D", deadline, deadline.getDate());
                }
                catch (StringIndexOutOfBoundsException e) {
                    System.out.println("\u2639 OOPS!!! The task needs a deadline");
                }
            }

            else if (input.contains("event")) {
                int index = input.indexOf("/at");
                String info = input.substring(6, index);
                String endDate = input.substring(index + 4);
                Event event = new Event(info, false, endDate);
                list.add(event);
                System.out.println("Got it. I've added this task:\n " +
                        list.get(list.size() - 1).toString()+ "\n" +
                        "Now you have " + (list.size()) + " tasks in the list.");
                FileOp save = new FileOp();
                save.saveFile("E", event, event.getDate());
            }

            else {
               System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

        }
    }
}
