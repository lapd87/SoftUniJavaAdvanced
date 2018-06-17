import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:54 ч.
 */
public class _002SumNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split(", ");

        Function<String, Integer> parser = x -> Integer.parseInt(x);

        int sum = 0;
        for (String s : input) {
            sum += parser.apply(s);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}