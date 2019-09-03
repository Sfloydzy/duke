import java.util.Scanner;

import Task.*;

public class Duke {
    private static Ui ui = new Ui();

    public static void run() {
        ui.welcome();
        TaskList.addAllList();

        while (true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("bye")){
                ui.goodbye();
              break;
            }
            ui.readCommand(input);
        }
    }

    public static void main(String[] args) throws DukeException {
        Duke.run();
    }

}
