
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:32 ч.
 */
public class _001StudentsResults {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split(" - ");

        String name = input[0];

        double[] results = Arrays.stream(input[1]
                .split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double average = Arrays.stream(results)
                .average()
                .getAsDouble();

        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|%n",
                name, results[0], results[1], results[2], average);
    }
}