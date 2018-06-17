import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:55 ч.
 */
public class _03CustomMinFunction {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> min = numbers -> {
            int minNum = Integer.MAX_VALUE;
            for (int num : numbers) {
                if (num < minNum) {
                    minNum = num;
                }
            }
            return minNum;
        };

        System.out.println(min.apply(input));
    }
}