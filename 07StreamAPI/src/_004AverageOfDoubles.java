import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:28 ч.
 */
public class _004AverageOfDoubles {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println(Arrays.stream(input).average().isPresent()
                ? String.format("%.2f", Arrays.stream(input).average().getAsDouble())
                : "No match");
    }
}