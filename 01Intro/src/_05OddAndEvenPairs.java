import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:23 ч.
 */
public class _05OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputNums = Arrays
                .stream(console.nextLine()
                        .split("\\s+", -1))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (inputNums.length % 2 == 1) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < inputNums.length - 1; i += 2) {
            int firstNum = inputNums[i];
            int secondNum = inputNums[i + 1];

            if (firstNum % 2 == 0 && secondNum % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n",
                        firstNum, secondNum);
            } else if (firstNum % 2 == 1 && secondNum % 2 == 1) {
                System.out.printf("%d, %d -> both are odd%n",
                        firstNum, secondNum);
            } else {
                System.out.printf("%d, %d -> different%n",
                        firstNum, secondNum);
            }
        }
    }
}