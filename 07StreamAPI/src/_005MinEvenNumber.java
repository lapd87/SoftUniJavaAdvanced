import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:28 ч.
 */
public class _005MinEvenNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        OptionalDouble input = Arrays.stream(console.nextLine()
                .split(" "))
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(x -> x % 2 == 0)
                .min();

        System.out.println(input.isPresent() ?
                String.format("%.2f", input.getAsDouble())
                : "No match");
    }
}