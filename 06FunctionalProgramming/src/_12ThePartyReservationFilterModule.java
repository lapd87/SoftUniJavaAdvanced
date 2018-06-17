import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:57 ч.
 */
public class _12ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        boolean[] hidden = new boolean[input.length];
        Arrays.fill(hidden, Boolean.FALSE);

        String command;
        while (!"Print".equals(command = console.nextLine())) {

            String[] commandArgs = command.split(";");

            String actionType = commandArgs[0];
            String actionCondition = commandArgs[1];
            String actionArg = commandArgs[2];

            Predicate<String> filter = filtering(actionCondition, actionArg);

            if (filter == null) {
                continue;
            }

            boolean hide = false;

            if ("Add filter".equals(actionType)) {
                hide = true;
            }

            for (int i = 0; i < hidden.length; i++) {
                if (filter.test(input[i])) {
                    hidden[i] = hide;
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (!hidden[i]) {
                System.out.print(input[i] + " ");
            }
        }
    }

    private static Predicate<String> filtering(String actionCondition, String actionArg) {

        switch (actionCondition) {
            case "Starts with":
                return g -> g.startsWith(actionArg);
            case "Ends with":
                return g -> g.endsWith(actionArg);
            case "Length":
                return g -> g.length() == Integer.parseInt(actionArg);
            case "Contains":
                return g -> g.contains(actionArg);
            default:
                return null;
        }
    }
}