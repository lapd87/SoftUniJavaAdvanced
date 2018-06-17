import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:58 ч.
 */
public class _14SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int operationsCount = Integer.parseInt(console.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String[] commandArgs = console.nextLine()
                    .split("\\s+");

            String command = commandArgs[0];
            String argument = "";
            if (commandArgs.length > 1) {
                argument = commandArgs[1];
            }

            String currentText = stack.peek();

            if (currentText == null) {
                currentText = "";
            }

            switch (command) {
                case "1":
                    stack.push(currentText + argument);
                    break;
                case "2":
                    int eraseCount = Integer.parseInt(argument);

                    stack.push(currentText
                            .substring(0, currentText.length() - eraseCount));
                    break;
                case "3":
                    int charIndex = Integer.parseInt(argument);

                    System.out.println(currentText
                            .charAt(charIndex - 1));
                    break;
                case "4":
                    stack.pop();
                    break;
            }
        }
    }
}