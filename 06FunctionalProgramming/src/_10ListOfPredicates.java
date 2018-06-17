import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:57 ч.
 */
public class _10ListOfPredicates {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> divisors = new HashSet<>();

        for (int num : input) {
            divisors.add(num);
        }

        BiPredicate<Integer, Set<Integer>> divisible = (number, set) -> {
            for (int num : set) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        };


        for (int i = 1; i <= n; i++) {
            if (divisible.test(i, divisors)) {
                System.out.print(i + " ");
            }
        }
    }
}