import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.lang.StringIndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Module.*;

public class Duke {

    public static String numOrdinal (int num) {
        String[] suffix = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (num % 100) {
            case 11:
            case 12:
            case 13:
                return num + "th";
            default:
                return num + suffix[num % 10];
        }
    }

    public static String dateConvert (String date) {
        System.out.println(date);
        String[] months = {"January", "February", "March",
                            "April", "May", "June", "July",
                            "August", "September","October",
                            "November", "December"};

        try {
            String[] words = date.split("[/| ]"); // split based on space and /
            System.out.println(words[3]);
            int hour = Integer.parseInt(words[3].substring(0,2));
            int min = Integer.parseInt(words[3].substring(2));
            String mm = (hour > 12) ? "pm" : "am";
            String wordMin = words[3].substring(2);
            System.out.println(hour + ":" + min);
            String d1 =  numOrdinal(Integer.parseInt(words[0])) + " of " + months[Integer.parseInt(words[1]) - 1] + " " +
                                    words[2] + ", " + (hour % 12) + ((min == 0) ? "": ("."+ wordMin)) + mm;
            //2nd of December 2019, 6pm
            System.out.println(d1);
            return d1;
        }
        catch (StringIndexOutOfBoundsException e) {
            return date;
        }
    }

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
                catch (IndexOutOfBoundsException e) {
                    System.out.println("\u2639 OOPS!!! The following task does not exist!");
                }

            }

            else if (input.startsWith("todo")) {
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

            else if (input.startsWith("deadline")) {
                try {
                    int index = input.indexOf("/by");
                    String info = input.substring(9, index);
                    String endDate = dateConvert(input.substring(index + 4));
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

            else if (input.startsWith("event")) {
                int index = input.indexOf("/at");
                String info = input.substring(6, index);
//                String endDate = input.substring(index + 4);
                String endDate = dateConvert(input.substring(index + 4));
                Event event = new Event(info, false, endDate);
                list.add(event);
                System.out.println("Got it. I've added this task:\n " +
                        list.get(list.size() - 1).toString()+ "\n" +
                        "Now you have " + (list.size()) + " tasks in the list.");
                FileOp save = new FileOp();
                save.saveFile("E", event, event.getDate());
            }

            else if(input.startsWith("delete")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                System.out.println("Noted. I've removed this task:\n " +
                        list.get(index).toString());
                System.out.println("Now you have " + (list.size() - 1) + " tasks in the list.");
                list.remove(index);
                FileOp save = new FileOp();
                save.updateFile(list);
            }

            
            else {
               System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

        }
    }


}
