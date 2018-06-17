import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:57 ч.
 */
public class _11PredicateParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        List<String> guest = new ArrayList<>();

        for (String s : input) {
            guest.add(s);
        }

        Predicate<String> filter;

        String commandArgs;
        while (!"Party!".equals(commandArgs = console.nextLine())) {

            String[] command = commandArgs.split("\\s+");

            String actionType = command[0];
            String actionCondition = command[1];
            String actionArg = command[2];

            if ("StartsWith".equals(actionCondition)) {
                filter = n -> n.startsWith(actionArg);
            } else if ("EndsWith".equals(actionCondition)) {
                filter = n -> n.endsWith(actionArg);
            } else if ("Length".equals(actionCondition)) {
                filter = n -> n.length() == Integer.parseInt(actionArg);
            } else {
                filter = null;
            }

            if (filter == null) {
                continue;
            }

            if ("Remove".equals(actionType)) {
                guest.removeIf(filter);
            } else {
                for (int i = 0; i < guest.size(); i++) {
                    if (filter.test(guest.get(i))) {
                        guest.add(i, guest.get(i));
                        i++;
                    }
                }
            }
        }

        if (guest.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!%n",
                    String.join(", ", guest));
        }
    }
}