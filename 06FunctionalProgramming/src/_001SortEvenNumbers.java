import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:53 ч.
 */
public class _001SortEvenNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(input).forEach(numbers::add);

        numbers.removeIf(n -> n % 2 != 0);

        System.out.println(numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .trim());

        numbers.sort((a, b) -> a.compareTo(b));

        System.out.println(numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .trim());
    }
}