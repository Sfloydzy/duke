import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        ArrayList<String> a = new ArrayList<>();
        int cnt = 0;
        while(true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (input.equals("list")) {
                for (String s: a) {
                    System.out.println(s);
                }
            }
            else {
                ++cnt;
                a.add(cnt + ". " + input);
                System.out.println("added: " + input);
            }
        }

    }

}
