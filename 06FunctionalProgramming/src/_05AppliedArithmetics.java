import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:56 ч.
 */
public class _05AppliedArithmetics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command;
        while (!"end".equals(command = console.nextLine())) {

            if ("print".equals(command)) {
                for (int num : input) {
                    System.out.print(num + " ");
                }
                System.out.println();
                continue;
            }

            Function<Integer, Integer> action = applyCommand(command);

            for (int i = 0; i < input.length; i++) {
                input[i] = action.apply(input[i]);
            }
        }
    }

    private static Function<Integer, Integer> applyCommand(String command) {
        switch (command) {
            case "add":
                return n -> n + 1;
            case "multiply":
                return n -> n * 2;
            case "subtract":
                return n -> n - 1;
            default:
                return n -> n;
        }
    }
}