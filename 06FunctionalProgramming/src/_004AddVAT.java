import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:54 ч.
 */
public class _004AddVAT {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double[] input = Arrays.stream(console.nextLine()
                .split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        UnaryOperator<Double> addVAT = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        for (double num : input) {
            System.out.printf("%.2f%n", addVAT.apply(num));
        }
    }
}