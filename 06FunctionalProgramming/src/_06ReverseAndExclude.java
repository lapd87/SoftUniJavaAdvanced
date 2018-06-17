import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:56 ч.
 */
public class _06ReverseAndExclude {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int divisor = Integer.parseInt(console.nextLine());

        Predicate<Integer> divisible = n -> n % divisor == 0;

        for (int i = input.length - 1; i >= 0; i--) {
            if (!divisible.test(input[i])) {
                System.out.print(input[i] + " ");
            }
        }
    }
}