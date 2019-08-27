import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        item[] task = new item[100];
        int cnt = 0;
        while(true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (input.equals("list")) {
                for (item i: task) {
                    if (i != null) {
                        System.out.println(i.getIndex() + "." + i.toString());
                    }
                    else break;
                }
            }

            else if (input.contains("done")) {
               int index = Integer.parseInt(input.substring(5)) - 1;
                task[index].changeStatus();
                System.out.println("Nice! I've marked this task as done:\n " +
                        task[index].toString());
            }

            else if (input.contains("todo")) {
                String info = input.substring(5);
                task[cnt] = new ToDo(info, ++cnt);
                System.out.println("Got it. I've added this task:\n " +
                        task[cnt-1].toString()+"\n" +
                        "Now you have " + cnt + " tasks in the list.");
            }

            else if (input.contains("deadline")) {
                int index = input.indexOf("/by");
                String info = input.substring(9, index);
                String endDate = input.substring(index + 4);
                task[cnt] = new Deadline(info, ++cnt, endDate);
                System.out.println("Got it. I've added this task:\n " +
                        task[cnt-1].toString()+ "\n" +
                        "Now you have " + cnt + " tasks in the list.");
            }

            else if (input.contains("event")) {
                int index = input.indexOf("/at");
                String info = input.substring(6, index);
                String endDate = input.substring(index + 4);
                task[cnt] = new Event(info, ++cnt, endDate);
                System.out.println("Got it. I've added this task:\n " +
                        task[cnt-1].toString()+ "\n" +
                        "Now you have " + cnt + " tasks in the list.");
            }

            else {
                task[cnt] = new item (input, ++cnt);
                System.out.println("added: " + input);
            }
        }
    }
}
