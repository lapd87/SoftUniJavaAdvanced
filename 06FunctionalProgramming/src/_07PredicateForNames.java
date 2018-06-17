import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:56 ч.
 */
public class _07PredicateForNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int length = Integer.parseInt(console.nextLine());

        String[] input = console.nextLine()
                .split("\\s+");

        Predicate<String> checker = n -> n.length() <= length;

        for (String s : input) {
            if (checker.test(s)) {
                System.out.println(s);
            }
        }
    }
}