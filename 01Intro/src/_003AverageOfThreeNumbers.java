import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:19 ч.
 */
public class _003AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += console.nextDouble();
        }

        System.out.printf("%.2f%n", sum / 3);
    }
}