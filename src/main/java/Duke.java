import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        ArrayList<item> a = new ArrayList<>();
        int cnt = 0;
        while(true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (input.equals("list")) {
                for (item s: a) {
                    System.out.println(s.getIndex() + ".["+ s.getStatusIcon() + "] " + s.getInfo());
                }
            }

            else if (input.contains("done")) {
               int index = Integer.parseInt(input.substring(input.length() - 1));
                a.get(index).changeStatus();
                System.out.println("Nice! I've marked this task as done:\n " +
                        "["+ a.get(index).getStatusIcon() + "] " + a.get(index).getInfo());
            }

            else {
                ++cnt;
                item data = new item(input, cnt);
                a.add(data);
                System.out.println("added: " + input);
            }
        }
    }
}
