import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:27 ч.
 */
public class _001TakeTwo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(input)
                .distinct()
                .filter(x -> x >= 10 && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}