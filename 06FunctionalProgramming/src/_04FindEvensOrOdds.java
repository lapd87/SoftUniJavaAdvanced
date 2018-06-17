import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:55 ч.
 */
public class _04FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = console.nextLine();

        Predicate<Integer> odds = n -> Math.abs(n % 2) == 1;
        Predicate<Integer> evens = n -> n % 2 == 0;

        if (command.equals("odd")) {
            Print(input, odds);
        } else {
            Print(input, evens);
        }

    }

    private static void Print(int[] input, Predicate<Integer> type) {
        int lowerBound = input[0];
        int upperBound = input[1];

        if (!type.test(lowerBound)) {
            lowerBound++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = lowerBound; i <= upperBound; i += 2) {
            stringBuilder.append(i).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }
}