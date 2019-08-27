import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringIndexOutOfBoundsException;
import java.lang.NullPointerException;
import Module.*;

public class Duke {
    public static void main(String[] args) throws DukeException {

        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        ArrayList<item> list = new ArrayList<>();
        int cnt = 0;
        while(true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (input.equals("list")) {
                for (item i: list) {
                    if (i != null) {
                        System.out.println(i.getIndex() + "." + i.toString());
                    }
                    else break;
                }
            }

            else if (input.contains("done")) {
                try {
                    int index = Integer.parseInt(input.substring(input.length() - 1)) - 1;
                    list.get(index).changeStatus();
                    System.out.println("Nice! I've marked this task as done:\n " +
                            list.get(index).toString());
                }
                catch (NullPointerException e) {
                    System.out.println("\u2639 OOPS!!! The following task does not exist!");
                }

            }

            else if (input.contains("todo")) {
                try {
                    String info = input.substring(5);
                    item todo = new ToDo(info, false, ++cnt);
                    list.add(todo);
                    System.out.println("Got it. I've added this task:\n " +
                            list.get(cnt -1).toString()+"\n" +
                            "Now you have " + cnt + " tasks in the list.");
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
                    item deadline = new Deadline(info, false, ++cnt, endDate);
                    list.add(deadline);
                    System.out.println("Got it. I've added this task:\n " +
                            list.get(cnt -1).toString() + "\n" +
                            "Now you have " + cnt + " tasks in the list.");
                }
                catch (StringIndexOutOfBoundsException e) {
                    System.out.println("\u2639 OOPS!!! The task needs a deadline");
                }
            }

            else if (input.contains("event")) {
                int index = input.indexOf("/at");
                String info = input.substring(6, index);
                String endDate = input.substring(index + 4);
                item event = new Event(info, false, ++cnt, endDate);
                list.add(event);
                System.out.println("Got it. I've added this task:\n " +
                        list.get(cnt -1).toString()+ "\n" +
                        "Now you have " + cnt + " tasks in the list.");
            }

            else {
               System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

        }
    }
}
