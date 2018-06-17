import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:27 ч.
 */
public class _002UpperStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        Arrays.stream(input)
                .forEach(x -> System.out.print(x.toUpperCase() + " "));
    }
}