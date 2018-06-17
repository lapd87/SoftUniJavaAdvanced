import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:55 ч.
 */
public class _02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        Consumer<String> printSir = s -> System.out.println("Sir " + s);

        for (String s : input) {
            printSir.accept(s);
        }
    }
}