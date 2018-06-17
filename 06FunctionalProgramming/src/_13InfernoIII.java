import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:57 ч.
 */
public class _13InfernoIII {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[] exclude = new boolean[input.length];
        Arrays.fill(exclude, Boolean.FALSE);

        String command;
        while (!"Forge".equals(command = console.nextLine())) {

            String[] commandArgs = command.split(";");

            String actionType = commandArgs[0];
            String actionCondition = commandArgs[1];
            int actionArg = Integer.parseInt(commandArgs[2]);


            Predicate<Integer> filter = filtering(actionCondition, actionArg, input);

            if (filter == null) {
                continue;
            }

            boolean hide = false;

            if ("Exclude".equals(actionType)) {
                hide = true;
            }

            for (int i = 0; i < exclude.length; i++) {
                if (filter.test(i)) {
                    exclude[i] = hide;
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (!exclude[i]) {
                System.out.print(input[i] + " ");
            }
        }
    }

    private static Predicate<Integer> filtering(String actionCondition, int actionArg, int[] input) {
        switch (actionCondition) {
            case "Sum Left":
                return x -> (x > 0 ? input[x - 1] : 0)
                        + input[x] == actionArg;
            case "Sum Right":
                return x -> (x < input.length - 1 ? input[x + 1] : 0)
                        + input[x] == actionArg;
            case "Sum Left Right":
                return x -> (x > 0 ? input[x - 1] : 0)
                        + (x < input.length - 1 ? input[x + 1] : 0) + input[x] ==
                        actionArg;
            default:
                return null;
        }
    }
}