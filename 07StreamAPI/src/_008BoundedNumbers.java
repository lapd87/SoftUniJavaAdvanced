import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:28 ч.
 */
public class _008BoundedNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] bounds = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lowerBound = Math.min(bounds[0],bounds[1]);
        int upperBound = Math.max(bounds[0],bounds[1]);

        int[] nums = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(nums)
                .filter(n -> n >= lowerBound && n <= upperBound)
                .forEach(n -> System.out.print(n + " "));
    }
}